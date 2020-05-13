package hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.model.Pracownik;

@Repository
public interface PracownikRepository extends JpaRepository<Pracownik, Integer>{

}
