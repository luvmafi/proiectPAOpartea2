package daoservices;

import model.Medic;

public interface MedicRepoService {
    void adaugaMedic(Medic medic);
    Medic obtineMedicDupaId(String id);
    void actualizeazaMedic(Medic medic);
    void stergeMedicDupaId(String id);
    void afiseazaTotiMedicii();
}
