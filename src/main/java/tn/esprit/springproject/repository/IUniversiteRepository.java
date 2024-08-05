package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.entity.Universite;

@Repository
public interface IUniversiteRepository extends CrudRepository<Universite,Long> {
    Universite findByNomUniversiteContaining(String nomUniversite);
    @Query("SELECT u FROM Universite u JOIN u.foyer f JOIN f.Blocs b WHERE b.idBloc = :idBloc")
    Universite findUniversiteByidBloc(@Param("idBloc") Long idBloc);

}
