package hr.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.model.WniosekUrlopowy;;

@Repository
public interface WniosekUrlopowyRepository extends JpaRepository<WniosekUrlopowy, Integer>{

}
