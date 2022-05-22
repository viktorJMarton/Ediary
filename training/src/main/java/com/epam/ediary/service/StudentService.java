package com.epam.ediary.service;

import com.epam.ediary.domain.Course;
import com.epam.ediary.domain.Grade;
import com.epam.ediary.domain.Student;

import java.util.List;

public interface StudentService
{

    public  List<Course> findCoursesByStudent(Student student);
    public  List<Grade>  findGradesByStudentAndCourse(Student student,Course course);

}
