package by.mdhtrnk.demouniversity.service;

import by.mdhtrnk.demouniversity.entity.Group;
import by.mdhtrnk.demouniversity.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

class GroupServiceTest extends BaseTest{

    @Autowired
    private GroupService groupService;

    @Test
    @Override
    void testFindById(){
        Optional<Group> group = groupService.findById(1L);
        assertTrue(group.isPresent());
        group.ifPresent(entity -> {
            assertEquals("10316", entity.getGroupNumber());
            assertThat(entity.getStudents(), hasSize(4));
            assertThat(entity.getStudents(), containsInAnyOrder(new Student("Ivan","Ivanov"),
                    new Student("Vasia", "Vasiliev"),
                    new Student("Masha", "Ivanova"),
                    new Student("Liza", "Smirnova")));
            assertNotNull(entity.getTimetableList());
            assertThat(entity.getTimetableList(), hasSize(5));
        });
    }
    @Test
    @Override
    void testSave(){
        Group group = new Group("10923");
        group.addStudents(new Student("Tom","Hardy"),
                new Student("Dwayne", "Johnson"),
                new Student("Emma", "Stone"));
        Group savedGroup = groupService.save(group);
        assertNotNull(savedGroup.getId());
    }
    @Test
    @Override
    void testFindAll(){
        List<Group> allGroups = groupService.findAll();
        assertEquals(3,allGroups.size());
    }
    @Test
    @Override
    void testUpdate(){
        Group group = new Group("10106");
        group.setId(1L);
        group.addStudents(new Student("Emma", "Stone"),
                new Student("Tom", "Hanks"));
        Group updatedGroup = groupService.save(group);
        assertEquals(2, updatedGroup.getStudents().size());
    }
    @Test
    void testDeleteById(){
        groupService.deleteById(1L);
        assertEquals(2, groupService.findAll().size());
    }
}