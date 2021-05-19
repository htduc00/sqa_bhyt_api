package web.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.model.Bill;
import web.model.User;

public interface BillRepo extends JpaRepository<Bill, Integer> {
	List<Bill> findByYear(int year);
	User findByUser(User user);
}
