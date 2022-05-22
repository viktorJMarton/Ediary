package com.epam.ediary.view;

import com.epam.ediary.domain.Course;
import com.epam.ediary.domain.Grade;
import com.epam.ediary.domain.Student;
import com.epam.ediary.domain.Teacher;

import java.util.ArrayList;
import java.util.List;

public interface TeacherView {

    public void printWelcomeMessage(Teacher teacher);
    public void printCourses(List<Course> courses);
    public Course   selectCourse(List<Course> courses);
    public void printStudents(List<Student> students);
    public Student selectStudent(List<Student> students);
    public int readGrade();
    public void printGrade(Grade grade);


}
