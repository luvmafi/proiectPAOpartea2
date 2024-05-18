package dao.impl;

import dao.PacientDao;
import model.Pacient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacientDaoImpl extends GenericDaoImpl<Pacient> implements PacientDao {

    @Override
    public void adauga(Pacient pacient) throws SQLException {
        String sql = "INSERT INTO pacient (id, nume, prenume, cnp, adresa, numarTelefon) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pacient.getId());
            stmt.setString(2, pacient.getNume());
            stmt.setString(3, pacient.getPrenume());
            stmt.setString(4, pacient.getCnp());
            stmt.setString(5, pacient.getAdresa());
            stmt.setString(6, pacient.getNumarTelefon());
            stmt.executeUpdate();
        }
    }

    @Override
    public Pacient gasesteDupaId(String id) throws SQLException {
        Pacient pacient = null;
        String sql = "SELECT * FROM pacient WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                pacient = new Pacient(
                        rs.getString("id"),
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getString("cnp"),
                        rs.getString("adresa"),
                        rs.getString("numarTelefon"));
            }
        }
        return pacient;
    }

    @Override
    public void actualizeaza(Pacient pacient) throws SQLException {
        String sql = "UPDATE pacient SET nume = ?, prenume = ?, cnp = ?, adresa = ?, numarTelefon = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pacient.getNume());
            stmt.setString(2, pacient.getPrenume());
            stmt.setString(3, pacient.getCnp());
            stmt.setString(4, pacient.getAdresa());
            stmt.setString(5, pacient.getNumarTelefon());
            stmt.setString(6, pacient.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void stergeDupaId(String id) throws SQLException {
        String sql = "DELETE FROM pacient WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Pacient> obtineToate() throws SQLException {
        List<Pacient> pacienti = new ArrayList<>();
        String sql = "SELECT * FROM pacient";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Pacient pacient = new Pacient(
                        rs.getString("id"),
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getString("cnp"),
                        rs.getString("adresa"),
                        rs.getString("numarTelefon"));
                pacienti.add(pacient);
            }
        }
        return pacienti;
    }
}
