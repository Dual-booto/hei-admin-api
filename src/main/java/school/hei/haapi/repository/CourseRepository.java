package school.hei.haapi.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import school.hei.haapi.model.Course;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    @Query("select c from Course c where " + "lower(c.code) like concat('%', lower(:code) , '%') and "
            + "lower(c.name) like concat('%', lower(:name), '%') and "
            + "(:credits is null or c.credits = :credits) and "
            + "(lower(c.mainTeacher.firstName) like concat('%', lower(:teacherFirstName), '%') or "
            + "lower(c.mainTeacher.lastName) like concat('%', lower(:teacherLastName), '%'))")
    List<Course> findByCriteria(
            @Param("code") String code,
            @Param("name") String name,
            @Param("credits") Integer credits,
            @Param("teacherFirstName") String teacherFirstName,
            @Param("teacherLastName") String teacherLastName,
            Pageable pageable);
}

