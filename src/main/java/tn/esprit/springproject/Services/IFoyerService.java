package tn.esprit.springproject.Services;

import tn.esprit.springproject.Entity.Chambre;
import tn.esprit.springproject.Entity.Foyer;

import java.util.List;

public interface IFoyerService {


    public Foyer addFoyer(Foyer foyer);

    public Foyer getFoyerById(long idfoyer);

    public List<Foyer> getAllFoyer();

    public Foyer updateFoyer(Foyer foyer);

    public void deleteFoyerById(long idfoyer);
    public List<Foyer> listFoyerParCapacite(long capaciteFoyer);

    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;
}
