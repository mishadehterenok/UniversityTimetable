package by.mdhtrnk.demouniversity.service;

import by.mdhtrnk.demouniversity.entity.Student;
import by.mdhtrnk.demouniversity.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements BaseService<Student> {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void saveAll(Iterable<Student> entities) {
        studentRepository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
