package novin.ardian.yee.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Novin on 03/08/2022
 * @project Learn-Java-Database
 */
public class SQLInjectionTest {

    @Test
    void testSQLInjection() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String username = "admin'; #";
        String password = "novin";

        String sqlSelect = "SELECT * FROM admin WHERE username = '" + username + "' AND PASSWORD = '" + password + "'";
        ResultSet resultSet = statement.executeQuery(sqlSelect);

        if (resultSet.next()) {
            System.out.println("Sukses Login : " + resultSet.getString("username"));
            System.out.println(sqlSelect);

        } else {
            System.out.println("Gagal Login");
        }
        statement.close();
        connection.close();
    }
}
