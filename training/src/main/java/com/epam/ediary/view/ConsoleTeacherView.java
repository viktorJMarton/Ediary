package com.epam.ediary.view;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import com.epam.ediary.domain.Course;
import com.epam.ediary.domain.Grade;
import com.epam.ediary.domain.Student;
import com.epam.ediary.domain.Teacher;

import java.util.List;

import static java.lang.Integer.parseInt;

public class ConsoleTeacherView implements TeacherView{


    @Override
    public void printWelcomeMessage(Teacher teacher) {
        System.out.printf("Welcome teacher: %s \n",teacher.getName());
    }

    @Override
    public void printCourses(List<Course> courses) {
        System.out.println("Your Courses:");

        for (Course c :courses) {

            System.out.println((courses.indexOf(c)+1)+ ". Name:"+ c.getSubject()+", School Class:"+c.getSchoolClass().getName());

        }

    }

    @Override
    public Course selectCourse(List<Course> courses) {



        System.out.println("Choose the number of the course (between: 1-"+courses.size()+"):");

        Scanner sc = new Scanner(System.in);
        int num = parseInt(sc.next());
        while(num>courses.size() ||num<1){

            System.out.println("Input is not in range!");
            System.out.println("Choose the number of the course (between: 1-"+courses.size()+"):");

            num = parseInt(sc.next());

        }


        return courses.get(num-1);

    }

    @Override
    public void printStudents(List<Student> students) {
        System.out.println("the students of this course are:");
        for(Student s:students){
            System.out.println((students.indexOf(s)+1)+" Name: "+s.getName());
        }

    }

    @Override
    public Student selectStudent(List<Student> students) {

        System.out.println("Choose the number of student (between: 1-"+students.size()+"):");

        Scanner sc = new Scanner(System.in);
        int num = parseInt(sc.next());
        while(num>students.size() ||num<1){

            System.out.println("Input is not in range!");
            System.out.println("Choose the number of the course (between: 1-"+students.size()+"):");

            num = parseInt(sc.next());

        }


        return students.get(num-1);


    }

    @Override
    public int readGrade() {
       Scanner sc =new Scanner(System.in);
       System.out.print("Enter the grade value:");

       return parseInt(sc.next());


    }

    @Override
    public void printGrade(Grade grade) {
        DateFormat df = new SimpleDateFormat("yyy-MM-dd");
        String dateStr = df.format(grade.getDate());
        System.out.printf("Grade: "+grade.getValue()+", Name:"+grade.getStudent().getName()+", Date:"+dateStr);


    }
}
