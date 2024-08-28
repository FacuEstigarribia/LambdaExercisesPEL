package task15;

import java.math.BigDecimal;

public class StorePrice {
    int productSKU;
    String storeTitle;
    BigDecimal price;

    StorePrice(int productSKU, String storeTitle, BigDecimal price) {
        this.productSKU = productSKU;
        this.storeTitle = storeTitle;
        this.price = price;
    }

    public int getProductSKU() {
        return productSKU;
    }

    public String getStoreTitle() {
        return storeTitle;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
