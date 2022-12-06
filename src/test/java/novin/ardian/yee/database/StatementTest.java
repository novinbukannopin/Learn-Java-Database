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
public class StatementTest {

    @Test
    void testCreateStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        statement.close();
        connection.close();
    }

    @Test
    void testExecuteUpdate() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sqlInsert = """
                INSERT INTO mhs(nim, nama, alamat) 
                VALUES ('09020621039', 'Novin', 'novin@jdbc.com')
                """;

        String sqlUpdateWhere = """
                UPDATE mhs SET nim = '097', nama = 'lord', alamat = 'lamongan'
                WHERE nim = '09020621039'
                """;
        int update = statement.executeUpdate(sqlInsert);
        System.out.println(update);
        statement.close();
        connection.close();
    }

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
                SELECT * FROM customers
                """;
        ResultSet resultSet = statement.executeQuery(sqlSelect);
        statement.close();
        connection.close();
    }
}
