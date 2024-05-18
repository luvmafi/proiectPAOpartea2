package dao.impl;

import model.Medic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicDaoImpl extends GenericDaoImpl<Medic> {

    @Override
    public void adauga(Medic medic) throws SQLException {
        String sql = "INSERT INTO medic (id, nume, specializare) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medic.getId());
            stmt.setString(2, medic.getNume());
            stmt.setString(3, medic.getSpecializare());
            stmt.executeUpdate();
        }
    }

    @Override
    public Medic gasesteDupaId(String id) throws SQLException {
        Medic medic = null;
        String sql = "SELECT * FROM medic WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                medic = new Medic(rs.getString("id"), rs.getString("nume"), rs.getString("specializare"));
            }
        }
        return medic;
    }

    @Override
    public void actualizeaza(Medic medic) throws SQLException {
        String sql = "UPDATE medic SET nume = ?, specializare = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medic.getNume());
            stmt.setString(2, medic.getSpecializare());
            stmt.setString(3, medic.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void stergeDupaId(String id) throws SQLException {
        String sql = "DELETE FROM medic WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Medic> obtineToate() throws SQLException {
        List<Medic> medici = new ArrayList<>();
        String sql = "SELECT * FROM medic";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Medic medic = new Medic(rs.getString("id"), rs.getString("nume"), rs.getString("specializare"));
                medici.add(medic);
            }
        }
        return medici;
    }
}
