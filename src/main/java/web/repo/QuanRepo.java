package web.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.model.Quan;
import web.model.Thanhpho;

public interface QuanRepo extends JpaRepository<Quan, Integer>{
	List<Quan> findByThanhpho(Thanhpho thanhpho);
}
