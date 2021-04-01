package web.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.model.Phuong;
import web.model.Quan;

public interface PhuongRepo extends JpaRepository<Phuong, Integer>{
	List<Phuong> findByQuan(Quan quan);
}
