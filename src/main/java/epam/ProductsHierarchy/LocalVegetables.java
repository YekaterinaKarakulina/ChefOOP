package epam.ProductsHierarchy;

public class LocalVegetables extends FreshVegetables {
    private String typeOfCultivation;

    public String getTypeOfCultivation() {
        return typeOfCultivation;
    }

    public void setTypeOfCultivation(String typeOfCultivation) {
        this.typeOfCultivation = typeOfCultivation;
    }

    public LocalVegetables(String title, double calorie, String color, String taste, String smell, String typeOfCultivation) {
        super(title, calorie, color, taste, smell);
        this.typeOfCultivation = typeOfCultivation;
    }

    public LocalVegetables(String title, double calorie, double proteins, double fats, double carbohydrates, String color, String taste, String smell, String typeOfCultivation) {
        super(title, calorie, proteins, fats, carbohydrates, color, taste, smell);
        this.typeOfCultivation = typeOfCultivation;
    }
}
