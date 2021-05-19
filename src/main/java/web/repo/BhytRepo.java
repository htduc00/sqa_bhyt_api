package web.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.model.Bhyt;
import web.model.Family;

public interface BhytRepo extends JpaRepository<Bhyt, String> {
	@Query("SELECT b FROM bhyt b WHERE b.joinDate >= ?1 AND b.joinDate <= ?2")
	public List<Bhyt> findAllByJoinDate(Date fromDate, Date toDate);
	
	public List<Bhyt> findByFamily(Family family);
}
