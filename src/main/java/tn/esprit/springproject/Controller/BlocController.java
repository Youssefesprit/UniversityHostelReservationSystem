package tn.esprit.springproject.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Entity.Bloc;
import tn.esprit.springproject.Entity.TypeChambre;
import tn.esprit.springproject.Services.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Tag(name = "Gestion Block")
@RequestMapping("api/Blocs")
public class BlocController {

    private IBlocService blocService;

    @Scheduled(cron = "*/30 * * * * *")
    public void cronMethod() {
        log.info("Scheduled task to retrieve all blocs");
        try {
            log.info("Bloc details: {}", blocService.getAllBloc());
        } catch (Exception e) {
            log.error("Error during scheduled retrieval of blocs: {}", e.getMessage(), e);
        }
    }

    @Operation(summary = "Get all blocs", description = "Retrieve a list of all blocs")
    @GetMapping("/getAllBloc")
    public List<Bloc> allBlocs(){
        log.info("Request to retrieve all blocs");
        return blocService.getAllBloc();
    }

    @Operation(summary = "Add a bloc", description = "Add a new bloc")
    @PostMapping("/addBloc")
    public Bloc ajoutBloc(@RequestBody Bloc bloc){
        log.info("Request to add new bloc: {}", bloc);
        Bloc newBloc = blocService.addBloc(bloc);
        log.info("Added bloc: {}", newBloc);
        return newBloc;
    }

    @Operation(summary = "Get bloc by ID", description = "Retrieve a bloc by its ID")
    @GetMapping("/getByIdBloc/{id}")
    public Bloc getBlocById(@PathVariable long id){
        log.info("Request to get bloc by ID: {}", id);
        return blocService.getBlocById(id);
    }

    @Operation(summary = "Update a bloc", description = "Update an existing bloc")
    @PutMapping("/update")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        log.info("Request to update bloc: {}", bloc);
        Bloc updatedBloc = blocService.updateBloc(bloc);
        log.info("Updated bloc: {}", updatedBloc);
        return updatedBloc;
    }

    @Operation(summary = "Delete a bloc by ID", description = "Delete a bloc by its ID")
    @DeleteMapping("/delete/{id}")
    public void deleteBlocById(@PathVariable long id) {
        log.info("Request to delete bloc by ID: {}", id);
        blocService.deleteBlocById(id);
        log.info("Deleted bloc with ID: {}", id);
    }

    @Operation(summary = "List blocs by capacity and name", description = "List blocs by their capacity and name")
    @GetMapping("/blocs/capacite/{capacite}/nom/{nom}")
    public List<Bloc> listBlocparCapacite(@PathVariable("capacite") long capaciteBloc, @PathVariable("nom") String nom) {
        log.info("Request to list blocs by capacity: {} and name: {}", capaciteBloc, nom);
        return blocService.listBlocparCapacite(capaciteBloc, nom);
    }

    @Operation(summary = "List blocs by type and capacity", description = "List blocs by their type and capacity")
    @GetMapping("/blocs/type/{type}/capacite/{capacite}")
    public List<Bloc> listBlocParType(@PathVariable("type") TypeChambre type, @PathVariable("capacite") long capaciteBloc) {
        log.info("Request to list blocs by type: {} and capacity: {}", type, capaciteBloc);
        return blocService.listBlocParType(type, capaciteBloc);
    }

    @Operation(summary = "Add rooms to a bloc", description = "Add rooms to a bloc by room numbers and bloc ID")
    @PutMapping("/affecter-chambres-a-bloc/{numChambre}/{idBloc}")
    public Bloc ajouterChambresABloc(@PathVariable List<Long> numChambre, @PathVariable long idBloc){
        log.info("Request to add rooms to bloc ID: {} with room numbers: {}", idBloc, numChambre);
        Bloc blocWithRooms = blocService.affecterChambresABloc(numChambre, idBloc);
        log.info("Updated bloc after adding rooms: {}", blocWithRooms);
        return blocWithRooms;
    }
}
