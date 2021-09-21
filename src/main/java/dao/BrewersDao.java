package dao;
import model.Brewer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dao.ConnectionClass.getConnection;

public class BrewersDao {



    public Brewer getBrewerByID(int id) throws SQLException {
        PreparedStatement preparedStatement = ConnectionClass.getConnection().prepareStatement("SELECT FROM Brewers WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Brewer brewer = new Brewer();
        if (resultSet.next()) {
            brewer.setId(resultSet.getInt("id"));
            brewer.setName(resultSet.getString("name"));
            brewer.setAddress(resultSet.getString("address"));
            brewer.setZipCode(resultSet.getInt("ZipCode"));
            brewer.setCity(resultSet.getString("City"));
            brewer.setTurnover(resultSet.getInt("Turnover"));
        }

        return brewer;
    }

    public List<Brewer> getAllBrewers() throws SQLException {

        Connection getConnection = null;
        Statement statement = getConnection.createStatement();
        String select = "SELECT * FROM Brewers";
        ResultSet resultSet = statement.executeQuery(select);
        List<Brewer> brewers = new ArrayList<>();
        while (resultSet.next()) {
            Brewer brewer = new Brewer();
            brewer.setId(resultSet.getInt("id"));
            brewer.setName(resultSet.getString("name"));
            brewer.setAddress(resultSet.getString("address"));
            brewer.setZipCode(resultSet.getInt("ZipCode"));
            brewer.setCity(resultSet.getString("City"));
            brewer.setTurnover(resultSet.getInt("Turnover"));
            brewers.add(brewer);

        }
        return brewers;

    }

    public void createBrewer (Brewer brewer) throws SQLException {
            PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO Brewers(Id, Name, Address, ZipCode, City,Turnover) VALUES (?,?,?,?,?,?)");
            preparedStatement.setInt(1, brewer.getId());
            preparedStatement.setString(2, brewer.getName());
            preparedStatement.setString(3, brewer.getAddress());
            preparedStatement.setInt(4, brewer.getZipCode());
            preparedStatement.setString(5, brewer.getCity());
            preparedStatement.execute();
    }


    public void updateBrewer(Brewer brewer, int id) throws SQLException {
            PreparedStatement preparedStatement = getConnection().prepareStatement("UPDATE Brewers SET id = ?,name = ?, address =?, zipcode = ?, city =? WHERE id = ? ");
            preparedStatement.setInt(1, brewer.getId());
            preparedStatement.setString(2, brewer.getName());
            preparedStatement.setString(3, brewer.getAddress());
            preparedStatement.setInt(4, brewer.getZipCode());
            preparedStatement.setString(5, brewer.getCity());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();

    }
    public void deleteBrewer( int id) throws SQLException {
            PreparedStatement preparedStatement = getConnection().prepareStatement("DELETE FROM Brewers WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

    }

}