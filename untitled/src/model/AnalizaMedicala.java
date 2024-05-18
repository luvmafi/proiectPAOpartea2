package model;
import java.time.LocalDateTime;

public class AnalizaMedicala {
    private String id;
    private String tipAnaliza;
    private Pacient pacient;
    private LocalDateTime dataOra;
    private String rezultat;


    public AnalizaMedicala(String id, String tipAnaliza, Pacient pacient, LocalDateTime dataOra, String rezultat) {
        this.id = id;
        this.tipAnaliza = tipAnaliza;
        this.pacient = pacient;
        this.dataOra = dataOra;
        this.rezultat = rezultat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipAnaliza() {
        return tipAnaliza;
    }

    public void setTipAnaliza(String tipAnaliza) {
        this.tipAnaliza = tipAnaliza;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    @Override
    public String toString() {
        return "AnalizaMedicala{" +
                "id='" + id + '\'' +
                ", tipAnaliza='" + tipAnaliza + '\'' +
                ", pacient=" + pacient +
                ", dataOra=" + dataOra +
                ", rezultat='" + rezultat + '\'' +
                '}';
    }

}
