package model;

public class Medic {
    private String id;
    private String nume;
    private String specializare;

    public Medic(String id, String nume, String specializare) {
        this.id = id;
        this.nume = nume;
        this.specializare = specializare;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    @Override
    public String toString() {
        return "Medic{" +
                "id='" + id + '\'' +
                ", nume='" + nume + '\'' +
                ", specializare='" + specializare + '\'' +
                '}';
    }
}
