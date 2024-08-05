package tn.esprit.springproject.services;

import tn.esprit.springproject.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    public Universite addUniversite(Universite universite);

    public Universite getUniversiteById(long idUniversite);

    public List<Universite> getAllUniversite();

    public Universite updateUniversite(Universite universite);

    public void deleteUniversiteById(long idUniversite);
    public Universite universiteParNom(String nomUniversite);

    // Partie 5 : Services avancés
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) ;
    public Universite desaffecterFoyerAUniversite(long idUniversite) ;
}
