package tn.esprit.springproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
//@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
    private long idFoyer;
   // @NotNull
    private String nomFoyer;
   // @NotNull
    private long capaciteFoyer;

    // One to Many Bidirectionnel
    // Foyer 1 ---------- * Bloc
    @OneToMany(cascade = CascadeType.ALL, mappedBy="foyer")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Bloc> Blocs;


    // One to One Bidirectionnel
    // Univertite 1 ---------------- 1 Foyer
    @OneToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Universite foyerUniversite;
}
