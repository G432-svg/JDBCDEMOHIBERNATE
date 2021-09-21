package model;

public class Category {

    private int Id;
    private String category;

    public Category(){

    }

    public Category(int id, String category) {
        Id = id;
        this.category = category;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "Id=" + Id +
                ", category='" + category + '\'' +
                '}';
    }
}
