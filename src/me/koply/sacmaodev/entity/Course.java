package me.koply.sacmaodev.entity;

public class Course {

    private final int id;
    private String courseCode, courseName;
    private int ects;

    public Course(int id, String courseCode, String courseName, int ects) {
        this.id = id;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.ects = ects;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", ects=" + ects +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public Course setCourseCode(String courseCode) {
        this.courseCode = courseCode;
        return this;
    }

    public String getCourseName() {
        return courseName;
    }

    public Course setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public int getEcts() {
        return ects;
    }

    public Course setEcts(int ects) {
        this.ects = ects;
        return this;
    }

}