package models;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private int id;
    private String name;
    private Courses course;
    private List<Student> students;

    public Group(int id, String name, Courses course) {
        this.id = id;
        this.name = name;
        this.course = course;
        students = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public boolean addStudent(Student studentToAdd){
        return students.add(studentToAdd);
    }
}
