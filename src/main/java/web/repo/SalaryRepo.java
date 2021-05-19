package web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import web.model.Salary;

public interface SalaryRepo extends JpaRepository<Salary, Integer> {

}
