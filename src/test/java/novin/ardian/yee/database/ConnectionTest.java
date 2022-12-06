package novin.ardian.yee.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Novin on 03/08/2022
 * @project Learn-Java-Database
 */
public class ConnectionTest {

    @BeforeAll
    static void beforeAll() {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Test
    void testConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/mahasiswa";
        String username = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Sukses Connect Database");
            System.out.println(connection);
//            connection.close();
//            System.out.println("Sukses Menutup Database");
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }

    @Test
    void testConnectionClose() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/mahasiswa";
        String username = "root";
        String password = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Sukses open Connection");
        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }
}
