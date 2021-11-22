package by.mdhtrnk.demouniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false, exclude = {"students","timetableList"})
@Entity
@Table(name = "groups")
public class Group extends BaseEntity{

    public Group(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Column(name = "group_number", nullable = false, unique = true)
    private String groupNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Student> students = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "grouppp", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Timetable> timetableList = new HashSet<>();

    public void addTimetables(Timetable... timetables){
        timetableList.addAll(Set.of(timetables));
        Arrays.stream(timetables).forEach(s -> s.setGrouppp(this));
    }

    public void removeTimetables(Timetable... timetables){
        Set.of(timetables).forEach(timetableList::remove);
    }

    public void addStudents(Student... students){
        this.students.addAll(Set.of(students));
        Arrays.stream(students).forEach(s -> s.setGroup(this));
    }
    public void removeStudents(Student... students){
        Set.of(students).forEach(this.students::remove);
    }

}
