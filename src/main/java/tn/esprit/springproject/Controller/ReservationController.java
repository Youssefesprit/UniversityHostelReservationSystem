package tn.esprit.springproject.Controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Entity.Reservation;
import tn.esprit.springproject.Services.IReservationService;
import tn.esprit.springproject.Services.IUniversiteService;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/Reservation")
public class ReservationController {
    @Autowired
    private IReservationService reservationService ;

    @PostMapping("/{idBloc}/{cinEtudiant}")
    public Reservation createReservation(@PathVariable("idBloc") Long idBloc, @PathVariable("cinEtudiant") Long cinEtudiant) {
        log.info("Request to create reservation for block ID {} and student CIN {}", idBloc, cinEtudiant);
        Reservation newReservation = reservationService.addReservation(idBloc, cinEtudiant);
        log.info("Created reservation: {}", newReservation);
        return newReservation;
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable("id") String idReservation) {
        log.info("Request to get reservation by ID: {}", idReservation);
        Reservation reservation = reservationService.getReservationById(idReservation);
        log.info("Fetched reservation: {}", reservation);
        return reservation;
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        log.info("Request to get all reservations");
        List<Reservation> reservations = reservationService.getAllReservation();
        log.info("Number of reservations fetched: {}", reservations.size());
        return reservations;
    }

    @PutMapping("/{id}")
    public Reservation updateReservation( @RequestBody Reservation reservation) {
        return reservationService.updateFoyer(reservation);
    }
    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable("id") String idReservation) {
        log.info("Request to delete reservation by ID: {}", idReservation);
        reservationService.deleteReservationById(idReservation);
        log.info("Deleted reservation with ID: {}", idReservation);
    }

    @GetMapping("/by_student_and_year")
    public List<Reservation> listReservationsByStudentAndYear(@RequestParam("studentName") String nomEt, @RequestParam("year") @DateTimeFormat(pattern = "yyyy-MM-dd") Date anneeUniversitaire) {
        log.info("Request to list reservations by student name: {} and year: {}", nomEt, anneeUniversitaire);
        List<Reservation> reservations = reservationService.listReservationParNomEtudiant(nomEt, anneeUniversitaire);
        log.info("Number of reservations for student {} in year {}: {}", nomEt, anneeUniversitaire, reservations.size());
        return reservations;
    }

}
