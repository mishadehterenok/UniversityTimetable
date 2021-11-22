package by.mdhtrnk.demouniversity.repository;

import by.mdhtrnk.demouniversity.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("select gr from Group gr where " +
            "(select st from Student st where st.firstName= :firstName and st.lastName= :lastName) " +
            "member of gr.students")
    Group findByStudentName(@Param("firstName") String firstName, @Param("lastName") String lastName);

}
