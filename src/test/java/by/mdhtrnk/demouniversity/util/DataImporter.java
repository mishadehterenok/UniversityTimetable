package by.mdhtrnk.demouniversity.util;

import by.mdhtrnk.demouniversity.entity.*;
import by.mdhtrnk.demouniversity.repository.GroupRepository;
import by.mdhtrnk.demouniversity.repository.SubjectRepository;
import by.mdhtrnk.demouniversity.service.GroupService;
import by.mdhtrnk.demouniversity.service.SubjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class DataImporter {

    @Autowired
    private GroupService groupService;
    @Autowired
    private SubjectService subjectService;

    @Test
    public void importTestData(){
        Group group1 = new Group("10316");
            group1.addStudents(new Student("Ivan","Ivanov"),
                new Student("Vasia", "Vasiliev"),
                new Student("Masha", "Ivanova"),
                new Student("Liza", "Smirnova"));
        Group group2 = new Group("10518");
            group2.addStudents(new Student("Chris","Evans"),
                new Student("Jared", "Leto"),
                new Student("Johnny", "Depp"),
                new Student("Max", "Payne"));
        Group group3 = new Group("10721");
            group3.addStudents(new Student("Ryan","Gosling"),
                new Student("Brad", "Pitt"),
                new Student("Matt", "Daemon"),
                new Student("Will", "Smith"));

        Subject art = new Subject("Art");
        Subject literacy = new Subject("Literacy");
        Subject music = new Subject("Music");
        Subject science = new Subject("Science");
        Subject arithmetic = new Subject("Arithmetic");
        Subject mathematics = new Subject("Mathematics");
        Subject chemistry = new Subject("Chemistry");
        Subject biology = new Subject("Biology");
        Subject physics = new Subject("Physics");
        Subject it = new Subject("Information Technology");
        Subject law = new Subject("Law");
        Subject design = new Subject("Design");
        Subject geometry = new Subject("Geometry");
        Subject sociology = new Subject("Sociology");
        Subject history = new Subject("History");

        subjectService.saveAll(List.of(art, literacy, music, science, arithmetic, mathematics,
                chemistry, biology, physics, it, design, law, design, geometry, sociology, history));

        Timetable gr1monday = new Timetable(Day.MONDAY);
            gr1monday.addSubjects(literacy, mathematics, biology);
        Timetable gr1tuesday = new Timetable(Day.TUESDAY);
            gr1tuesday.addSubjects(music, physics, law);
        Timetable gr1wednesday = new Timetable(Day.WEDNESDAY);
            gr1wednesday.addSubjects(design, mathematics, geometry);
        Timetable gr1thursday = new Timetable(Day.THURSDAY);
            gr1thursday.addSubjects(literacy, law, biology);
        Timetable gr1friday = new Timetable(Day.FRIDAY);
            gr1friday.addSubjects(sociology, history, biology);

        group1.addTimetables(gr1monday, gr1tuesday, gr1wednesday, gr1thursday, gr1friday);

        Timetable gr2monday = new Timetable(Day.MONDAY);
            gr2monday.addSubjects(art, science, arithmetic);
        Timetable gr2tuesday = new Timetable(Day.TUESDAY);
            gr2tuesday.addSubjects(physics, arithmetic, chemistry);
        Timetable gr2wednesday = new Timetable(Day.WEDNESDAY);
            gr2wednesday.addSubjects(sociology, design,physics );
        Timetable gr2thursday = new Timetable(Day.THURSDAY);
            gr2thursday.addSubjects(chemistry, it, sociology);
        Timetable gr2friday = new Timetable(Day.FRIDAY);
            gr2friday.addSubjects(it, history, arithmetic);

        group2.addTimetables(gr2monday, gr2tuesday, gr2wednesday, gr2thursday, gr2friday);

        Timetable gr3monday = new Timetable(Day.MONDAY);
            gr3monday.addSubjects(art, law, design);
        Timetable gr3tuesday = new Timetable(Day.TUESDAY);
            gr3tuesday.addSubjects(it, biology, science);
        Timetable gr3wednesday = new Timetable(Day.WEDNESDAY);
            gr3wednesday.addSubjects(literacy, law, art);
        Timetable gr3thursday = new Timetable(Day.THURSDAY);
            gr3thursday.addSubjects(science, music, design);
        Timetable gr3friday = new Timetable(Day.FRIDAY);
            gr3friday.addSubjects(literacy, biology, it);

        group3.addTimetables(gr3monday, gr3tuesday, gr3wednesday, gr3thursday, gr3friday);

        groupService.saveAll(List.of(group1, group2, group3));
    }


}
