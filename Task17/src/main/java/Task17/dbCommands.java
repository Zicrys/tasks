package Task17;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbCommands {
    StringBuilder sql = new StringBuilder();//Запрос к бд

    public static ResultSet select(String sql) throws SQLException {
        return dbConnection.statement.executeQuery(sql);
    }

    /**
     * execute() - метод для INSERT,UPDATE,DELETE операций с БД
     * @param sql - полностью сгенерированный SQL-запрос
     * @return
     * @throws SQLException
     */
    public static int execute(String sql) throws SQLException {
        PreparedStatement pstatement = dbConnection.connection.prepareStatement(sql);
        return pstatement.executeUpdate();
    }

}
