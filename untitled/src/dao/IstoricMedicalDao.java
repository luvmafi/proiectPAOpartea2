package dao;

import model.IstoricMedical;

import java.sql.SQLException;
import java.util.List;

public interface IstoricMedicalDao extends GenericDao<IstoricMedical> {
    void adaugaIstoric(IstoricMedical istoricMedical) throws SQLException;
    IstoricMedical gasesteIstoricDupaIdPacient(String idPacient) throws SQLException;
    void actualizeazaIstoric(IstoricMedical istoricMedical) throws SQLException;
    void stergeIstoricDupaIdPacient(String idPacient) throws SQLException;
    List<IstoricMedical> obtineToate() throws SQLException;
}
