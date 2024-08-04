package tn.esprit.springproject.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Entity.Foyer;
import tn.esprit.springproject.Entity.Universite;
import tn.esprit.springproject.Repository.IFoyerRepository;
import tn.esprit.springproject.Repository.IUniversiteRepository;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class IFoyerServiceImpl implements IFoyerService {
    private IFoyerRepository foyerRepository;
    private IUniversiteRepository universiteRepository;

    @Override
    public Foyer addFoyer(Foyer foyer) {
        log.debug("Adding new foyer: {}", foyer);
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer getFoyerById(long idFoyer) {
        log.debug("Fetching foyer by ID: {}", idFoyer);
        return foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer not found with ID: " + idFoyer));
    }

    @Override
    public List<Foyer> getAllFoyer() {
        log.debug("Fetching all foyers");
        List<Foyer> foyers = new ArrayList<>();
        foyerRepository.findAll().forEach(foyers::add);
        return foyers;
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        log.debug("Updating foyer: {}", foyer);
        return foyerRepository.save(foyer);
    }

    @Override
    public void deleteFoyerById(long idFoyer) {
        log.debug("Deleting foyer by ID: {}", idFoyer);
        foyerRepository.deleteById(idFoyer);
    }

    @Override
    public List<Foyer> listFoyerParCapacite(long capaciteFoyer) {
        log.debug("Listing foyers with capacity greater than or equal to: {}", capaciteFoyer);
        return foyerRepository.findByCapaciteFoyerGreaterThanEqual(capaciteFoyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        log.debug("Adding foyer and affecting it to universite ID: {}", idUniversite);
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Universite not found with ID: " + idUniversite));

        foyer.setFoyerUniversite(universite);
        foyer.getBlocs().forEach(bloc -> bloc.setFoyer(foyer));
        return foyerRepository.save(foyer);
    }
}
