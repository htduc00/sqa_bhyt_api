package web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import web.model.GroupDetail;
import web.model.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {
	Payment findByGroupDetail(GroupDetail groupDetail);
}
