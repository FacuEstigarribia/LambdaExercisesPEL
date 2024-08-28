package task14;

public class SupplierDiscount {
    int customerId;
    String storeName;
    int discountPercentage;

    public SupplierDiscount(int customerId, String storeName, int discountPercentage) {
        this.customerId = customerId;
        this.storeName = storeName;
        this.discountPercentage = discountPercentage;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getStoreName() {
        return storeName;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }
}
