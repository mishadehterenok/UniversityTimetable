package by.mdhtrnk.demouniversity.service;

import by.mdhtrnk.demouniversity.dto.StudentDto;
import by.mdhtrnk.demouniversity.entity.Group;
import by.mdhtrnk.demouniversity.entity.Timetable;
import by.mdhtrnk.demouniversity.exceptionHandling.exception.IncorrectRequestBodyException;
import by.mdhtrnk.demouniversity.repository.GroupRepository;
import by.mdhtrnk.demouniversity.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimetableService implements BaseService<Timetable> {

    private final TimetableRepository timetableRepository;
    private final GroupRepository groupRepository;

    @Autowired
    public TimetableService(TimetableRepository timetableRepository, GroupRepository groupRepository) {
        this.timetableRepository = timetableRepository;
        this.groupRepository = groupRepository;
    }

    public Timetable getTimetableByStudentDto(StudentDto studentDto){
        Group group = groupRepository.findByStudentName(studentDto.getFirstName(), studentDto.getLastName());
        if (group == null){
            throw new IncorrectRequestBodyException("Incorrect request body! Try again...");
        } else {
            return timetableRepository.findByDayOfWeekAndGrouppp_Id(studentDto.getDayOfWeek(), group.getId());
        }
    }

    @Override
    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }

    @Override
    public Timetable save(Timetable timetable) {
        return timetableRepository.save(timetable);
    }

    @Override
    public Optional<Timetable> findById(Long id) {
        return timetableRepository.findById(id);
    }

    @Override
    public void saveAll(Iterable<Timetable> entities) {
        timetableRepository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        timetableRepository.deleteById(id);
    }
}
