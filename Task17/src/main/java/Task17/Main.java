package Task17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, IOException {

        Market.showGoods();
        Market.buy();

        //проверка состава коллекции HashMap idCount,
        // также нужен метод проверки соттветствия введённого id и amount
        //и наличия этих id и amount в БД
        for (var s : Market.idAmount.entrySet()) {
            System.out.println(s.getKey() + " : " + s.getValue());
        }
    }
}