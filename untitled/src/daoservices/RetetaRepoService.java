package daoservices;

import model.Reteta;

public interface RetetaRepoService {
    void adaugaReteta(Reteta reteta);
    Reteta obtineRetetaDupaId(String id);
    void actualizeazaReteta(Reteta reteta);
    void stergeRetetaDupaId(String id);
    void afiseazaToateRetetele();
}
