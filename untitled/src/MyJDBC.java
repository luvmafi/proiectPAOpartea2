import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyJDBC {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/proiectPAO";
    private static final String USER = "root";
    private static final String PASSWORD = "Mafieprost123";
    private static Connection connection;

    private MyJDBC() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
