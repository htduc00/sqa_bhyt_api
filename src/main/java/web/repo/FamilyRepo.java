package web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import web.model.Family;

public interface FamilyRepo extends JpaRepository<Family, Integer> {
}
