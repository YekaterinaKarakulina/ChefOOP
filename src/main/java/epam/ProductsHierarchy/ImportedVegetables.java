package epam.ProductsHierarchy;

public class ImportedVegetables extends FreshVegetables {
    private String countyImporter;

    public String getCountyImporter() {
        return countyImporter;
    }

    public void setCountyImporter(String countyImporter) {
        this.countyImporter = countyImporter;
    }

    public ImportedVegetables(String title, double calorie, String color, String taste, String smell, String countyImporter) {
        super(title, calorie, color, taste, smell);
        this.countyImporter = countyImporter;
    }

    public ImportedVegetables(String title, double calorie, double proteins, double fats, double carbohydrates, String color, String taste, String smell, String countyImporter) {
        super(title, calorie, proteins, fats, carbohydrates, color, taste, smell);
        this.countyImporter = countyImporter;
    }
}
