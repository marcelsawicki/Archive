package departament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import departament.model.Country;

public interface CountryRepository  extends JpaRepository<Country, Integer>{

}
