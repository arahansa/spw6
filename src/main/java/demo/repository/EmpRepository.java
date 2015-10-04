package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.domain.Emp;

public interface EmpRepository extends JpaRepository<Emp, Long>{

}
