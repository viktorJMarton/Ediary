package com.epam.ediary.domain;

import java.util.Objects;

public class Course {
    private Subject subject;
    private Teacher teacher;
    private SchoolClass schoolClass;


    public Course() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return subject == course.subject && Objects.equals(teacher, course.teacher) && Objects.equals(schoolClass, course.schoolClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, teacher, schoolClass);
    }

    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }




}
