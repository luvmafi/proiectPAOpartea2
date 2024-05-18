package model;
import java.time.LocalDateTime;
public class Programare {
    private String id;
    private Pacient pacient;
    private Medic medic;
    private LocalDateTime dataOra;


    public Programare(String id, Pacient pacient, Medic medic, LocalDateTime dataOra) {
        this.id = id;
        this.pacient = pacient;
        this.medic = medic;
        this.dataOra = dataOra;
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

    @Override
    public String toString() {
        return "Programare{" +
                "id='" + id + '\'' +
                ", pacient=" + pacient +
                ", medic=" + medic +
                ", dataOra=" + dataOra +
                '}';
    }
}
