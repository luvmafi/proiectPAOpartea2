package service;
import model.Factura;
import daoservices.FacturaRepoService;

public class FacturaService {

    private final FacturaRepoService facturaRepoService;

    public FacturaService(FacturaRepoService facturaRepoService) {
        this.facturaRepoService = facturaRepoService;
    }

    public void adaugaFactura(Factura factura) {
        facturaRepoService.adaugaFactura(factura);
    }

    public Factura obtineFacturaDupaId(String id) {
        return facturaRepoService.obtineFacturaDupaId(id);
    }

    public void actualizeazaFactura(Factura factura) {
        facturaRepoService.actualizeazaFactura(factura);
    }

    public void stergeFacturaDupaId(String id) {
        facturaRepoService.stergeFacturaDupaId(id);
    }

    public void afiseazaToateFacturile() {
        facturaRepoService.afiseazaToateFacturile();
    }
}