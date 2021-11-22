package by.mdhtrnk.demouniversity.repository;

import by.mdhtrnk.demouniversity.entity.Day;
import by.mdhtrnk.demouniversity.entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {

    Timetable findByDayOfWeekAndGrouppp_Id(Day day, Long group_id);

}
