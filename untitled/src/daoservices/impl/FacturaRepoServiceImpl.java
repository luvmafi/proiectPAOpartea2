package daoservices.impl;

import dao.impl.FacturaDaoImpl;
import daoservices.FacturaRepoService;
import model.Factura;
import service.AuditService;
import dao.FacturaDao;
import java.sql.SQLException;
import java.util.List;


public class FacturaRepoServiceImpl implements FacturaRepoService {
    private final FacturaDao facturaDao;
    private final AuditService auditService;

    public FacturaRepoServiceImpl() {
        this.facturaDao = new FacturaDaoImpl();
        this.auditService = AuditService.getInstance();
    }

    @Override
    public void adaugaFactura(Factura factura) {
        try {
            facturaDao.adaugaFactura(factura);
            auditService.logAction("adaugaFactura");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Factura obtineFacturaDupaId(String id) {
        try {
            auditService.logAction("obtineFacturaDupaId");
            return facturaDao.gasesteFacturaDupaId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizeazaFactura(Factura factura) {
        try {
            facturaDao.actualizeazaFactura(factura);
            auditService.logAction("actualizeazaFactura");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stergeFacturaDupaId(String id) {
        try {
            facturaDao.stergeFacturaDupaId(id);
            auditService.logAction("stergeFacturaDupaId");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afiseazaToateFacturile() {
        try {
            List<Factura> facturi = facturaDao.obtineToateFacturile();
            for (Factura factura : facturi) {
                System.out.println(factura);
            }
            auditService.logAction("afiseazaToateFacturile");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
