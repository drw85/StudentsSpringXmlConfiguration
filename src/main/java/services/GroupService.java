package services;

import models.Courses;
import models.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    boolean createGroup(String name, Courses course);
    Optional<Group> findById(int id);
    boolean addStudentToGroup(int idStudent, int idGroup);
    List<Group> findAll();
}
