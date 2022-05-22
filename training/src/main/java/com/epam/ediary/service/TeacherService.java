package com.epam.ediary.service;

import com.epam.ediary.domain.*;

import java.util.List;

public interface TeacherService {

    public List<Course> findCoursesByTeacher(Teacher teacher);
    public List<Student> getStudentsFromCourse(Course course);
    public Grade        createGrade(Student student,Course course,int value);

}
