package com.epam.ediary.view;

import com.epam.ediary.domain.Course;
import com.epam.ediary.domain.Grade;
import com.epam.ediary.domain.Student;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ConsoleStudentView implements StudentView {
    public ConsoleStudentView() {
    }

    @Override
    public void printWelcomeMessage(Student student) {
        System.out.println("Welcome student:"+student.getName()+" your class is: "+student.getSchoolClass().getName());

    }

    @Override
    public void printCourses(List<Course> courses) {


        System.out.println("Your Courses:");
        for(Course c :courses){

            System.out.println((courses.indexOf(c)+1)+". "+c.getSubject());

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
    public void printGrades(List<Grade> grades) {


        System.out.print("Your Grades: " );

        for(Grade g:grades){
            System.out.print(g.getValue()+",");
        }
        System.out.println();

    }

    @Override
    public boolean isFinished() {


        System.out.print("Are you finished(y/n)?");
        Scanner sc = new Scanner(System.in);
        String yn = sc.next();
        if(yn.toString().equals("n")){

            return false;

        } else if (yn.toString().equals("y")) {


            return true;
        }
      return false;
    }
}
