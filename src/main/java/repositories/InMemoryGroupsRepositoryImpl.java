package repositories;

import models.Group;

import java.util.*;

public class InMemoryGroupsRepositoryImpl implements GroupRepository {
    Map<Integer, Group> groupsDb = new HashMap<>();

    public InMemoryGroupsRepositoryImpl() {
    }

    @Override
    public Optional<Group> findById(int id) {
        return Optional.ofNullable(groupsDb.get(id));
    }

    @Override
    public boolean save(Group group) {
        return groupsDb.put(group.getId(), group) == null;
    }

    @Override
    public List<Group> findAll() {
        return new ArrayList<>(groupsDb.values());
    }
}
