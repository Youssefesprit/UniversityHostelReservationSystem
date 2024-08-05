package tn.esprit.springproject.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Builder
@ToString
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor

public class Chambre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
    private long idChambre ;
    //@NotNull
    private long numeroChambre;
    @Enumerated(EnumType.STRING)
    //@NotNull
    private TypeChambre typeC;

    // One To Many Unidirectionnel
    // Chambre 1 --------> * Reservation
    @OneToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Set<Reservation> reservations;

    // Many to One Bidirectionnel
    // Bloc 1 ---------- * Chambre
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Bloc bloc;
}
