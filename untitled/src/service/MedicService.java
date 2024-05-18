package service;

import daoservices.MedicRepoService;
import model.Medic;

public class MedicService {
    private final MedicRepoService medicRepoService;

    public MedicService(MedicRepoService medicRepoService) {
        this.medicRepoService = medicRepoService;
    }

    public void adaugaMedic(Medic medic) {
        medicRepoService.adaugaMedic(medic);
    }

    public Medic gasesteMedicDupaId(String id) {
        return medicRepoService.obtineMedicDupaId(id);
    }

    public void actualizeazaMedic(Medic medic) {
        medicRepoService.actualizeazaMedic(medic);
    }

    public void stergeMedicDupaId(String id) {
        medicRepoService.stergeMedicDupaId(id);
    }

    public void afiseazaTotiMedicii() {
        medicRepoService.afiseazaTotiMedicii();
    }
}
