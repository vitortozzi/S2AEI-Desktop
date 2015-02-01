
package Model.Database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/s2aeij_beta", "root", "");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
