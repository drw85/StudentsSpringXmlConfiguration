package services;

import models.Student;
import repositories.StudentRepository;

import java.util.OptionalInt;

public class StudentsIdGeneratorGetNextByIteration implements StudentIdGenerator {
    StudentRepository studentRepository;

    public StudentsIdGeneratorGetNextByIteration(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public int generateStudentId() {
        if (studentRepository.findAll().size() == 0) {
            return 1;
        }
        OptionalInt max = studentRepository.findAll()
                .stream()
                .mapToInt(Student::getId)
                .max();
        if (max.isPresent()) {
            return max.getAsInt() + 1;
        } else {
            throw new RuntimeException();
        }
    }
}
