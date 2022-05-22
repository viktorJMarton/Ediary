package com.epam.ediary.service;
import com.epam.ediary.domain.Course;
import com.epam.ediary.domain.Grade;
import com.epam.ediary.domain.Student;
import com.epam.ediary.presistence.DataStore;

import java.util.ArrayList;
import java.util.List;

public class DefaultStudentService implements StudentService {

   final private DataStore dataStore;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public DefaultStudentService(DataStore dataStore) {
        this.dataStore = dataStore;
    }



    @Override
    public List<Course> findCoursesByStudent(Student student) {
        List<Course> courses= new ArrayList<Course>();

        for(Course c: dataStore.getCourses()){
            if(c.getSchoolClass().getName().equals(student.getSchoolClass().getName())){
                courses.add(c);
            }
        }


        return courses;
    }

    @Override
    public List<Grade> findGradesByStudentAndCourse(Student student, Course course) {
        List<Grade> grades=new ArrayList<Grade>();



        for(Grade g: dataStore.getGrades()){

            if(g.getStudent().getName().equals(student.getName()) ){
                grades.add(g);
            }

        }


        return grades;
    }
}
