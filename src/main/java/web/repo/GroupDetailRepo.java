package web.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.model.Group;
import web.model.GroupDetail;

public interface GroupDetailRepo extends JpaRepository<GroupDetail, Integer> {
	List<GroupDetail> findByGroup(Group group);
}
