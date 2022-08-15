package novin.ardian.yee.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Novin on 03/08/2022
 * @project Learn-Java-Database
 */
public class DriverTest {

    @Test
    void testRegister() {

        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException sqlException) {
            Assertions.fail(sqlException);
        }
    }
}
