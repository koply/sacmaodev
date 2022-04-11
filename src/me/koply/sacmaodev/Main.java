package me.koply.sacmaodev;

import me.koply.sacmaodev.entity.Course;
import me.koply.sacmaodev.entity.CourseRegistration;
import me.koply.sacmaodev.entity.Instructor;
import me.koply.sacmaodev.entity.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
        // i -> id
        // object -> line's string array spllitted by ","
        File studentFile = new File("./sample_students.txt");
        List<Student> studentList = readDataFile(studentFile, (obj, i) -> new Student(i, parseInt(obj[0]),
                ""+obj[1], ""+obj[2],
                ""+obj[3], ""+obj[4],
                ""+obj[5], ""+obj[6],
                ""+obj[7]));

        File instructorFile = new File("./sample_instructors.txt");
        List<Instructor> instructorList = readDataFile(instructorFile, (obj, i) -> new Instructor(i,""+obj[0], ""+obj[1],
                ""+obj[2], ""+obj[3],
                ""+obj[4], ""+obj[5],
                ""+obj[6], ""+obj[7],
                ""+obj[8]));

        File coursesFile = new File("./sample_courses.txt");
        List<Course> courseList = readDataFile(coursesFile, (obj, i) -> new Course(i, ""+obj[0], ""+obj[1], parseInt(obj[2])));

        studentList.forEach((k) -> System.out.println(k.toString()));
        System.out.println("---------");
        instructorList.forEach((k) -> System.out.println(k.toString()));
        System.out.println("---------");
        courseList.forEach((k) -> System.out.println(k.toString()));

        Random random = new Random();

        // <courseID, instructorID>
        Map<Integer, Integer> courseInstructors = new HashMap<>();
        for (int i = 0; i< courseList.size(); i++) {
            courseInstructors.put(i, random.nextInt(instructorList.size()));
        }

        List<CourseRegistration> registrations = new ArrayList<>();
        for (Student student : studentList) {
            int count = random.nextInt(2)+1;
            for (int i = 0; i<count; i++) {
                Course randomCourse = courseList.get(random.nextInt(courseList.size()));
                CourseRegistration registration = new CourseRegistration(randomCourse, student, "4/11/2022", "09:00AM");
                registrations.add(registration);
            }
        }

        // --
        studentList.get(random.nextInt(studentList.size())).listAllCourses(registrations);

    }

    public static int parseInt(Object o) {
        String str = o+"";
        return Integer.parseInt(str.trim());
    }

    public static <T> List<T> readDataFile(File file, BiFunction<Object[], Integer, T> converter) {
        List<T> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i == 0) {
                    i++; continue;
                }
                String[] splittedLine = line.split(",");
                if (splittedLine.length < 2) continue;
                T obj = converter.apply(splittedLine, i-1);
                list.add(obj);
                i++;
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return list;
        }
    }

}