package services;

import models.Courses;
import models.Group;
import repositories.GroupRepository;

import java.util.List;
import java.util.Optional;

public class GroupServiceImpl implements GroupService {
    GroupRepository groupRepository;
    GroupIdGenerator groupIdGenerator;
    StudentService studentService;

    public GroupServiceImpl(GroupRepository groupRepository,
                            GroupIdGenerator groupIdGenerator,
                            StudentService studentService) {
        this.groupRepository = groupRepository;
        this.groupIdGenerator = groupIdGenerator;
        this.studentService = studentService;
    }


    @Override
    public boolean createGroup(String name, Courses course) {
        Group groupToSave = new Group(groupIdGenerator.generateGroupdId(), name+ " (" + course.getName() + ")", course);
        return groupRepository.save(groupToSave);
    }

    @Override
    public Optional<Group> findById(int id) {
        return groupRepository.findById(id);
    }

    @Override
    public boolean addStudentToGroup(int idStudent, int idGroup) {
        if (studentService.findById(idStudent).isPresent() && findById(idGroup).isPresent()) {
            return findById(idGroup).get().addStudent(studentService.findById(idStudent).get());
        } else {
            return false;
        }
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }
}
