package Task17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        ConnectionDB.getConnectionDB();
        ResultSet rs = ConnectionDB.select("SELECT * FROM goods");
        while(rs.next()){
            System.out.println("id Товара: " + rs.getInt("good_id") +
                   " Название товара: " + rs.getString("title") +
                   " Количество: " + rs.getInt("amount"));
        }


        StringBuilder sql = new StringBuilder();//Запрос к бд
        Market.buy();
        for (var s : Market.idCount.entrySet()) {
            System.out.println(s.getKey() + " : " + s.getValue());
        }
    }
}