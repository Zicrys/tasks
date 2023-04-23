package Task17;

import java.sql.*;


public class dbConnection {

    static Connection connection;
    static PreparedStatement pstatement;
    static dbConnection object;
    static Statement statement;

    private dbConnection() throws SQLException {
        if(connection==null){
            String url = "jdbc:postgresql://" + dbConfig.SERVER_IP + "/" + dbConfig.DATABASENAME;
            connection = DriverManager.getConnection(url, dbConfig.USERNAME, dbConfig.PASSWORD);
            statement = connection.createStatement();
        }
    }

    //getConnectionDB() - singleton implementation
    static dbConnection getConnectionDB() throws SQLException {
        if(object==null){
            object = new dbConnection();
        }
        return object;
    }

    public static ResultSet select(String sql) throws SQLException {
        PreparedStatement pstatement = connection.prepareStatement(sql);
        return pstatement.executeQuery();
    }

    /**
     * execute() - метод для INSERT,UPDATE,DELETE операций с БД
     * @param sql - полностью сгенерированный SQL-запрос
     * @return
     * @throws SQLException
     */
    public static int execute(String sql) throws SQLException {
        PreparedStatement pstatement = connection.prepareStatement(sql);
        return pstatement.executeUpdate();
    }
}
