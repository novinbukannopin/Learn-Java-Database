package novin.ardian.yee.database;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * @author Novin on 15/08/2022
 * @project Learn-Java-Database
 */
public class AutoIncreamentTest {

    @Test
    void autoIncrement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO comments(email, comment) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, "testnvn@nvn.com");
        preparedStatement.setString(2, "woi");
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if (resultSet.next()){
            System.out.println("Id Comment = " + resultSet.getInt(1));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
