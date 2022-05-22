package com.epam.ediary.presistence;


import com.epam.ediary.domain.*;


import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface DataStore {

    public void init() throws IOException, ParseException;
    public List<Student> getStudents();
    public List<Teacher> getTeachers();
    public List<Course> getCourses();
    public List<Grade> getGrades();
    public void saveGrade(Grade grade) throws IOException;
}
