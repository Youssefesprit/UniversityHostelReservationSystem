package tn.esprit.springproject.Controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Entity.Universite;
import tn.esprit.springproject.Services.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/Universite")
public class UniversiteController {
    @Autowired
    private IUniversiteService universiteService;

    @PostMapping
    public Universite createUniversite(@RequestBody Universite universite) {
        log.info("Request to create universite: {}", universite);
        Universite newUniversite = universiteService.addUniversite(universite);
        log.info("Created universite: {}", newUniversite);
        return newUniversite;
    }

    @GetMapping
    public List<Universite> findAllUniversites() {
        log.info("Request to find all universites");
        List<Universite> universites = universiteService.getAllUniversite();
        log.info("Number of universites found: {}", universites.size());
        return universites;
    }

    @GetMapping("/{id}")
    public Universite findUniversiteById(@PathVariable("id") long id) {
        log.info("Request to find universite by ID: {}", id);
        Universite universite = universiteService.getUniversiteById(id);
        log.info("Fetched universite: {}", universite);
        return universite;
    }

    @PutMapping("/{id}")
    public Universite modifyUniversite(@PathVariable("id") long id, @RequestBody Universite universite) {
        log.info("Request to modify universite ID {}: {}", id, universite);
        Universite updatedUniversite = universiteService.updateUniversite(universite);
        log.info("Modified universite: {}", updatedUniversite);
        return updatedUniversite;
    }

    @DeleteMapping("/{id}")
    public void removeUniversite(@PathVariable("id") long id) {
        log.info("Request to remove universite by ID: {}", id);
        universiteService.deleteUniversiteById(id);
        log.info("Removed universite with ID: {}", id);
    }

    @GetMapping("/by-name/{nom}")
    public Universite findUniversiteByName(@PathVariable("nom") String nomUniversite) {
        log.info("Request to find universite by name: {}", nomUniversite);
        Universite universite = universiteService.universiteParNom(nomUniversite);
        log.info("Fetched universite by name: {}", universite);
        return universite;
    }

    @PutMapping("/delete-Foyer-to-University/{idUniversite}")
    public Universite supprimerFoyerAUniversite(@PathVariable("idUniversite") long idUniversite) {
        log.info("Request to remove foyer from university ID: {}", idUniversite);
        Universite updatedUniversite = universiteService.desaffecterFoyerAUniversite(idUniversite);
        log.info("Removed foyer from university ID: {}", idUniversite);
        return updatedUniversite;
    }

    @PutMapping("/affecter-Foyer-to-University/{idUniversite}")
    public Universite affecterfoyertouniversite(@PathVariable("idUniversite") long idUniversite, @RequestParam("nomUniversite") String nomUniversite) {
        log.info("Request to affect foyer to university ID {} with name: {}", idUniversite, nomUniversite);
        Universite updatedUniversite = universiteService.affecterFoyerAUniversite(idUniversite, nomUniversite);
        log.info("Affected foyer to university ID {}: {}", idUniversite, updatedUniversite);
        return updatedUniversite;
    }
}
