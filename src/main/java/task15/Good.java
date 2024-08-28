package task15;

public class Good {
    int productSKU;
    String countryOfOrigin;

    Good(int productSKU, String countryOfOrigin) {
        this.productSKU = productSKU;
        this.countryOfOrigin = countryOfOrigin;
    }

    public int getProductSKU() {
        return productSKU;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }
}
