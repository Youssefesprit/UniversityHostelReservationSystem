package tn.esprit.springproject.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.Entity.Foyer;

import java.util.List;
@Repository
public interface IFoyerRepository extends CrudRepository<Foyer,Long> {
    List<Foyer> findByCapaciteFoyerGreaterThanEqual(long capaciteFoyer);
}
