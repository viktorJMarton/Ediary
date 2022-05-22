package com.epam.ediary.view;

import com.epam.ediary.domain.Course;
import com.epam.ediary.domain.Grade;
import com.epam.ediary.domain.Student;

import java.util.List;

public interface StudentView  {

    public void printWelcomeMessage(Student student);
    public void printCourses(List<Course> courses);
    public Course selectCourse(List<Course>courses);
    public void printGrades(List<Grade> grades);
    public boolean isFinished();

}
