package model;

import java.time.LocalDate;

public class Factura {
    private String id;
    private String pacientId;
    private double sumaDePlata;
    private LocalDate dataEmiterii;
    private boolean estePlatita;

    public Factura(String id, String pacientId, double sumaDePlata, LocalDate dataEmiterii, boolean estePlatita) {
        this.id = id;
        this.pacientId = pacientId;
        this.sumaDePlata = sumaDePlata;
        this.dataEmiterii = dataEmiterii;
        this.estePlatita = estePlatita;
    }

    public String getId() {
        return id;
    }

    public String getPacientId() {
        return pacientId;
    }

    public double getSumaDePlata() {
        return sumaDePlata;
    }

    public LocalDate getDataEmiterii() {
        return dataEmiterii;
    }

    public boolean isEstePlatita() {
        return estePlatita;
    }
}
