package com.epam.ediary.service;

import com.epam.ediary.domain.*;
import com.epam.ediary.presistence.DataStore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class DefaultTeacherService implements TeacherService {

    final private DataStore dataStore;


    public DefaultTeacherService(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Course> findCoursesByTeacher(Teacher teacher) {

        List<Course> courses= new ArrayList<Course>();

        for(Course c: dataStore.getCourses()){
            if(c.getTeacher().equals(teacher)){
                courses.add(c);
            }
        }


        return courses;


    }

    @Override
    public List<Student> getStudentsFromCourse(Course course) {
            List<Student> students= new ArrayList<Student>();
        for(Student s:dataStore.getStudents()){
            if(Objects.equals(s.getSchoolClass().getName(), course.getSchoolClass().getName())){
                students.add(s);
            }

        }


        return students;
    }

    @Override
    public Grade createGrade(Student student, Course course, int value) {
        Grade grade=new  Grade();
        grade.setCourse(course);
        grade.setStudent(student);
        grade.setValue(value);

        grade.setDate(new Date());

        return grade;
    }
}
