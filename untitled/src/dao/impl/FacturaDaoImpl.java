package dao.impl;

import dao.FacturaDao;
import model.Factura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDaoImpl extends GenericDaoImpl<Factura> implements FacturaDao {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/proiectPAO";
    private static final String USER = "root";
    private static final String PASSWORD = "Mafieprost123";

    @Override
    public void adauga(Factura factura) throws SQLException {
        String sql = "INSERT INTO factura (id, pacient_id, sumaDePlata, dataEmiterii, estePlatita) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, factura.getId());
            stmt.setString(2, factura.getPacientId());
            stmt.setDouble(3, factura.getSumaDePlata());
            stmt.setDate(4, Date.valueOf(factura.getDataEmiterii()));
            stmt.setBoolean(5, factura.isEstePlatita());
            stmt.executeUpdate();
        }
    }

    @Override
    public Factura gasesteDupaId(String id) throws SQLException {
        Factura factura = null;
        String sql = "SELECT * FROM factura WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                factura = new Factura(
                        rs.getString("id"),
                        rs.getString("pacient_id"),
                        rs.getDouble("sumaDePlata"),
                        rs.getDate("dataEmiterii").toLocalDate(),
                        rs.getBoolean("estePlatita"));
            }
        }
        return factura;
    }

    @Override
    public void actualizeaza(Factura factura) throws SQLException {
        String sql = "UPDATE factura SET pacient_id = ?, sumaDePlata = ?, dataEmiterii = ?, estePlatita = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, factura.getPacientId());
            stmt.setDouble(2, factura.getSumaDePlata());
            stmt.setDate(3, Date.valueOf(factura.getDataEmiterii()));
            stmt.setBoolean(4, factura.isEstePlatita());
            stmt.setString(5, factura.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void stergeDupaId(String id) throws SQLException {
        String sql = "DELETE FROM factura WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Factura> obtineToate() throws SQLException {
        List<Factura> facturi = new ArrayList<>();
        String sql = "SELECT * FROM factura";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Factura factura = new Factura(
                        rs.getString("id"),
                        rs.getString("pacient_id"),
                        rs.getDouble("sumaDePlata"),
                        rs.getDate("dataEmiterii").toLocalDate(),
                        rs.getBoolean("estePlatita"));
                facturi.add(factura);
            }
        }
        return facturi;
    }

    @Override
    public void adaugaFactura(Factura factura) throws SQLException {
        adauga(factura);
    }

    @Override
    public Factura gasesteFacturaDupaId(String id) throws SQLException {
        return gasesteDupaId(id);
    }

    @Override
    public void actualizeazaFactura(Factura factura) throws SQLException {
        actualizeaza(factura);
    }

    @Override
    public void stergeFacturaDupaId(String id) throws SQLException {
        stergeDupaId(id);
    }

    @Override
    public List<Factura> obtineToateFacturile() throws SQLException {
        return obtineToate();
    }
}
