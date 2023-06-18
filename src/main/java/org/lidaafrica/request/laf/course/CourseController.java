package org.lidaafrica.request.laf.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return null;
    }

    @GetMapping(path = "{studentId}")
    public List<Course> getAllCoursesForStudent(@PathVariable("studentId") UUID studentId) {
        System.out.println(studentId);
        return courseService.getAllCoursesForStudent(studentId);
    }

}
