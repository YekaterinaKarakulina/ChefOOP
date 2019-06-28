package epam.ProductsHierarchy;

public class FrozenVegetbles extends Vegetables {
    private String freezingmethod;
    private String packaging;

    public String getFreezingmethod() {
        return freezingmethod;
    }

    public void setFreezingmethod(String freezingmethod) {
        this.freezingmethod = freezingmethod;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public FrozenVegetbles(String title, double calorie, String color, String freezingmethod, String packaging) {
        super(title, calorie, color);
        this.freezingmethod = freezingmethod;
        this.packaging = packaging;
    }

    public FrozenVegetbles(String title, double calorie, double proteins, double fats, double carbohydrates, String color, String freezingmethod, String packaging) {
        super(title, calorie, proteins, fats, carbohydrates, color);
        this.freezingmethod = freezingmethod;
        this.packaging = packaging;
    }
}
