package tn.esprit.springproject.services;

import tn.esprit.springproject.entity.Chambre;
import tn.esprit.springproject.entity.TypeChambre;

import java.util.List;

public interface IChambreService {

    public Chambre addChambre(Chambre chambre);

    public Chambre getChambreById(long idChambre);

    public List<Chambre> getAllChambre();

    public Chambre updateChambre(Chambre chambre);

    public void deleteChambreById(long idChambre);

    public List<Chambre> listChambreParType(TypeChambre type);

    public List<Chambre> listChambreParNum(Long numeroChambre);

    public List<Chambre> getChambresParNomUniversite( String nomUniversite) ;
    public List<Chambre> getChambresParBlocEtType (long idBloc, TypeChambre typeC) ;


}
