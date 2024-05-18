package model;
import java.time.LocalDateTime;

public class Consultatie {
    private String id;
    private Pacient pacient;
    private Medic medic;
    private LocalDateTime dataOra;
    private String notite;


    public Consultatie(String id, Pacient pacient, Medic medic, LocalDateTime dataOra, String notite) {
        this.id = id;
        this.pacient = pacient;
        this.medic = medic;
        this.dataOra = dataOra;
        this.notite = notite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }

    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }

    public String getNotite() {
        return notite;
    }

    public void setNotite(String notite) {
        this.notite = notite;
    }

    @Override
    public String toString() {
        return "Consultatie{" +
                "id='" + id + '\'' +
                ", pacient=" + pacient +
                ", medic=" + medic +
                ", dataOra=" + dataOra +
                ", notite='" + notite + '\'' +
                '}';
    }
}

