package by.mdhtrnk.demouniversity.service;

import by.mdhtrnk.demouniversity.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest extends BaseTest{

    @Autowired
    private StudentService studentService;

    @Test
    @Override
    void testFindAll() {
        List<Student> allStudents = studentService.findAll();
        assertEquals(12,allStudents.size());
    }
    @Test
    @Override
    void testSave() {
        Student savedStudent = studentService.save(new Student("Anna", "Petrova"));
        assertNotNull(savedStudent.getId());
    }
    @Test
    void testDeleteById() {
        studentService.deleteById(1L);
        assertEquals(Optional.empty(),studentService.findById(1L));
    }
    @Test
    @Override
    void testFindById() {
        Optional<Student> student = studentService.findById(1L);
        assertTrue(student.isPresent());
        student.ifPresent(entity -> {
            assertEquals("Liza", entity.getFirstName());
            assertEquals("Smirnova", entity.getLastName());
            assertNotNull(entity.getGroup());
        });
    }
    @Test
    @Override
    void testUpdate() {
        Student student = new Student("Dima", "Ivanov");
        student.setId(1L);
        Student updatedStudent = studentService.save(student);
        assertNull(updatedStudent.getGroup());
    }
}