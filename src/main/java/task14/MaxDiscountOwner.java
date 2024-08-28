package task14;

public class MaxDiscountOwner {
    String storeName;
    Supplier supplier;

    public MaxDiscountOwner(String storeName, Supplier supplier) {
        this.storeName = storeName;
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "MaxDiscountOwner{" +
                "storeName='" + storeName + '\'' +
                ", supplier=" + supplier +
                '}';
    }
}
