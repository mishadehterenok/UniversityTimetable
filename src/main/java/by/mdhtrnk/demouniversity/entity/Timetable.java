package by.mdhtrnk.demouniversity.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true, exclude = "grouppp")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "subjects")
@Entity
@Table(name = "timetable")
@JsonRootName(value = "timetable")
@JsonPropertyOrder({ "grouppp", "dayOfWeek", "subjects" })
public class Timetable extends BaseEntity{

    public Timetable(Day dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonProperty("group")
    private Group grouppp;

    @Column(name = "day_of_week", nullable = false)
    @Enumerated(EnumType.STRING)
    private Day dayOfWeek;

    @ManyToMany
    @JoinTable( name = "timetable_subjects",
            joinColumns = @JoinColumn(name = "timetable_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjects = new HashSet<>();

    public void addSubjects(Subject... subjects){
        this.subjects.addAll(List.of(subjects));
        List.of(subjects).forEach(s -> s.addTimetable(this));
    }
    public void removeSubjects(Subject... subjects){
        List.of(subjects).forEach(this.subjects::remove);
        Arrays.stream(subjects).forEach(s -> s.removeTimetable(this));
    }
}
