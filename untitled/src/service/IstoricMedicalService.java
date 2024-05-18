package service;

import dao.IstoricMedicalDao;
import dao.impl.IstoricMedicalDaoImpl;
import model.IstoricMedical;

import java.sql.SQLException;
import java.util.List;

public class IstoricMedicalService {
    private final IstoricMedicalDao istoricMedicalDao;

    public IstoricMedicalService() {
        this.istoricMedicalDao = new IstoricMedicalDaoImpl();
    }

    public void adaugaIstoric(IstoricMedical istoricMedical) {
        try {
            istoricMedicalDao.adaugaIstoric(istoricMedical);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public IstoricMedical obtineIstoricDupaIdPacient(String idPacient) {
        try {
            return istoricMedicalDao.gasesteIstoricDupaIdPacient(idPacient);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void actualizeazaIstoric(IstoricMedical istoricMedical) {
        try {
            istoricMedicalDao.actualizeazaIstoric(istoricMedical);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stergeIstoricDupaIdPacient(String idPacient) {
        try {
            istoricMedicalDao.stergeIstoricDupaIdPacient(idPacient);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void afiseazaToateIstoriceleMedicale() {
        try {
            List<IstoricMedical> istoriceMedicale = istoricMedicalDao.obtineToate();
            for (IstoricMedical istoricMedical : istoriceMedicale) {
                System.out.println(istoricMedical);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
