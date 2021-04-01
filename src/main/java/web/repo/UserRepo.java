package web.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.model.Phuong;
import web.model.Quan;
import web.model.Thanhpho;
import web.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	List<User> findByThanhpho(Thanhpho thanhpho);
	List<User> findByQuan(Quan quan);
	List<User> findByPhuong(Phuong phuong);
}
