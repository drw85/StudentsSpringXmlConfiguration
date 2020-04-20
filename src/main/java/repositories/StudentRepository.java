package repositories;

import models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Optional<Student> findById(int id);
    boolean save(Student student);
    List<Student> findAll();
    boolean alreadyPresent(Student student);
}
