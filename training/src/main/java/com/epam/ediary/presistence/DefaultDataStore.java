package com.epam.ediary.presistence;

import com.epam.ediary.domain.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;


public class DefaultDataStore implements DataStore {

    private ArrayList<Student> students = new ArrayList<Student>();

    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Course> courses = new ArrayList<Course>();
    private ArrayList<Grade> grades = new ArrayList<Grade>();
    final private String  baseDirPath;

    public DefaultDataStore(String baseDirPath) {
        this.baseDirPath = baseDirPath;


    }


    @Override
    public void init() throws IOException, ParseException {





            BufferedReader studentScan = Files.newBufferedReader(Paths.get(baseDirPath+"student.csv"));
            BufferedReader teacherScan = Files.newBufferedReader(Paths.get(baseDirPath+"teacher.csv"));
            BufferedReader courseScan = Files.newBufferedReader(Paths.get(baseDirPath+"course.csv"));
            BufferedReader gradeScan = Files.newBufferedReader(Paths.get(baseDirPath+"grade.csv"));



            BufferedReader[] scanners = {studentScan, teacherScan, courseScan, gradeScan};

            for (BufferedReader sc : scanners) {
                String line;
                if (sc == scanners[0]) { //students

                    while ((line = sc.readLine()) != null) {

                        String[] columns = line.split(",");

                        Student student = new Student();
                        Credentials credentials = new Credentials();
                        SchoolClass schoolClass = new SchoolClass();

                        student.setId(parseLong(columns[0]));
                        credentials.setLoginName(columns[1]);
                        credentials.setPassword(columns[2]);
                        student.setName(columns[3]);
                        student.setCredentials(credentials);
                        schoolClass.setName(columns[4]);
                        student.setSchoolClass(schoolClass);

                        students.add(student);



                    }

                }

                if (sc == scanners[1]) { //teachers

                    while ((line = sc.readLine()) != null) {

                        Teacher teacher = new Teacher();
                        Credentials credentials = new Credentials();

                        String[] columns = line.split(",");


                        teacher.setId(parseLong(columns[0]));
                        credentials.setLoginName(columns[1]);
                        credentials.setPassword(columns[2]);
                        teacher.setCredentials(credentials);
                        teacher.setName(columns[3]);

                        teachers.add(teacher);



                    }

                }

                if (sc == scanners[2]) { //courses

                    while ((line = sc.readLine()) != null) {

                        String[] columns = line.split(",");


                        Course course = new Course();
                        SchoolClass schoolClass = new SchoolClass();
                        Teacher rightTeacher = new Teacher();


                        schoolClass.setName(columns[0]);
                        course.setSchoolClass(schoolClass);

                        for (Subject sub : Subject.values()) {
                            if (sub.toString().equals(columns[1])) {
                                course.setSubject(sub);
                            }
                        }
                        ListIterator<Teacher> iterator =teachers.listIterator();
                        while(iterator.hasNext() && rightTeacher.getId()!=parseLong(columns[2])){
                            rightTeacher=iterator.next();

                        }


                        course.setTeacher(rightTeacher);
                        courses.add(course);




                    }

                }

                if (sc == scanners[3]) { //grades

                    while ((line = sc.readLine()) != null) {

                        Grade grade = new Grade();
                        Course course = new Course();
                        Student student = new Student();


                        String[] columns = line.split(",");



                        ListIterator<Student> iterator =students.listIterator();
                        while(iterator.hasNext() && student.getId()!=parseLong(columns[0])){
                            student=iterator.next();

                        }


                        String[] dateString = columns[3].split(".");
                        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
                        Date date =format.parse(columns[3]);

                        ListIterator<Course> courseItr=courses.listIterator();


                        course=courseItr.next();
                        while (!Objects.equals(course.getSubject().toString(), columns[2]) &&
                                iterator.hasNext()) {

                            course = courseItr.next();
                        }


                        grade.setStudent(student);
                        grade.setValue(parseInt(columns[1]));
                        grade.setCourse(course);
                        grade.setDate(date);

                        grades.add(grade);




                    }

                }


            }

        }


    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public List<Teacher> getTeachers() {
        return teachers;
    }

    @Override
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public List<Grade> getGrades() {
        return grades;
    }

    @Override
    public void saveGrade(Grade grade) throws IOException {

        grades.add(grade);

        Path filePath = Paths.get(baseDirPath+"grade.csv");
        String id= Long.toString(grade.getStudent().getId());
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        String dateStr = df.format(grade.getDate());
        StringBuilder writer= new StringBuilder();
        writer.append(System.lineSeparator());
        writer.append(id);
        writer.append(",");
        writer.append(Integer.toString(grade.getValue()));
        writer.append(",");
        writer.append(grade.getCourse().getSubject().toString());
        writer.append(",");
        writer.append(dateStr);

        Files.write(filePath,writer.toString().getBytes(), StandardOpenOption.APPEND);






    }
}
