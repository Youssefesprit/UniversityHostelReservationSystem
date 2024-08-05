package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.entity.Chambre;
import tn.esprit.springproject.entity.TypeChambre;

import java.util.List;

@Repository
public interface IChambreRepository extends CrudRepository<Chambre,Long> {
    List<Chambre> findByNumeroChambre(Long numeroChambre);
    Chambre findOneChambreByNumeroChambre(Long numeroChambre);
    List<Chambre> findByTypeC(TypeChambre type);
    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> getChambresParBlocEtType(@Param("idBloc") long idBloc, @Param("typeC") TypeChambre typeC);
    List<Chambre> findChambresByBloc_IdBlocAndTypeC(long idBloc , TypeChambre typeC);
}
