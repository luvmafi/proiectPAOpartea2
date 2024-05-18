package dao;

import model.Pacient;

import java.sql.SQLException;
import java.util.List;

public interface PacientDao extends GenericDao<Pacient> {
    void adauga(Pacient pacient) throws SQLException;
    Pacient gasesteDupaId(String id) throws SQLException;
    void actualizeaza(Pacient pacient) throws SQLException;
    void stergeDupaId(String id) throws SQLException;
    List<Pacient> obtineToate() throws SQLException;
}
