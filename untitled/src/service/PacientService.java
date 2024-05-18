package service;

import daoservices.PacientRepoService;
import model.Pacient;

public class PacientService {
    private final PacientRepoService pacientRepoService;

    public PacientService(PacientRepoService pacientRepoService) {
        this.pacientRepoService = pacientRepoService;
    }

    public void adaugaPacient(Pacient pacient) {
        pacientRepoService.adaugaPacient(pacient);
    }

    public Pacient gasestePacientDupaId(String id) {
        return pacientRepoService.obtinePacientDupaId(id);
    }

    public void actualizeazaPacient(Pacient pacient) {
        pacientRepoService.actualizeazaPacient(pacient);
    }

    public void stergePacientDupaId(String id) {
        pacientRepoService.stergePacientDupaId(id);
    }

    public void afiseazaTotiPacientii() {
        pacientRepoService.afiseazaTotiPacientii();
    }
}
