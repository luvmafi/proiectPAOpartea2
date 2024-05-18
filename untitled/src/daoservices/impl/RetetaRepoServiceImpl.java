package daoservices.impl;

import dao.impl.RetetaDaoImpl;
import daoservices.RetetaRepoService;
import model.Reteta;
import service.AuditService;

import java.sql.SQLException;
import java.util.List;

public class RetetaRepoServiceImpl implements RetetaRepoService {
    private final RetetaDaoImpl retetaDao;
    private final AuditService auditService;

    public RetetaRepoServiceImpl() {
        this.retetaDao = new RetetaDaoImpl();
        this.auditService = AuditService.getInstance();
    }

    @Override
    public void adaugaReteta(Reteta reteta) {
        try {
            retetaDao.adauga(reteta);
            auditService.logAction("adaugaReteta");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Reteta obtineRetetaDupaId(String id) {
        try {
            auditService.logAction("obtineRetetaDupaId");
            return retetaDao.gasesteDupaId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizeazaReteta(Reteta reteta) {
        try {
            retetaDao.actualizeaza(reteta);
            auditService.logAction("actualizeazaReteta");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stergeRetetaDupaId(String id) {
        try {
            retetaDao.stergeDupaId(id);
            auditService.logAction("stergeRetetaDupaId");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afiseazaToateRetetele() {
        try {
            List<Reteta> retete = retetaDao.obtineToate();
            for (Reteta reteta : retete) {
                System.out.println(reteta);
            }
            auditService.logAction("afiseazaToateRetetele");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
