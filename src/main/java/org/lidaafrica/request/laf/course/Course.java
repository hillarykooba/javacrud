package org.lidaafrica.request.laf.course;

import java.time.LocalDate;
import java.util.UUID;

public class Course {

    private final UUID studentId;
    private final UUID courseId;
    private final String name;
    private  final String description;
    private final String department;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Integer grade;

    public Course(UUID studentId,
                  UUID courseId,
                  String name,
                  String description,
                  String department,
                  LocalDate startDate,
                  LocalDate endDate,
                  Integer grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.department = department;
        this.startDate = startDate;
        this.endDate = endDate;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Course{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public UUID getStudentId() {
        return studentId;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDepartment() {
        return department;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Integer getGrade() {
        return grade;
    }
}
