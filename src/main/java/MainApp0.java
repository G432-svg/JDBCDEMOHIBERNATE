import model.Beer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp0 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give a max alcohol");
        int alcohol = scanner.nextInt();
        System.out.println("Give a max price");
        double price = scanner.nextDouble();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://moktok.intecbrussel.org:33062/otilia", "otilia", "otilia")){

            System.out.println("Connection successful");

            Statement statement = connection.createStatement();

//            String select = "SELECT * FROM Animal WHERE name LIKE ?";

//            PreparedStatement preparedStatement = connection.prepareStatement(select);
//            preparedStatement.setString(0,name);

            String select = "SELECT * FROM Beers WHERE alcohol < ? AND price < ?";
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.setInt(1, alcohol);
            preparedStatement.setDouble(2,price);

//            String insert = "INSERT INTO Animal(id,name,country,foodId,countryId) VALUES(12,'llama','Peru', null,null)";


//            String update = "UPDATE Animal SET id = 1 WHERE name LIKE 'zebra'";
//            String delete = "DELETE FROM Animal where id = 1";
//            statement.executeUpdate(update);

//            String select = "SELECT * FROM Animal WHERE name LIKE 'l%' ";

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Beer> beers = new ArrayList<>();

            while (resultSet.next()){
                Beer beer = new Beer();
                beer.setId(resultSet.getInt("id"));
                beer.setName(resultSet.getString("name"));
                beer.setAlcohol(resultSet.getInt("alcohol"));
                beer.setBrewerId(resultSet.getInt("BrewerId"));
                beer.setCategoryId(resultSet.getInt("CategoryId"));
                beer.setPrice(resultSet.getDouble("price"));
                beer.setStock(resultSet.getInt("stock"));

                beers.add(beer);

//                System.out.println(resultSet.getInt("id")+"--");
//                System.out.println(resultSet.getString("name"));
            }
            for (Beer beer: beers){
                System.out.println(beer);
            }

            //statement.executeQuery(insert);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
