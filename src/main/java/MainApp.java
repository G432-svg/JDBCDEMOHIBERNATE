import dao.BeersDao;
import dao.CategoryDao;
import dao.BrewersDao;
import model.Beer;
import model.Brewer;
import model.Category;

import java.lang.*;
import java.sql.SQLException;


public class MainApp {
    public static void main(String[] args) throws SQLException {

        try {
            Beer beer = new Beer(1557, "otilia", 0, 0, 1.35, 2, 6);
            BeersDao beersDao = new BeersDao();

//            beersDao.deleteBeer(6001);
//            beersDao.deleteBeer(8000);
            beersDao.getAllBeers().forEach(System.out::println);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Brewer brewer = new Brewer(127,"Timisoreana","oudestraaat 12",1445,"Wavre",253);
        Brewer brewer1 = new Brewer(128,"Blonda"," klinkel 4",1223,"Amsterdam",556);

        BrewersDao brewersDao = new BrewersDao();

        brewersDao.deleteBrewer(127);
        brewersDao.deleteBrewer(128);
        brewersDao.getAllBrewers().forEach(System.out::println);


        Category category = new Category(66,"Geuze");
        Category category2 = new Category(67,"Bruine Geuze");

        CategoryDao categoryDao = new CategoryDao();

        categoryDao.deleteCategory(66);
        categoryDao.deleteCategory(67);
        categoryDao.getAllCategories().forEach(System.out::println);


    }
}
