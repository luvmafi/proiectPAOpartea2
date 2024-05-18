package dao;

import model.Medic;

import java.util.List;

public interface MedicDao {
    void adaugaMedic(Medic medic);
    Medic gasesteMedicDupaId(String id);
    void actualizeazaMedic(Medic medic);
    void stergeMedicDupaId(String id);
    Medic obtineMedicDupaId(String id);
    List<Medic> obtineTotiMedicii();
}
