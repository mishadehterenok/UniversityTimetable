package by.mdhtrnk.demouniversity.service;

import by.mdhtrnk.demouniversity.entity.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SubjectServiceTest extends BaseTest{

    @Autowired
    private SubjectService subjectService;

    @Test
    @Override
    void testFindAll() {
        List<Subject> allSubjects = subjectService.findAll();
        assertEquals(15,allSubjects.size());
    }
    @Test
    @Override
    void testSave() {
        Subject savedSubject = subjectService.save(new Subject( "Power Engineering"));
        assertNotNull(savedSubject.getId());
    }
    @Test
    @Override
    void testFindById() {
        Optional<Subject> subject = subjectService.findById(1L);
        assertTrue(subject.isPresent());
        subject.ifPresent(entity -> {
            assertEquals("Art", entity.getName());
            assertFalse(entity.getTimetableList().isEmpty());
        });
    }
    @Test
    @Override
    void testUpdate() {
        Subject subject = new Subject( "Spring Core");
        subject.setId(1L);
        Subject updatedSubject = subjectService.save(subject);
        assertTrue(updatedSubject.getTimetableList().isEmpty());
    }
}