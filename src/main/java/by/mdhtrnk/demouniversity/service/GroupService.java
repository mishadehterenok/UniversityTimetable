package by.mdhtrnk.demouniversity.service;

import by.mdhtrnk.demouniversity.entity.Group;
import by.mdhtrnk.demouniversity.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService implements BaseService<Group> {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Optional<Group> findById(Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public void saveAll(Iterable<Group> entities) {
        groupRepository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        groupRepository.deleteById(id);
    }

}
