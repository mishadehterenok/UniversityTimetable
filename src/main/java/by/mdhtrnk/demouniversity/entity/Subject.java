package by.mdhtrnk.demouniversity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true, exclude = "timetableList")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false, exclude = "timetableList")
@Entity
@Table(name = "subjects")
public class Subject extends BaseEntity {

    public Subject(String name) {
        this.name = name;
    }

    @Column(nullable = false, unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "subjects")
    private Set<Timetable> timetableList = new HashSet<>();

    public void addTimetable(Timetable timetable){
        timetableList.add(timetable);
    }
    public void removeTimetable(Timetable timetable){
        timetableList.remove(timetable);
    }
}
