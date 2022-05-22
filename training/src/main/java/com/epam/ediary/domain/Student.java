package com.epam.ediary.domain;

import java.util.Objects;

public class Student extends User {
    private SchoolClass schoolClass;

    public Student() {
    }

    @Override
    public boolean equals(Object o) {


        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(schoolClass, student.schoolClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolClass);
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }
}
