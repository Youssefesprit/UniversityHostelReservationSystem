package tn.esprit.springproject.Controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Entity.Foyer;
import tn.esprit.springproject.Services.IFoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/Foyer")
public class FoyerController {
    @Autowired
    private IFoyerService foyerService;

    @PostMapping
    public Foyer createFoyer(@RequestBody Foyer foyer) {
        log.info("Request to create new foyer: {}", foyer);
        Foyer newFoyer = foyerService.addFoyer(foyer);
        log.info("Created foyer: {}", newFoyer);
        return newFoyer;
    }

    @GetMapping
    public List<Foyer> findAllFoyers() {
        log.info("Request to find all foyers");
        List<Foyer> foyers = foyerService.getAllFoyer();
        log.info("Number of foyers found: {}", foyers.size());
        return foyers;
    }

    @GetMapping("/{id}")
    public Foyer findFoyerById(@PathVariable("id") long id) {
        log.info("Request to find foyer by ID: {}", id);
        Foyer foyer = foyerService.getFoyerById(id);
        log.info("Foyer found: {}", foyer);
        return foyer;
    }

    @PutMapping
    public Foyer modifyFoyer(@RequestBody Foyer foyer) {
        log.info("Request to modify foyer: {}", foyer);
        Foyer updatedFoyer = foyerService.updateFoyer(foyer);
        log.info("Modified foyer: {}", updatedFoyer);
        return updatedFoyer;
    }

    @DeleteMapping("/{id}")
    public void removeFoyer(@PathVariable("id") long id) {
        log.info("Request to remove foyer by ID: {}", id);
        foyerService.deleteFoyerById(id);
        log.info("Foyer removed with ID: {}", id);
    }

    @GetMapping("/by-capacity/{capacite}")
    public List<Foyer> findFoyersByCapacity(@PathVariable("capacite") Long capaciteFoyer) {
        log.info("Request to find foyers by capacity: {}", capaciteFoyer);
        List<Foyer> foyers = foyerService.listFoyerParCapacite(capaciteFoyer);
        log.info("Foyers found by capacity {}: {}", capaciteFoyer, foyers.size());
        return foyers;
    }

    @PostMapping("/add-Foyer-and-Blocs-to-University/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable long idUniversite) {
        log.info("Request to add foyer and affect it to university ID {}: {}", idUniversite, foyer);
        Foyer updatedFoyer = foyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
        log.info("Foyer added and affected to university ID {}: {}", idUniversite, updatedFoyer);
        return updatedFoyer;
    }
}
