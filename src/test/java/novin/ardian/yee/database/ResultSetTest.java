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
public class ResultSetTest {
    @Test
    void testExecuteQuery() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sqlInsert = """
                INSERT INTO customers(id, name, email) 
                VALUES ('eko', 'Eko', 'eko@jdbc.com')
                """;

        String sqlUpdateWhere = """
                DELETE FROM customers where id = 'eko'
                """;

        String sqlSelect = """
                SELECT * FROM mhs
                """;
        ResultSet resultSet = statement.executeQuery(sqlSelect);
        while (resultSet.next()) {
            String id = resultSet.getString("nim");
            String name = resultSet.getString("nama");
            String email = resultSet.getString("alamat");

            System.out.println(String.join(", ", id, name, email));
        }
        statement.close();
        connection.close();
    }
}
