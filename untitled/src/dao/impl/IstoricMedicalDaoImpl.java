package dao.impl;

import dao.IstoricMedicalDao;
import model.IstoricMedical;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IstoricMedicalDaoImpl extends GenericDaoImpl<IstoricMedical> implements IstoricMedicalDao {

    @Override
    public void adaugaIstoric(IstoricMedical istoricMedical) throws SQLException {
        String sql = "INSERT INTO istoric_medical (id_pacient, boli) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, istoricMedical.getIdPacient());
            stmt.setString(2, String.join(",", istoricMedical.getIstoricBoala()));
            stmt.executeUpdate();
        }
    }

    @Override
    public IstoricMedical gasesteIstoricDupaIdPacient(String idPacient) throws SQLException {
        IstoricMedical istoricMedical = null;
        String sql = "SELECT * FROM istoric_medical WHERE id_pacient = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idPacient);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                List<String> boli = List.of(rs.getString("boli").split(","));
                istoricMedical = new IstoricMedical(rs.getString("id_pacient"), boli);
            }
        }
        return istoricMedical;
    }

    @Override
    public void actualizeazaIstoric(IstoricMedical istoricMedical) throws SQLException {
        String sql = "UPDATE istoric_medical SET boli = ? WHERE id_pacient = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, String.join(",", istoricMedical.getIstoricBoala()));
            stmt.setString(2, istoricMedical.getIdPacient());
            stmt.executeUpdate();
        }
    }

    @Override
    public void stergeIstoricDupaIdPacient(String idPacient) throws SQLException {
        String sql = "DELETE FROM istoric_medical WHERE id_pacient = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idPacient);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<IstoricMedical> obtineToate() throws SQLException {
        List<IstoricMedical> istoriceMedicale = new ArrayList<>();
        String sql = "SELECT * FROM istoric_medical";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                List<String> boli = List.of(rs.getString("boli").split(","));
                IstoricMedical istoricMedical = new IstoricMedical(rs.getString("id_pacient"), boli);
                istoriceMedicale.add(istoricMedical);
            }
        }
        return istoriceMedicale;
    }

    @Override
    public void adauga(IstoricMedical istoricMedical) throws SQLException {
        adaugaIstoric(istoricMedical);
    }

    @Override
    public IstoricMedical gasesteDupaId(String id) throws SQLException {
        return gasesteIstoricDupaIdPacient(id);
    }

    @Override
    public void actualizeaza(IstoricMedical istoricMedical) throws SQLException {
        actualizeazaIstoric(istoricMedical);
    }

    @Override
    public void stergeDupaId(String id) throws SQLException {
        stergeIstoricDupaIdPacient(id);
    }
}
