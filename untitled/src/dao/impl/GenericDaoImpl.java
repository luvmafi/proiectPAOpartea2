package dao.impl;

import dao.GenericDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/proiectPAO";
    private static final String USER = "root";
    private static final String PASSWORD = "Mafieprost123";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public abstract void adauga(T t) throws SQLException;

    @Override
    public abstract T gasesteDupaId(String id) throws SQLException;

    @Override
    public abstract void actualizeaza(T t) throws SQLException;

    @Override
    public abstract void stergeDupaId(String id) throws SQLException;

    @Override
    public abstract List<T> obtineToate() throws SQLException;
}
