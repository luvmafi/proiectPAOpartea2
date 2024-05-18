package model;

public class Pacient {
    private String id;
    private String nume;
    private String prenume;
    private String cnp;
    private String adresa;
    private String numarTelefon;

    public Pacient(String id, String nume, String prenume, String cnp, String adresa, String numarTelefon) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.adresa = adresa;
        this.numarTelefon = numarTelefon;
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

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "id='" + id + '\'' +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", cnp='" + cnp + '\'' +
                ", adresa='" + adresa + '\'' +
                ", numarTelefon='" + numarTelefon + '\'' +
                '}';
    }

}
