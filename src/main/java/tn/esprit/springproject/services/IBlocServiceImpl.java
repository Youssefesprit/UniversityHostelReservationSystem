package tn.esprit.springproject.services;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entity.Bloc;
import tn.esprit.springproject.entity.Chambre;
import tn.esprit.springproject.entity.TypeChambre;
import tn.esprit.springproject.repository.IBlocRepository;
import tn.esprit.springproject.repository.IChambreRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class IBlocServiceImpl implements IBlocService{
    private IBlocRepository blocRepository;

    private IChambreRepository chambreRepository;
    @Override
    public Bloc addBloc(Bloc bloc) {
        log.debug("Adding bloc: {}", bloc);
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc getBlocById(long idBloc) {
        log.debug("Retrieving bloc by ID: {}", idBloc);
        return blocRepository.findById(idBloc).orElseThrow(() -> new RuntimeException("Bloc not found with ID: " + idBloc));
    }

    @Override
    public List<Bloc> getAllBloc() {
        log.debug("Retrieving all blocs");
        List<Bloc> blocList = new ArrayList<>();
        blocRepository.findAll().forEach(blocList::add);
        return blocList;
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        log.debug("Updating bloc: {}", bloc);
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBlocById(long idBloc) {
        log.debug("Deleting bloc by ID: {}", idBloc);
        blocRepository.deleteById(idBloc);
    }

    @Override
    public List<Bloc> listBlocparCapacite(long capaciteBloc, String x) {
        log.debug("Listing blocs by capacity >= {} and name containing '{}'", capaciteBloc, x);
        return blocRepository.findByCapaciteBlocGreaterThanEqualAndNomBlocContainingOrderByChambresIdChambre(capaciteBloc, x);
    }

    @Override
    public List<Bloc> listBlocParType(TypeChambre type, long capaciteBloc) {
        log.debug("Listing blocs by type {} and capacity >= {}", type, capaciteBloc);
        return blocRepository.findByChambresTypeCAndCapaciteBlocGreaterThanEqual(type, capaciteBloc);
    }
    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElseThrow(() -> new RuntimeException("Bloc not found with ID: " + idBloc));
        log.debug("Affecting rooms to bloc ID: {}", idBloc);
        numChambre.forEach(num -> {
            Chambre chambre = chambreRepository.findOneChambreByNumeroChambre(num);
            bloc.getChambres().add(chambre);
            chambre.setBloc(bloc);
            chambreRepository.save(chambre);
        });
        return blocRepository.save(bloc);
    }
}
