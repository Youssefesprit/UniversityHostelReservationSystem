package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.springproject.entity.Etudiant;
import tn.esprit.springproject.repository.IEtudiantRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class IEtudiantServiceImpl implements IEtudiantService {

    private IEtudiantRepository etudiantRepository;

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        log.debug("Adding etudiant: {}", etudiant);
        Etudiant savedEtudiant = etudiantRepository.save(etudiant);
        log.debug("Added etudiant: {}", savedEtudiant);
        return savedEtudiant;
    }
    public Etudiant addEtudiantWithImage(Etudiant etudiant, MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Provided file is empty and cannot be uploaded.");
        }
        try {

            String originalFilename = file.getOriginalFilename();
            String fileExtension = originalFilename != null ? originalFilename.substring(originalFilename.lastIndexOf('.')) : "";
            String newFilename = System.currentTimeMillis() + "-" + UUID.randomUUID().toString() + fileExtension;

            Path rootLocation = Paths.get("src/main/resources/static/uploads/userImage/");
            Files.createDirectories(rootLocation); // Ensuring the directory exists
            Path filePath = rootLocation.resolve(newFilename);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            etudiant.setImage(newFilename);
            return addEtudiant(etudiant);
        } catch (IOException e) {
            log.error("Failed to store file due to IOException: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to store file.", e);
        }
    }


    @Override
    public Etudiant getEtudiantById(long idEtudiant) {
        log.debug("Fetching etudiant by ID: {}", idEtudiant);
        return etudiantRepository.findById(idEtudiant)
                .orElseThrow(() -> new RuntimeException("Etudiant not found with ID: " + idEtudiant));
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        log.debug("Fetching all etudiants");
        return (List<Etudiant>) etudiantRepository.findAll();
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        log.debug("Updating etudiant: {}", etudiant);
        Etudiant updatedEtudiant = etudiantRepository.save(etudiant);
        log.debug("Updated etudiant: {}", updatedEtudiant);
        return updatedEtudiant;
    }

    @Override
    public void deleteEtudiantById(long idEtudiant) {
        log.debug("Deleting etudiant by ID: {}", idEtudiant);
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public Etudiant EtudiantParCin(Long cin) {
        log.debug("Fetching etudiant by CIN: {}", cin);
        return etudiantRepository.findByCin(cin);
    }

    @Override
    public List<Etudiant> listEtudiantParNomEcole(String ecole) {
        log.debug("Fetching etudiants by school name containing: {}", ecole);
        return etudiantRepository.findByEcoleContaining(ecole);
    }
}
