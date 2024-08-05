package tn.esprit.springproject.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
//@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Bloc implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @ToString.Exclude
     @EqualsAndHashCode.Exclude
     @Setter(AccessLevel.NONE)
     private long idBloc;
    //@NotNull
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private String nomBloc;
    //@NotNull
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private long capaciteBloc;

    // One to Many Bidirectionnel
    // Bloc 1 ---------- * Chambre
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy="bloc")
    @JsonIgnore
    private Set<Chambre> chambres;

    // One to Many Bidirectionnel
    // Foyer 1 ---------- * Bloc
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JsonIgnore
    Foyer foyer;
}
