package org.lidaafrica.request.laf.course;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CourseDataAccessService {

    private final JdbcTemplate jdbcTemplate;

    public CourseDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<Course> selectAllStudentCourses(UUID studentId) {

        String sql = "" +
                "SELECT " +
                "student.student_id, " +
                "course.course_id, " +
                "course.name, " +
                "course.description, " +
                "course.department, " +
                "course.teacher_name, " +
                "student_course.start_date, " +
                "student_course.end_date, " +
                "student_course.grade " +
                "FROM student " +
                "JOIN student_course USING (student_id) " +
                "JOIN course USING (course_id) " +
                "WHERE student.student_id= ?";

        return jdbcTemplate.query(sql, new Object[] {studentId}, mapStudentCourseFromDb());
    }

    private RowMapper<Course> mapStudentCourseFromDb() {
        return (resultSet, i) ->
           new Course(
                   UUID.fromString(resultSet.getString("student_id")),
                   UUID.fromString(resultSet.getString("course_id")),
                   resultSet.getString("name"),
                   resultSet.getString("description"),
                   resultSet.getString("department"),
                   resultSet.getDate("start_date").toLocalDate(),
                   resultSet.getDate("end_date").toLocalDate(),
                   Optional.ofNullable(resultSet.getString("grade"))
                           .map(Integer::parseInt)
                           .orElse(null)
           );
    }
}
