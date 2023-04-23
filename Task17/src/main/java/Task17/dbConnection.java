package Task17;

import org.postgresql.Driver;

import java.sql.*;


public class ConnectionDB {

    static Connection connection;

    private ConnectionDB() throws SQLException {
        getConnectionDB();
    }

    static Connection getConnectionDB() throws SQLException {
        if(connection==null){
            String url = "jdbc:postgresql://" + ConfigDB.SERVER_IP + "/" + ConfigDB.DATABASENAME;
            connection = DriverManager.getConnection(url, ConfigDB.USERNAME, ConfigDB.PASSWORD);
        }
        return connection;
    }

    public static ResultSet select(String sql) throws SQLException {
        PreparedStatement pstatement = getConnectionDB().prepareStatement(sql);
        return pstatement.executeQuery();
    }

    public static int execute(String sql) throws SQLException {
        PreparedStatement pstatement = getConnectionDB().prepareStatement(sql);
        return pstatement.executeUpdate();
    }
}
