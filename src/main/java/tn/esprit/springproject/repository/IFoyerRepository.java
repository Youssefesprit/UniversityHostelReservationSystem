package tn.esprit.springproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.entity.Foyer;

import java.util.List;
@Repository
public interface IFoyerRepository extends CrudRepository<Foyer,Long> {
    List<Foyer> findByCapaciteFoyerGreaterThanEqual(long capaciteFoyer);
}
