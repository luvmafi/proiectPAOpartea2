package dao.impl;

import model.Medic;
import model.Pacient;
import model.Reteta;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class RetetaDaoImpl extends GenericDaoImpl<Reteta> {

    @Override
    public void adauga(Reteta reteta) throws SQLException {
        String sql = "INSERT INTO reteta (id, medic, pacient, medicamente) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, reteta.getId());
            stmt.setString(2, reteta.getMedic().getId());
            stmt.setString(3, reteta.getPacient().getId());
            stmt.setString(4, convertMedicamenteToString(reteta.getMedicamente()));
            stmt.executeUpdate();
        }
    }

    @Override
    public Reteta gasesteDupaId(String id) throws SQLException {
        Reteta reteta = null;
        String sql = "SELECT * FROM reteta WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Medic medic = getMedicById(rs.getString("medic"));
                Pacient pacient = getPacientById(rs.getString("pacient"));
                Map<String, Integer> medicamente = convertStringToMedicamente(rs.getString("medicamente"));
                reteta = new Reteta(rs.getString("id"), medic, pacient, medicamente);
            }
        }
        return reteta;
    }

    @Override
    public void actualizeaza(Reteta reteta) throws SQLException {
        String sql = "UPDATE reteta SET medic = ?, pacient = ?, medicamente = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, reteta.getMedic().getId());
            stmt.setString(2, reteta.getPacient().getId());
            stmt.setString(3, convertMedicamenteToString(reteta.getMedicamente()));
            stmt.setString(4, reteta.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void stergeDupaId(String id) throws SQLException {
        String sql = "DELETE FROM reteta WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Reteta> obtineToate() throws SQLException {
        List<Reteta> retete = new ArrayList<>();
        String sql = "SELECT * FROM reteta";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Medic medic = getMedicById(rs.getString("medic"));
                Pacient pacient = getPacientById(rs.getString("pacient"));
                Map<String, Integer> medicamente = convertStringToMedicamente(rs.getString("medicamente"));
                Reteta reteta = new Reteta(rs.getString("id"), medic, pacient, medicamente);
                retete.add(reteta);
            }
        }
        return retete;
    }

    private String convertMedicamenteToString(Map<String, Integer> medicamente) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : medicamente.entrySet()) {
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
        }
        return sb.toString();
    }

    private Map<String, Integer> convertStringToMedicamente(String str) {
        Map<String, Integer> medicamente = new HashMap<>();
        String[] items = str.split(",");
        for (String item : items) {
            String[] parts = item.split(":");
            medicamente.put(parts[0], Integer.parseInt(parts[1]));
        }
        return medicamente;
    }


    private Medic getMedicById(String id) {

        return new Medic(id, "Popescu Ion", "Cardiologie");
    }

    private Pacient getPacientById(String id) {

        return new Pacient(id, "Miron", "Ion", "11111", "Str. Mihai Viteazu, nr. 1", "0722222222");
    }
}
