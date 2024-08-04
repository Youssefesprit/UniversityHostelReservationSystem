package tn.esprit.springproject.Services;

import tn.esprit.springproject.Entity.Foyer;
import tn.esprit.springproject.Entity.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {

    public Reservation addReservation(long idBloc, long cinEtudiant);

    public Reservation getReservationById(String idReservation);

    public List<Reservation> getAllReservation();

    public Reservation updateFoyer(Reservation reservation);

    public void deleteReservationById(String idReservation);
    public List<Reservation> listReservationParNomEtudiant(String nomEt, Date anneeUniversitaire);


}
