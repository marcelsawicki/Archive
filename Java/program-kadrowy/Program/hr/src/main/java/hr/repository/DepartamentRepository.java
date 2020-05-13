package hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.model.Departament;

@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Integer>{

}
