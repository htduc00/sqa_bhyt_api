package web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import web.model.Group;

public interface GroupRepo extends JpaRepository<Group, Integer> {

}
