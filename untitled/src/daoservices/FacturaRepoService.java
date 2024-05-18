package daoservices;

import model.Factura;

public interface FacturaRepoService {
    void adaugaFactura(Factura factura);
    Factura obtineFacturaDupaId(String id);
    void actualizeazaFactura(Factura factura);
    void stergeFacturaDupaId(String id);
    void afiseazaToateFacturile();
}
