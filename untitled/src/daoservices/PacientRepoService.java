package daoservices;

import model.Pacient;

public interface PacientRepoService {
    void adaugaPacient(Pacient pacient);
    Pacient obtinePacientDupaId(String id);
    void actualizeazaPacient(Pacient pacient);
    void stergePacientDupaId(String id);
    void afiseazaTotiPacientii();
}
