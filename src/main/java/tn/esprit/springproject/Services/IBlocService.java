package tn.esprit.springproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.springproject.Entity.Bloc;
import tn.esprit.springproject.Entity.TypeChambre;

import java.util.List;

public interface IBlocService {
    public Bloc addBloc(Bloc bloc);
    public Bloc getBlocById(long idBloc);
    public List<Bloc> getAllBloc();
    public Bloc updateBloc(Bloc bloc);
    public void deleteBlocById(long idBloc);
    public List<Bloc> listBlocparCapacite(long capaciteBloc,String x);
    public List<Bloc> listBlocParType(TypeChambre type, long capaciteBloc);
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) ;
}
