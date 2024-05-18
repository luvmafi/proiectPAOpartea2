package model;

import java.util.Map;

public class Reteta {
    private String id;
    private Medic medic;
    private Pacient pacient;
    private Map<String, Integer> medicamente;

    public Reteta(String id, Medic medic, Pacient pacient, Map<String, Integer> medicamente) {
        this.id = id;
        this.medic = medic;
        this.pacient = pacient;
        this.medicamente = medicamente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public Map<String, Integer> getMedicamente() {
        return medicamente;
    }

    public void setMedicamente(Map<String, Integer> medicamente) {
        this.medicamente = medicamente;
    }

    @Override
    public String toString() {
        return "Reteta{" +
                "id='" + id + '\'' +
                ", medic=" + medic +
                ", pacient=" + pacient +
                ", medicamente=" + medicamente +
                '}';
    }
}
