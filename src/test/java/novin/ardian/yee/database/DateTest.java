package novin.ardian.yee.database;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * @author Novin on 15/08/2022
 * @project Learn-Java-Database
 */
public class DateTest {

    @Test
    void testDate() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = """
                INSERT INTO sample_time(sample_date, sample_time, simple_timestamp)
                VALUES(?,?,?)
                """;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDate(1, new Date(System.currentTimeMillis()));
        preparedStatement.setTime(2, new Time(System.currentTimeMillis()));
        preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    @Test
    void testDateQuery() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = """
                SELECT * FROM sample_time
                """;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Time time = resultSet.getTime("sample_time");
            System.out.println("Time = " + time);
            Date date = resultSet.getDate("sample_date");
            System.out.println("Date = " + date);
            Timestamp timestamp = resultSet.getTimestamp("simple_timestamp");
            System.out.println("Timestamp = " + timestamp);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
