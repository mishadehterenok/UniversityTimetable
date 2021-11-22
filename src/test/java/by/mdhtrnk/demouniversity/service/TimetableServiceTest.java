package by.mdhtrnk.demouniversity.service;

import by.mdhtrnk.demouniversity.dto.StudentDto;
import by.mdhtrnk.demouniversity.entity.Day;
import by.mdhtrnk.demouniversity.entity.Subject;
import by.mdhtrnk.demouniversity.entity.Timetable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;

class TimetableServiceTest extends BaseTest{

    @Autowired
    private TimetableService timetableService;

    @Test
    void testGetTimetableByStudentDto(){
        StudentDto studentDto = new StudentDto("Masha", "Ivanova", Day.MONDAY);
        Timetable timetable = timetableService.getTimetableByStudentDto(studentDto);
        assertNotNull(timetable);
        assertEquals(Day.MONDAY, timetable.getDayOfWeek());
        assertEquals(3, timetable.getSubjects().size());
        assertThat(timetable.getSubjects(), containsInAnyOrder(new Subject("Literacy"),
                new Subject("Mathematics"),
                new Subject("Biology")));
    }
    @Test
    @Override
    void testFindAll() {
        List<Timetable> allTimetables = timetableService.findAll();
        assertEquals(15,allTimetables.size());
    }
    @Test
    @Override
    void testSave() {
        Timetable timetable = new Timetable(Day.FRIDAY);
        timetable.addSubjects(new Subject("OOP"), new Subject("SOLID"), new Subject("Patterns"));
        Timetable savedTimetable = timetableService.save(timetable);
        assertNotNull(savedTimetable.getId());
    }
    @Test
    void testDeleteById() {
        timetableService.deleteById(1L);
        assertEquals(Optional.empty(), timetableService.findById(1L));
    }
    @Test
    @Override
    void testFindById() {
        Optional<Timetable> timetable = timetableService.findById(1L);
        assertTrue(timetable.isPresent());
        timetable.ifPresent(entity -> {
            assertEquals(Day.valueOf(entity.getDayOfWeek().toString()), entity.getDayOfWeek());
            assertFalse(entity.getSubjects().isEmpty());
        });
    }
    @Test
    @Override
    void testUpdate() {
        Timetable timetable = new Timetable(Day.THURSDAY);
        timetable.addSubjects(new Subject("OOP"), new Subject("SOLID"), new Subject("Patterns"));
        timetable.setId(1L);
        Timetable updatedTimetable = timetableService.save(timetable);
        assertEquals(Day.THURSDAY, updatedTimetable.getDayOfWeek());
    }
}