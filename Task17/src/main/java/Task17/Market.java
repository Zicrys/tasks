package Task17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Market {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<Integer, Integer> idAmount = new HashMap<>();
    //static Map<Integer, Integer> availibility = new HashMap<>();
    /**
     * showGoods() - метод отображения всех товаров в магазине
     * @throws SQLException
     */
    static void showGoods() throws SQLException {
        dbConnection.getConnectionDB();
        ResultSet rs = dbCommands.select("SELECT * FROM goods");
        while(rs.next()){
            System.out.println("id Товара: " + rs.getInt("good_id") +
                    " Название товара: " + rs.getString("title") +
                    " Количество: " + rs.getInt("amount"));
        }
    }

    /**
     * showBasketShop() - метод отображения всех товаров в корзине покупок
     * @throws SQLException
     */
    static void showBasketShop() throws SQLException {
        dbConnection.getConnectionDB();
        ResultSet rs = dbCommands.select("SELECT * FROM basketShop");
        while(rs.next()){
            System.out.println("id Товара: " + rs.getInt("good_id") +
                    " Название товара: " + rs.getString("title") +
                    " Количество: " + rs.getInt("amount"));
        }
    }

    /**
     * buy() - Метод, в котором пользователя формирует корзину покупок
     * @throws IOException
     */
    static void buy() throws IOException {
        //rp - строка, в которую записывается ответ пользователя
        String rp;
        //response - обработанный ответ
        String[] response;
        while(true){
            System.out.println("Введите id товара и количество для добавления в" +
                    "корзину в формате(id:count), выход(exit): ");
            //ответ пользователя
            rp = br.readLine();
            //если ответ соответствует заданному шаблону
            if(isCheckFormat(rp)){
                //разделяем строку на массив подстрок, разделителем является символ ':'
                response = rp.split(":");
                //преобразуем массив строк в целочисленный массив и кладём
                // в коллекцию HashMap: idCount <K,V> в соответствии с индексами
                idAmount.put(Integer.parseInt(response[0]),Integer.parseInt(response[1]));
                //если ввели "exit" - покупка завершена
            }else if(rp.equalsIgnoreCase("exit")){
                System.out.println("Формирование корзины завершено");
                break;
                //иначе - продолжаем покупку
            }else
                System.out.println("Неправильный формат ввода");
        }
    }

    /**
     * isCheckFormat(string) - проверка строки на соответсвие заданному шаблону
     * @param string - строка, которую будем проверять
     * @return - true или false
     * @throws IOException
     */
    static boolean isCheckFormat(String string) throws IOException {
        //создаём шаблон: любое_число:любое_число
        Pattern pt = Pattern.compile("[1234567890]+:[1234567890]+");
        Matcher mt = pt.matcher(string);
        return mt.matches();
    }

    /*static boolean isCheckAvailibilityOfGood(HashMap<Integer,Integer> idAmount){
        for (var item : idAmount.entrySet()) {
            if(item.getKey()))
        }
    }*/
}

