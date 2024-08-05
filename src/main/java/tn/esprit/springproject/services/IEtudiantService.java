package tn.esprit.springproject.services;


import org.springframework.web.multipart.MultipartFile;
import tn.esprit.springproject.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {

    public Etudiant addEtudiant(Etudiant etudiant);
    Etudiant addEtudiantWithImage(Etudiant etudiant, MultipartFile file);
    public Etudiant getEtudiantById(long idEtudiant);

    public List<Etudiant> getAllEtudiant();

    public Etudiant updateEtudiant(Etudiant etudiant);

    public void deleteEtudiantById(long idEtudiant);

    public  Etudiant EtudiantParCin(Long cin);
    public List<Etudiant> listEtudiantParNomEcole(String ecole);
}
