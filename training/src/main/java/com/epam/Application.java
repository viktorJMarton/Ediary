package com.epam;

import com.epam.ediary.domain.*;
import com.epam.ediary.presistence.*;
import com.epam.ediary.service.*;
import com.epam.ediary.view.*;
import com.epam.ediary.view.ConsoleUserView;

import java.io.IOException;

import java.text.ParseException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws AuthenticationException, IOException, ParseException {

        DefaultDataStore dataStore = new DefaultDataStore("input/");

        dataStore.init();

        ConsoleUserView userView = new ConsoleUserView();
        DefaultUserService userService= new DefaultUserService(dataStore);
        User loggedInUser= userService.authenticate(userView.readCredentials());

        if( loggedInUser instanceof Teacher){
            Teacher teacher= (Teacher) loggedInUser;
            ConsoleTeacherView View =new ConsoleTeacherView();
            DefaultTeacherService Service= new DefaultTeacherService(dataStore);
            List<Course> coursesOfTeacher= Service.findCoursesByTeacher(teacher);

            View.printWelcomeMessage(teacher);
            View.printCourses(coursesOfTeacher);

            Course selectedCourse=View.selectCourse(coursesOfTeacher);
            List<Student> studentsOfCourse = Service.getStudentsFromCourse(selectedCourse);




            View.printStudents(studentsOfCourse);

            Student selectedStudent=  View.selectStudent(studentsOfCourse);
            int gradeValue= View.readGrade();
            Grade createdGrade= Service.createGrade(selectedStudent,selectedCourse,gradeValue);
            View.printGrade(createdGrade);

            dataStore.saveGrade(createdGrade);
       }

        if( loggedInUser instanceof Student){
          Student student =(Student) loggedInUser;
          ConsoleStudentView View= new ConsoleStudentView();
            DefaultStudentService Service = new DefaultStudentService(dataStore);
          List<Course> coursesOfStudent = Service.findCoursesByStudent(student);

            View.printWelcomeMessage(student);



            do {
                View.printCourses(coursesOfStudent);
                View.printGrades(Service.findGradesByStudentAndCourse(student, View.selectCourse(coursesOfStudent)));
            }while (!View.isFinished());


        }



        //System.exit(0);
    }




}