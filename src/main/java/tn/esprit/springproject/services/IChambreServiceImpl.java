package tn.esprit.springproject.services;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entity.Bloc;
import tn.esprit.springproject.entity.Chambre;
import tn.esprit.springproject.entity.TypeChambre;
import tn.esprit.springproject.entity.Universite;
import tn.esprit.springproject.repository.IChambreRepository;
import tn.esprit.springproject.repository.IUniversiteRepository;

import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class IChambreServiceImpl implements IChambreService{
    private IChambreRepository chambreRepository;
    private IUniversiteRepository universiteRepository;

    @Override
    public Chambre addChambre(Chambre chambre) {
        log.debug("Adding new chambre: {}", chambre);
        Chambre savedChambre = chambreRepository.save(chambre);
        log.debug("Saved chambre: {}", savedChambre);
        return savedChambre;
    }

    @Override
    public Chambre getChambreById(long idChambre) {
        log.debug("Fetching chambre by ID: {}", idChambre);
        return chambreRepository.findById(idChambre)
                .orElseThrow(() -> new RuntimeException("Chambre not found with ID: " + idChambre));
    }

    @Override
    public List<Chambre> getAllChambre() {
        log.debug("Fetching all chambres");
        return (List<Chambre>) chambreRepository.findAll();
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        log.debug("Updating chambre: {}", chambre);
        Chambre updatedChambre = chambreRepository.save(chambre);
        log.debug("Updated chambre: {}", updatedChambre);
        return updatedChambre;
    }

    @Override
    public void deleteChambreById(long idChambre) {
        log.debug("Deleting chambre by ID: {}", idChambre);
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public List<Chambre> listChambreParType(TypeChambre type) {
        log.debug("Listing chambres by type: {}", type);
        return chambreRepository.findByTypeC(type);
    }

    @Override
    public List<Chambre> listChambreParNum(Long numeroChambre) {
        log.debug("Listing chambres by numero: {}", numeroChambre);
        return chambreRepository.findByNumeroChambre(numeroChambre);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        log.debug("Fetching chambres by university name: {}", nomUniversite);
        Optional<Universite> universite = Optional.ofNullable(universiteRepository.findByNomUniversiteContaining(nomUniversite));

        return universite.map(u -> {
            Set<Bloc> blocs = u.getFoyer().getBlocs();
            List<Chambre> chambres = new ArrayList<>();
            blocs.forEach(bloc -> chambres.addAll(bloc.getChambres()));
            return chambres;
        }).orElseGet(Collections::emptyList);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        log.debug("Fetching chambres by bloc ID: {} and type: {}", idBloc, typeC);
        return chambreRepository.findChambresByBloc_IdBlocAndTypeC(idBloc, typeC);
    }
}
