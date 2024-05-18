package config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/proiectPAO";
    private static final String USER = "root";
    private static final String PASSWORD = "Mafieprost123";

    public static void executeSqlScript(String filePath) throws IOException, SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sql.append(line);
                if (line.trim().endsWith(";")) {
                    stmt.execute(sql.toString());
                    sql.setLength(0);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            executeSqlScript("E:/proiectPAO/untitled/src/resources/create_tables.sql");
            System.out.println("Scriptul SQL a fost executat cu succes.");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
