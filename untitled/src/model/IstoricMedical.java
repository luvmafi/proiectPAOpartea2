package model;

import java.util.List;

public class IstoricMedical {
    private String idPacient;
    private List<String> istoricBoala;

    public IstoricMedical(String idPacient, List<String> istoricBoala) {
        this.idPacient = idPacient;
        this.istoricBoala = istoricBoala;
    }

    public String getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(String idPacient) {
        this.idPacient = idPacient;
    }

    public List<String> getIstoricBoala() {
        return istoricBoala;
    }

    public void setIstoricBoala(List<String> istoricBoala) {
        this.istoricBoala = istoricBoala;
    }

    @Override
    public String toString() {
        return "IstoricMedical{" +
                "idPacient='" + idPacient + '\'' +
                ", istoricBoala=" + istoricBoala +
                '}';
    }
}
