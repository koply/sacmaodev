package me.koply.sacmaodev.entity;

import java.util.List;

public class Student extends User {

    private int yearsOfStudy;
    public Student(int id, int yearsOfStudy, String name, String surname, String birthDate, String gender, String phoneNumber, String email, String password) {
        super(id, name, surname, birthDate, gender, phoneNumber, email, password);
        this.yearsOfStudy = yearsOfStudy;
    }

    public int getYearsOfStudy() {
        return yearsOfStudy;
    }

    public Student setYearsOfStudy(int yearsOfStudy) {
        this.yearsOfStudy = yearsOfStudy;
        return this;
    }

    public int calculateTotalECTS(List<CourseRegistration> registrations) {
        int ects = 0;
        for (CourseRegistration e : registrations) {
            if (e.getStudent().equals(this))
                ects += e.getCourse().getEcts();
        }
        return ects;
    }

    @Override
    public void listAllCourses(List<CourseRegistration> registrations) {
        System.out.println("------------------");
        System.out.println("Student: (" + id + ") Name:" + name + surname + "BirthDate:" + birthDate);
        System.out.println("Courses Taken:");
        for (CourseRegistration reg : registrations) {
            if (!reg.getStudent().equals(this)) continue;
            System.out.println(reg.getCourse().toString());
        }
        System.out.println("Total ECTS: " + calculateTotalECTS(registrations));
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", yearsOfStudy='" + yearsOfStudy + '\''+
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // student
    // YearsOfStudy,Name,Surname,birthdate,gender,phoneNumber,email,password

    // instructor
    // OfficePhone,EmploymentType,Name,Surname,birthDate,gender,PhoneNumber,Email,password

    // courses
    // CourseCode,CourseName,ECTS

}