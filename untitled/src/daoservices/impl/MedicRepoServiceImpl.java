package daoservices.impl;

import dao.impl.MedicDaoImpl;
import daoservices.MedicRepoService;
import model.Medic;
import service.AuditService;

import java.sql.SQLException;
import java.util.List;

public class MedicRepoServiceImpl implements MedicRepoService {
    private final MedicDaoImpl medicDao;
    private final AuditService auditService;

    public MedicRepoServiceImpl() {
        this.medicDao = new MedicDaoImpl();
        this.auditService = AuditService.getInstance();
    }

    @Override
    public void adaugaMedic(Medic medic) {
        try {
            medicDao.adauga(medic);
            auditService.logAction("adaugaMedic");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Medic obtineMedicDupaId(String id) {
        try {
            auditService.logAction("obtineMedicDupaId");
            return medicDao.gasesteDupaId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizeazaMedic(Medic medic) {
        try {
            medicDao.actualizeaza(medic);
            auditService.logAction("actualizeazaMedic");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stergeMedicDupaId(String id) {
        try {
            medicDao.stergeDupaId(id);
            auditService.logAction("stergeMedicDupaId");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afiseazaTotiMedicii() {
        try {
            List<Medic> medici = medicDao.obtineToate();
            for (Medic medic : medici) {
                System.out.println(medic);
            }
            auditService.logAction("afiseazaTotiMedicii");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
