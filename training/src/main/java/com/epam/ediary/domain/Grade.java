package com.epam.ediary.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Grade {
    private int value; //tick
    private Date date;
    private Course course;
    private Student student; //tick

    public Grade() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return value == grade.value && Objects.equals(date, grade.date) && Objects.equals(course, grade.course) && Objects.equals(student, grade.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, date, course, student);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
