package epam.ProductsHierarchy;

public class Vegetables extends Product {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Vegetables(String title, double calorie, String color) {
        super(title, calorie);
        this.color = color;
    }

    public Vegetables(String title, double calorie, double proteins, double fats, double carbohydrates, String color) {
        super(title, calorie, proteins, fats, carbohydrates);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vegetables:" + super.getTitle() + '\'' + "; " +
                "calorie " + super.getCalorie() + '\'' + "; " +
                "proteins " + super.getProteins() + " fats " + super.getFats() + " carbohydrates " + super.getCarbohydrates() + '\'' +
                "color='" + color + '\'' + "\n";
    }
}
