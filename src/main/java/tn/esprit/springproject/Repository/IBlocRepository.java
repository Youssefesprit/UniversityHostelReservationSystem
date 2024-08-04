package tn.esprit.springproject.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.Entity.Bloc;
import tn.esprit.springproject.Entity.Reservation;
import tn.esprit.springproject.Entity.TypeChambre;

import java.util.List;

@Repository
public interface IBlocRepository extends CrudRepository<Bloc,Long> {

    //  List<Bloc> retrieveBycapaciteBloc(Long capaciteBloc);

    List<Bloc> findByCapaciteBlocGreaterThanEqualAndNomBlocContainingOrderByChambresIdChambre(long capaciteBloc,String x);
    List<Bloc> findByChambresTypeCAndCapaciteBlocGreaterThanEqual(TypeChambre type, long capaciteBloc);

    Bloc findByIdBloc(long idBloc);


}
