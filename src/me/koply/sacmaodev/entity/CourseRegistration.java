package me.koply.sacmaodev.entity;

public class CourseRegistration {
    private Course course;
    private Student student;
    private String registrationDate, registrationTime;

    public CourseRegistration(Course course, Student student, String registrationDate, String registrationTime) {
        this.course = course;
        this.student = student;
        this.registrationDate = registrationDate;
        this.registrationTime = registrationTime;
    }

    public Course getCourse() {
        return course;
    }

    public CourseRegistration setCourse(Course course) {
        this.course = course;
        return this;
    }

    public Student getStudent() {
        return student;
    }

    public CourseRegistration setStudent(Student student) {
        this.student = student;
        return this;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public CourseRegistration setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public CourseRegistration setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
        return this;
    }
}