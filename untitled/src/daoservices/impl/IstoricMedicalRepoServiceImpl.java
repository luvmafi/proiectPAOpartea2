package daoservices.impl;

import daoservices.IstoricMedicalRepoService;
import dao.IstoricMedicalDao;
import dao.impl.IstoricMedicalDaoImpl;
import model.IstoricMedical;
import service.AuditService;

import java.sql.SQLException;
import java.util.List;

public class IstoricMedicalRepoServiceImpl implements IstoricMedicalRepoService {
    private final IstoricMedicalDao istoricMedicalDao;
    private final AuditService auditService;

    public IstoricMedicalRepoServiceImpl() {
        this.istoricMedicalDao = new IstoricMedicalDaoImpl();
        this.auditService = AuditService.getInstance();
    }

    @Override
    public void adaugaIstoric(IstoricMedical istoricMedical) {
        try {
            istoricMedicalDao.adaugaIstoric(istoricMedical);
            auditService.logAction("adaugaIstoric");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IstoricMedical obtineIstoricDupaIdPacient(String idPacient) {
        try {
            auditService.logAction("obtineIstoricDupaIdPacient");
            return istoricMedicalDao.gasesteIstoricDupaIdPacient(idPacient);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizeazaIstoric(IstoricMedical istoricMedical) {
        try {
            istoricMedicalDao.actualizeazaIstoric(istoricMedical);
            auditService.logAction("actualizeazaIstoric");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stergeIstoricDupaIdPacient(String idPacient) {
        try {
            istoricMedicalDao.stergeIstoricDupaIdPacient(idPacient);
            auditService.logAction("stergeIstoricDupaIdPacient");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afiseazaToateIstoriceleMedicale() {
        try {
            List<IstoricMedical> istoriceMedicale = istoricMedicalDao.obtineToate();
            for (IstoricMedical istoricMedical : istoriceMedicale) {
                System.out.println(istoricMedical);
            }
            auditService.logAction("afiseazaToateIstoriceleMedicale");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
