package services;

import models.Group;
import models.Student;
import repositories.GroupRepository;
import repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    StudentIdGenerator studentIdGenerator;
    StudentRepository studentRepository;
    GroupRepository groupRepository;

    public StudentServiceImpl(StudentIdGenerator studentIdGenerator, StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentIdGenerator = studentIdGenerator;
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public boolean createStudent(String firstname, String lastname) {
        Student student = new Student(studentIdGenerator.generateStudentId(), firstname, lastname);
        if (!studentRepository.alreadyPresent(student)) {
            return studentRepository.save(student);
        } else {
            return false;
        }
    }

    @Override
    public Optional<Student> findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Group> getStudentGroups(int idStudent) {
        if (studentRepository.findById(idStudent).isPresent()) {
            return groupRepository.findAll().stream()
                    .filter(group -> group.getStudents().contains(studentRepository.findById(idStudent).get()))
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }
}
