package novin.ardian.yee.database;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * @author Novin on 15/08/2022
 * @project Learn-Java-Database
 */
public class MetaDataTest {

    @Test
    void testDatabaseMetaData() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        DatabaseMetaData databaseMetaData = connection.getMetaData();

        System.out.println(databaseMetaData.getDatabaseProductName());
        ResultSet resultSet = databaseMetaData.getTables("uinsa", null, null, null);
        while (resultSet.next()) {
            String tableName = resultSet.getString("TABLE_NAME");
            System.out.println(tableName);
        }

        connection.close();
    }

    @Test
    void testParameterMetaData() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO comments(email,comment) VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
        System.out.println(parameterMetaData.getParameterCount());
//        System.out.println(parameterMetaData.getParameterType(1));
    }

    @Test
    void testResultSetMetaData() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        System.out.println(resultSetMetaData.getColumnCount());

        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            System.out.println("Name = " + resultSetMetaData.getColumnName(i));
            System.out.println("Type = " + resultSetMetaData.getColumnType(i));
            System.out.println("Typename = " + resultSetMetaData.getColumnTypeName(i));
        }

//        java.sql.Types.

        resultSet.close();
        statement.close();
        connection.close();
    }
}
