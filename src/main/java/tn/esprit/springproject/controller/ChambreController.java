package tn.esprit.springproject.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entity.Chambre;
import tn.esprit.springproject.entity.TypeChambre;
import tn.esprit.springproject.services.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/Chambres")
public class ChambreController {
    @Autowired
    private IChambreService chambreService;

    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        log.info("Request to add new chambre: {}", chambre);
        Chambre newChambre = chambreService.addChambre(chambre);
        log.info("Added chambre: {}", newChambre);
        return newChambre;
    }

    @GetMapping("/{id}")
    public Chambre getChambreById(@PathVariable long id) {
        log.info("Request to get chambre by ID: {}", id);
        Chambre chambre = chambreService.getChambreById(id);
        log.info("Fetched chambre: {}", chambre);
        return chambre;
    }

    @GetMapping
    public List<Chambre> getAllChambre() {
        log.info("Request to get all chambres");
        List<Chambre> chambres = chambreService.getAllChambre();
        log.info("Number of chambres fetched: {}", chambres.size());
        return chambres;
    }

    @PutMapping
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        log.info("Request to update chambre: {}", chambre);
        Chambre updatedChambre = chambreService.updateChambre(chambre);
        log.info("Updated chambre: {}", updatedChambre);
        return updatedChambre;
    }

    @DeleteMapping("/{id}")
    public void deleteChambreById(@PathVariable long id) {
        log.info("Request to delete chambre by ID: {}", id);
        chambreService.deleteChambreById(id);
        log.info("Deleted chambre with ID: {}", id);
    }

    @GetMapping("/type/{type}")
    public List<Chambre> listChambreParType(@PathVariable TypeChambre type) {
        log.info("Request to list chambres by type: {}", type);
        List<Chambre> chambres = chambreService.listChambreParType(type);
        log.info("Number of chambres by type {}: {}", type, chambres.size());
        return chambres;
    }

    @GetMapping("/numero/{numero}")
    public List<Chambre> listChambreParNum(@PathVariable Long numero) {
        log.info("Request to list chambres by room number: {}", numero);
        List<Chambre> chambres = chambreService.listChambreParNum(numero);
        log.info("Number of chambres by room number {}: {}", numero, chambres.size());
        return chambres;
    }

    @GetMapping("/ByNomUniversite/{nomUniversite}")
    public List<Chambre> getChambresParNomUniversite(@PathVariable String nomUniversite) {
        log.info("Request to get chambres by university name: {}", nomUniversite);
        List<Chambre> chambres = chambreService.getChambresParNomUniversite(nomUniversite);
        log.info("Number of chambres at university {}: {}", nomUniversite, chambres.size());
        return chambres;
    }

    @GetMapping("/getChambresParBlocEtType/{idBloc}/{typeC}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable long idBloc ,@PathVariable TypeChambre typeC){
        log.info("Request to get chambres by bloc ID {} and type: {}", idBloc, typeC);
        List<Chambre> chambres = chambreService.getChambresParBlocEtType(idBloc, typeC);
        log.info("Number of chambres in bloc ID {} and type {}: {}", idBloc, typeC, chambres.size());
        return chambres;
    }
}
