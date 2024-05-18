package service;
import model.Reteta;
import daoservices.RetetaRepoService;

public class RetetaService {

    private final RetetaRepoService retetaRepoService;

    public RetetaService(RetetaRepoService retetaRepoService) {
        this.retetaRepoService = retetaRepoService;
    }

    public void adaugaReteta(Reteta reteta) {
        retetaRepoService.adaugaReteta(reteta);
    }

    public Reteta obtineRetetaDupaId(String id) {
        return retetaRepoService.obtineRetetaDupaId(id);
    }

    public void stergeRetetaDupaId(String id) {
        retetaRepoService.stergeRetetaDupaId(id);
    }
}