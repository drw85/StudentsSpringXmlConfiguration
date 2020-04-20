package repositories;

import models.Student;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryStudentsRepositoryImpl implements StudentRepository {
    private Map<Integer, Student> studentsDb = new HashMap<>();

    public InMemoryStudentsRepositoryImpl() {
    }

    @Override
    public Optional<Student> findById(int id) {
        return Optional.ofNullable(studentsDb.get(id));
    }

    @Override
    public boolean save(Student student) {
        return studentsDb.put(student.getId(), student) == null;
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentsDb.values());
    }

    @Override
    public boolean alreadyPresent(Student student) {
        return studentsDb.values().stream()
                .filter(streamStudent -> streamStudent.getFirstname().equals(student.getFirstname()))
                .filter(streamStudent -> streamStudent.getLastname().equals(student.getLastname()))
                .collect(Collectors.toList()).size() > 0;
    }
}
