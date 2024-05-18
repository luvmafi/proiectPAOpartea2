package daoservices.impl;

import dao.PacientDao;
import dao.impl.PacientDaoImpl;
import daoservices.PacientRepoService;
import model.Pacient;
import service.AuditService;

import java.sql.SQLException;
import java.util.List;

public class PacientRepoServiceImpl implements PacientRepoService {
    private final PacientDao pacientDao;
    private final AuditService auditService;

    public PacientRepoServiceImpl() {
        this.pacientDao = new PacientDaoImpl();
        this.auditService = AuditService.getInstance();
    }

    @Override
    public void adaugaPacient(Pacient pacient) {
        try {
            pacientDao.adauga(pacient);
            auditService.logAction("adaugaPacient");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pacient obtinePacientDupaId(String id) {
        try {
            auditService.logAction("obtinePacientDupaId");
            return pacientDao.gasesteDupaId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizeazaPacient(Pacient pacient) {
        try {
            pacientDao.actualizeaza(pacient);
            auditService.logAction("actualizeazaPacient");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stergePacientDupaId(String id) {
        try {
            pacientDao.stergeDupaId(id);
            auditService.logAction("stergePacientDupaId");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afiseazaTotiPacientii() {
        try {
            List<Pacient> pacienti = pacientDao.obtineToate();
            for (Pacient pacient : pacienti) {
                System.out.println(pacient);
            }
            auditService.logAction("afiseazaTotiPacientii");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
