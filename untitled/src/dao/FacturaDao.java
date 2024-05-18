package dao;

import model.Factura;

import java.sql.SQLException;
import java.util.List;

public interface FacturaDao extends GenericDao<Factura> {
    void adaugaFactura(Factura factura) throws SQLException;
    Factura gasesteFacturaDupaId(String id) throws SQLException;
    void actualizeazaFactura(Factura factura) throws SQLException;
    void stergeFacturaDupaId(String id) throws SQLException;
    List<Factura> obtineToateFacturile() throws SQLException;
}
