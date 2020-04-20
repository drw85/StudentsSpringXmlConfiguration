package services;

import models.Group;
import repositories.GroupRepository;

import java.util.OptionalInt;

public class GroupIdGeneratorGetNextByIteration implements GroupIdGenerator {
    GroupRepository groupRepository;

    public GroupIdGeneratorGetNextByIteration() {
    }

    public GroupIdGeneratorGetNextByIteration(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public int generateGroupdId() {
        if (groupRepository.findAll().size() == 0) {
            return 1;
        }
        OptionalInt max = groupRepository.findAll().stream()
                .mapToInt(Group::getId)
                .max();
        if (max.isPresent()) {
            return max.getAsInt() + 1;
        } else {
            throw new RuntimeException();
        }
    }
}
