package tn.esprit.springproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
//@RequiredArgsConstructor
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Serializable {
     @Id
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
     @ToString.Exclude
     @EqualsAndHashCode.Exclude
    // @Setter(AccessLevel.NONE)
     private String idReservation;
    // @NotNull
     private Date anneeUniversitaire;
    //@NotNull
     private boolean estValide;

     // Many To Many
    // Resevation * ----------------- * Etudiant
    @ManyToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Etudiant> etudiants;

    // One To Many Unidirectionnel
    // Chambre 1 --------> * Reservation
    // Nothing to add
}
