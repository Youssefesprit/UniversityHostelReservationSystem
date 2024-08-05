package tn.esprit.springproject.services;

import tn.esprit.springproject.entity.Bloc;
import tn.esprit.springproject.entity.TypeChambre;

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
