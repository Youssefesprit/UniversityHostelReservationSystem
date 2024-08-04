package tn.esprit.springproject.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;
import java.util.Date;
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
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
    //@NotNull
    private long idEtudiant;
    //@NotNull
    private String nomEt;
    //@NotNull
    private String prenomEt;
    //@NotNull
    private long cin;
    //  @NotNull
    private String ecole;
    //@NotNull
    private Date dateNaissance;
    //@NotNull
    private String image;

    // Many To Many
    // Resevation * ----------------- * Etudiant
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    // mappedBy Fi wa7da barka
    @ManyToMany(mappedBy = "etudiants")
    @JsonIgnore
    private Set<Reservation> reservations;




}
