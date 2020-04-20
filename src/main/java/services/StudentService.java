package services;

import models.Group;
import models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
boolean createStudent(String firstname, String lastname);
Optional<Student> findById(int id);
List<Student> findAll();
List<Group> getStudentGroups(int idStudent);
}
