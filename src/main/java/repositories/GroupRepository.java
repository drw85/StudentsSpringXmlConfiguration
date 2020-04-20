package repositories;

import models.Group;

import java.util.List;
import java.util.Optional;

public interface GroupRepository {
    Optional<Group> findById(int id);

    boolean save(Group group);

    List<Group> findAll();
}
