package org.lidaafrica.request.laf.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseService {

    private final CourseDataAccessService courseDataAccessService;

    @Autowired
    public CourseService(CourseDataAccessService courseDataAccessService) {
        this.courseDataAccessService = courseDataAccessService;
    }

    List<Course> getAllCoursesForStudent(UUID studentId) {
        return courseDataAccessService.selectAllStudentCourses(studentId);
    }
}
