package tn.esprit.springproject.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
//@RequiredArgsConstructor
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
    private long idUniversite ;
    //@NotNull
    private String nomUniversite ;
    //@NotNull
    private String adress ;

    @OneToOne(mappedBy="foyerUniversite")

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Foyer foyer;
}
