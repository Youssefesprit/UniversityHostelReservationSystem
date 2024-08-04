package tn.esprit.springproject.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.Entity.Etudiant;
import tn.esprit.springproject.Entity.Reservation;

import java.util.List;

@Repository
public interface IEtudiantRepository extends CrudRepository<Etudiant,Long> {
    Etudiant findByCin(Long cin);
    List<Etudiant> findByEcoleContaining(String ecole);
    @Query("SELECT e FROM Etudiant e JOIN Reservation r on e member r.etudiants join Chambre c on r member c.reservations " +
            "where c.idChambre = :idChambre")
    List<Etudiant> listEtudiantParIdChambre(@Param("idChambre") Long idChambre) ;
}
