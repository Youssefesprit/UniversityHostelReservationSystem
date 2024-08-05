package tn.esprit.springproject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.springproject.entity.Reservation;

import java.util.Date;
import java.util.List;

@Repository
public interface IReservationRepository extends CrudRepository<Reservation,String> {
    List<Reservation> findByEtudiantsNomEtAndAnneeUniversitaire(String nomEt, Date anneeUniversitaire);
    @Query("SELECT R FROM Reservation R JOIN Chambre c on R member c.reservations where c.bloc.idBloc =:idBloc")
    List<Reservation> findReservationsByBlocId(Long idBloc) ;
   /* @Query("SELECT r FROM Reservation r JOIN Chambre c on r WHERE c.bloc.idBloc = :blocId AND r.anneeUniversitaire = :year  AND r.estValide = TRUE")
    List<Reservation> findReservationsByBlocAndYearAndValidity(@Param("blocId") long blocId, @Param("year") Date startDate);
*/


}
