package dao;

import model.Reteta;

import java.util.List;

public interface RetetaDao {
    void adaugaReteta(Reteta reteta);
    Reteta gasesteRetetaDupaId(String id);
    void actualizeazaReteta(Reteta reteta);
    void stergeRetetaDupaId(String id);
    Reteta obtineRetetaDupaId(String id);
    List<Reteta> obtineToateRetetele();
}
