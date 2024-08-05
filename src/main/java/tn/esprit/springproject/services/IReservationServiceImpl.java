package tn.esprit.springproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.springproject.entity.Bloc;
import tn.esprit.springproject.entity.Chambre;
import tn.esprit.springproject.entity.Etudiant;
import tn.esprit.springproject.entity.Reservation;
import tn.esprit.springproject.repository.IBlocRepository;
import tn.esprit.springproject.repository.IEtudiantRepository;
import tn.esprit.springproject.repository.IReservationRepository;

import java.time.LocalDate;
import java.util.*;

@Slf4j
@Service
public class IReservationServiceImpl implements IReservationService {
    @Autowired
    private IReservationRepository reservationRepository;
    @Autowired
    private IBlocRepository blocRepository;
    @Autowired
    private IEtudiantRepository etudiantRepository;

    @Override
    public Reservation addReservation(long idBloc, long cinEtudiant) {
        log.debug("Adding reservation for Bloc ID: {}, Student CIN: {}", idBloc, cinEtudiant);
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);

        Etudiant etudiant = (Etudiant) etudiantRepository.findByCin(cinEtudiant);

        if (bloc != null && etudiant!=null) {
            Set<Chambre> chs = bloc.getChambres();
            Chambre chambre = bloc.getChambres().stream().findFirst().orElse(null);
            if (chambre != null && bloc.getCapaciteBloc() > chambre.getReservations().size()) {
                Reservation reservation = new Reservation();
                Set<Etudiant> etudiants = new HashSet<>();
                etudiants.add(etudiant);
                String numReservation = chambre.getNumeroChambre() + "-" + chambre.getBloc().getNomBloc() + "-" + LocalDate.now().getYear();
                reservation.setEtudiants(etudiants);
                reservation.setIdReservation(numReservation);
                reservation.setEstValide(true);
                reservation.setAnneeUniversitaire(new Date());
                return reservationRepository.save(reservation);
            }
        }
        log.error("Bloc or Etudiant not found. Bloc ID: {}, Student CIN: {}", idBloc, cinEtudiant);
        return null;
    }


    @Override
    public Reservation getReservationById(String idReservation) {
        log.debug("Fetching reservation by ID: {}", idReservation);
        return reservationRepository.findById(idReservation)
                .orElseThrow(() -> new RuntimeException("Reservation not found with ID: " + idReservation));
    }

    @Override
    public List<Reservation> getAllReservation() {
        log.debug("Fetching all reservations");
        Iterable<Reservation> iterable = reservationRepository.findAll();
        List<Reservation> reservations = new ArrayList<>();
        iterable.forEach(reservations::add);
        return reservations;
    }

    @Override
    public Reservation updateFoyer(Reservation reservation) {
        log.debug("Updating reservation: {}", reservation);
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservationById(String idReservation) {
        log.debug("Deleting reservation by ID: {}", idReservation);
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public List<Reservation> listReservationParNomEtudiant(String nomEt, Date anneeUniversitaire) {

        log.debug("Listing reservations by Student Name: {}, Year: {}", nomEt, anneeUniversitaire);
        return reservationRepository.findByEtudiantsNomEtAndAnneeUniversitaire(nomEt, anneeUniversitaire);
    }
}
