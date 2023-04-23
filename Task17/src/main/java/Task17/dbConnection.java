package Task17;

import java.sql.*;

public class dbConnection {

    static Connection connection;
    static dbConnection object;
    static Statement statement;

    //Singleton
    private dbConnection() throws SQLException {
        if(connection==null){
            String url = "jdbc:postgresql://" + dbConfig.SERVER_IP + "/" + dbConfig.DATABASENAME;
            connection = DriverManager.getConnection(url, dbConfig.USERNAME, dbConfig.PASSWORD);
            statement = connection.createStatement();
        }
    }
    //Singleton
    static dbConnection getConnectionDB() throws SQLException {
        if(object==null){
            object = new dbConnection();
        }
        return object;
    }
}
