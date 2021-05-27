package web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.model.GroupDetail;
import web.model.Payment;
import web.model.Salary;
import web.repo.GroupDetailRepo;
import web.repo.GroupRepo;
import web.repo.PaymentRepo;
import web.repo.SalaryRepo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/config")
public class ConfigController {
	
	@Autowired
	private SalaryRepo salaryRepo;
	
	@Autowired
	private PaymentRepo paymentRepo;
	
	@Autowired
	private GroupDetailRepo groupDetailRepo;
	
	@Autowired
	private GroupRepo groupRepo;  
	
	
	@GetMapping("/group_details/group={id}")
	public List<GroupDetail> getGroupDetails(@PathVariable int id) {
		List<GroupDetail> list = groupDetailRepo.findByGroup(groupRepo.findById(id).get());
		return list;
	}
	
	@GetMapping("/group_detail/{id}")
	public GroupDetail getGroupDetail(@PathVariable int id) {
		return groupDetailRepo.findById(id).get();
	}
	@GetMapping("/salary/{id}")
	public Salary  getSalary(@PathVariable int id) {
		return salaryRepo.findById(id).get();
	}
	
	
	@PutMapping("/payment/{id}")
	public Payment updatePayment(@RequestBody Payment newPayment, @PathVariable int id) {
		Payment payment = paymentRepo.findByGroupDetail(groupDetailRepo.findById(id).get());
		payment.setCost(newPayment.getCost());
		payment.setFamilyCost(newPayment.getFamilyCost());
		return paymentRepo.save(payment);
		
	}
	
	@PutMapping("/salary/{id}")
	public Salary updateSalary(@RequestBody Salary newSalary, @PathVariable int id) {
		Salary salary = salaryRepo.findById(id).get();
		salary.setValue(newSalary.getValue());
		return salaryRepo.save(salary);
	}
}
