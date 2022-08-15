package novin.ardian.yee.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Novin on 15/08/2022
 * @project Learn-Java-Database
 */
public class TransactionTest {

    @Test
    void testCommit() throws Exception {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO comments(email, comment) VALUES(?,?)";

        for (int i = 0; i < 100; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "novinn@nvnn.com");
            preparedStatement.setString(2, "haiii");
            preparedStatement.executeUpdate();

            preparedStatement.close();
        }
        connection.commit();
        connection.close();
    }

    @Test
    void testRollback() throws SQLException, SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO comments(email, comment) VALUES(?,?)";

        for (int i = 0; i < 100; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "novinn@nvnn.com");
            preparedStatement.setString(2, "haiii");
            preparedStatement.executeUpdate();

            preparedStatement.close();
        }
        connection.rollback();
        connection.close();
    }
}
