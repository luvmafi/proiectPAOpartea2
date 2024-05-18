package daoservices;

import model.IstoricMedical;

public interface IstoricMedicalRepoService {
    void adaugaIstoric(IstoricMedical istoricMedical);
    IstoricMedical obtineIstoricDupaIdPacient(String idPacient);
    void actualizeazaIstoric(IstoricMedical istoricMedical);
    void stergeIstoricDupaIdPacient(String idPacient);
    void afiseazaToateIstoriceleMedicale();
}
