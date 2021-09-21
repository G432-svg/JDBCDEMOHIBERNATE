package dao;
import model.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dao.ConnectionClass.getConnection;

public class CategoryDao {

    private Connection getConnection;

    public Category getCategoryId(int id) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT FROM Categories WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Category category = new Category();
        if (resultSet.next()) {
            category.setId(resultSet.getInt("id"));
            category.setCategory(resultSet.getString("category"));
        }

        return category;

    }

    public List<Category> getAllCategories() throws SQLException {
        Statement statement = getConnection.createStatement();
        String select = "SELECT * FROM Categories";
        ResultSet resultSet = statement.executeQuery(select);
        List<Category> categories = new ArrayList<>();
        while (resultSet.next()) {
            Category category = new Category();
            category.setId(resultSet.getInt("id"));
            category.setCategory(resultSet.getString("category"));
        }
        return categories;
    }
    public void createCategory(Category category) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO Categories(Id, Category) VALUES (?,?)");
        preparedStatement.setInt(1, category.getId());
        preparedStatement.setString(2, category.getCategory());
        preparedStatement.execute();
    }
    public void update(Category category,int id) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement("UPDATE Categories SET id = ?,category = ? WHERE id = ? ");
        preparedStatement.setInt(1,category.getId());
        preparedStatement.setString(2, category.getCategory());
        preparedStatement.executeUpdate();
    }
    public void deleteCategory(int Id) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement("DELETE FROM Categories WHERE id = ?");
        preparedStatement.setInt(1, Id);
        preparedStatement.executeUpdate();
    }

}