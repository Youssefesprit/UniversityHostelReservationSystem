package tn.esprit.springproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.entity.Bloc;
import tn.esprit.springproject.entity.TypeChambre;

import java.util.List;

@Repository
public interface IBlocRepository extends CrudRepository<Bloc,Long> {

    //  List<Bloc> retrieveBycapaciteBloc(Long capaciteBloc);

    List<Bloc> findByCapaciteBlocGreaterThanEqualAndNomBlocContainingOrderByChambresIdChambre(long capaciteBloc,String x);
    List<Bloc> findByChambresTypeCAndCapaciteBlocGreaterThanEqual(TypeChambre type, long capaciteBloc);

    Bloc findByIdBloc(long idBloc);


}
