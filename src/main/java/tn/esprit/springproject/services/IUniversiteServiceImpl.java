package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entity.Foyer;
import tn.esprit.springproject.entity.Universite;
import tn.esprit.springproject.repository.IFoyerRepository;
import tn.esprit.springproject.repository.IUniversiteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class IUniversiteServiceImpl implements IUniversiteService{
    private IUniversiteRepository universiteRepository;
    private IFoyerRepository foyerRepository;

    @Override
    public Universite addUniversite(Universite universite) {
        log.debug("Adding universite: {}", universite);
        return universiteRepository.save(universite);
    }

    @Override
    public Universite getUniversiteById(long idUniversite) {
        log.debug("Fetching universite by ID: {}", idUniversite);
        return universiteRepository
                .findById(idUniversite)
                .orElseThrow(() -> new IllegalArgumentException("Universite not found with ID: " + idUniversite));
    }
    @Override
    public List<Universite> getAllUniversite() {
        log.debug("Fetching all universites");
        Iterable<Universite> iterable = universiteRepository.findAll();
        List<Universite> universites = new ArrayList<>();
        iterable.forEach(universites::add);
        return universites;
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        log.debug("Updating universite: {}", universite);
        return universiteRepository.save(universite);
    }

    @Override
    public void deleteUniversiteById(long idUniversite) {
        log.debug("Deleting universite by ID: {}", idUniversite);
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public Universite universiteParNom(String nomUniversite) {
        log.debug("Fetching universite by name: {}", nomUniversite);
        return universiteRepository.findByNomUniversiteContaining(nomUniversite);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        log.debug("Attempting to affect foyer ID {} to universite with name: {}", idFoyer, nomUniversite);
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer not found with ID: " + idFoyer));
        Universite universite = universiteRepository.findByNomUniversiteContaining(nomUniversite);

        universite.setFoyer(foyer);
        foyer.setFoyerUniversite(universite);
        universiteRepository.save(universite);
        foyerRepository.save(foyer);
        log.debug("Successfully affected foyer to universite.");

        return universite;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        log.debug("Attempting to disaffect foyer from universite with ID: {}", idUniversite);
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Universite not found with ID: " + idUniversite));
        Foyer foyer = universite.getFoyer();
        if (foyer != null) {
            universite.setFoyer(null);
            foyer.setFoyerUniversite(null);
            universiteRepository.save(universite);
            foyerRepository.save(foyer);
            log.debug("Successfully disaffected foyer from universite.");
        } else {
            log.warn("No foyer found associated with universite ID: {}", idUniversite);
            throw new IllegalStateException("No foyer associated to disaffect.");
        }
        return universite;
    }
}
