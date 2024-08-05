package tn.esprit.springproject.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.springproject.entity.Etudiant;
import tn.esprit.springproject.services.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/Etudiants")
public class EtudiantController {
    @Autowired
    private IEtudiantService etudiantService;

    @PostMapping("/addEtudiant")
    public Etudiant ajoutEtudiants(@RequestBody Etudiant etudiant){
        log.info("Request to add new etudiant: {}", etudiant);
        Etudiant newEtudiant = etudiantService.addEtudiant(etudiant);
        log.info("Added etudiant: {}", newEtudiant);
        return newEtudiant;
    }
    @PostMapping("/AddStudentWithImage")
    public ResponseEntity<Etudiant> addStudentWithImage(@RequestParam("file") MultipartFile file, @ModelAttribute Etudiant etudiant) {
        Etudiant savedEtudiant = etudiantService.addEtudiantWithImage(etudiant, file);
        return ResponseEntity.ok(savedEtudiant);
    }
    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable long id) {
        log.info("Request to get etudiant by ID: {}", id);
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        log.info("Fetched etudiant: {}", etudiant);
        return etudiant;
    }

    @GetMapping("/all")
    public List<Etudiant> getAllEtudiants() {
        log.info("Request to get all etudiants");
        List<Etudiant> etudiants = etudiantService.getAllEtudiant();
        log.info("Number of etudiants fetched: {}", etudiants.size());
        return etudiants;
    }

    @PutMapping("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        log.info("Request to update etudiant: {}", etudiant);
        Etudiant updatedEtudiant = etudiantService.updateEtudiant(etudiant);
        log.info("Updated etudiant: {}", updatedEtudiant);
        return updatedEtudiant;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEtudiantById(@PathVariable long id) {
        log.info("Request to delete etudiant by ID: {}", id);
        etudiantService.deleteEtudiantById(id);
        log.info("Deleted etudiant with ID: {}", id);
    }

    @GetMapping("/search/cin/{cin}")
    public Etudiant listEtudiantParCin(@PathVariable Long cin) {
        log.info("Request to find etudiant by CIN: {}", cin);
        Etudiant etudiant = etudiantService.EtudiantParCin(cin);
        log.info("Fetched etudiant by CIN: {}", etudiant);
        return etudiant;
    }

    @GetMapping("/search/ecole/{ecole}")
    public List<Etudiant> listEtudiantParNomEcole(@PathVariable String ecole) {
        log.info("Request to find etudiants by school name: {}", ecole);
        List<Etudiant> etudiants = etudiantService.listEtudiantParNomEcole(ecole);
        log.info("Number of etudiants found at school {}: {}", ecole, etudiants.size());
        return etudiants;
    }
}
