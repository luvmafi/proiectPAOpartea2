package dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {
    void adauga(T t) throws SQLException;
    T gasesteDupaId(String id) throws SQLException;
    void actualizeaza(T t) throws SQLException;
    void stergeDupaId(String id) throws SQLException;
    List<T> obtineToate() throws SQLException;
}
