package novin.ardian.yee.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * @author Novin on 15/08/2022
 * @project Learn-Java-Database
 */
public class BatchTest {

    @Test
    void testStatement() throws Exception {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO comments(email, comment) VALUES ('novin@nvn.com', 'hi')";

        for (int i = 0; i < 1000; i++) {
            statement.addBatch(sql);
        }

        statement.executeBatch();
        statement.close();

        connection.close();
    }

    @Test
    void testPreparedStatement() throws Exception{
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO comments(email, comment) VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < 500; i++) {
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "novinn@nvnn.com");
            preparedStatement.setString(2, "haiii");
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();

        preparedStatement.close();
        connection.close();
    }
}
