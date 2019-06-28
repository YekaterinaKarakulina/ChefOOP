package epam.ProductsHierarchy;

public class FreshVegetables extends Vegetables {
    private String taste;
    private String smell;

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getSmell() {
        return smell;
    }

    public void setSmell(String smell) {
        this.smell = smell;
    }

    public FreshVegetables(String title, double calorie, String color, String taste, String smell) {
        super(title, calorie, color);
        this.taste = taste;
        this.smell = smell;
    }

    public FreshVegetables(String title, double calorie, double proteins, double fats, double carbohydrates, String color, String taste, String smell) {
        super(title, calorie, proteins, fats, carbohydrates, color);
        this.taste = taste;
        this.smell = smell;
    }
}
