package task14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Task 14.
A sequence of customer information for a supplierList of type Supplier and a sequence of discounts for customers in various stores,
supplierDiscountList of type SupplierDiscount is given.
Each element of the supplierList sequence includes the fields <customer_ID>, <year_of_birth>, <street_of_residence>.
Each element of the supplierDiscountList sequence includes the fields <customer_ID>, <store_name>, <discount_percentage>.
Get a list (maxDiscountOwner values) of all stores and for each store find a customer who has the maximum discount in it.
If for a certain store there are several customers with the maximum discount, then take the data on the consumer with the minimum code.
Sort the list by store names in ascending alphabetical order. Call stream() for both lists.
For example:
input: { Supplier(1, 1993, “Sumskaya”) Supplier(2, 1994, “Pushkinskaya”) Supplier(3, 1995, “Beketova”) Supplier(4, 1996, “Amosova”) Supplier(5, 1996, “Amosova”)
SupplierDiscount(1, 9, “Posad”) SupplierDiscount(2, 9, “Posad”) SupplierDiscount(3, 10, “Colins”) SupplierDiscount(4, 10, “Colins”) SupplierDiscount(5, 10, “Denim”) }
output: { (“Colins”, new Supplier(3, 1995, “Beketova”)) (“Denim”, new Supplier(5, 1996, “Amosova”)) (“Posad”, new Supplier(1, 1993, “Sumskaya”)) }

 */
public class Task14 {

    public static void main(String[] args) {

        List<Supplier> supplierList = Arrays.asList(
                new Supplier(1, 1993, "Sumskaya"),
                new Supplier(2, 1994, "Pushkinskaya"),
                new Supplier(3, 1995, "Beketova"),
                new Supplier(4, 1996, "Amosova"),
                new Supplier(5, 1996, "Amosova")
        );
        List<SupplierDiscount> supplierDiscountList = Arrays.asList(
                new SupplierDiscount(1, "Posad", 9),
                new SupplierDiscount(2, "Posad", 9),
                new SupplierDiscount(3, "Colins", 10),
                new SupplierDiscount(4, "Colins", 10),
                new SupplierDiscount(5, "Denim", 10)
        );

        ///Get a list (maxDiscountOwner values) of all stores and for each store find a customer who has the maximum discount in it.
        //map of customerId of store
        Map<Integer, Supplier> mapCustomerIdOfSupplier = getMapCustomerIdOfSupplier(supplierList);

        //map to store max discount details
        Map<String, MaxDiscountOwner> maxDiscountOwnerMap = getMaxDiscountOwnerMap(supplierDiscountList, mapCustomerIdOfSupplier);

        //convert to list and sort by store names
        List<MaxDiscountOwner> storeNamesList = convertMapDiscounterOwnerToList(maxDiscountOwnerMap);

        //print store names
        storeNamesList.forEach(System.out::println);
    }
    public static  Map<Integer, Supplier> getMapCustomerIdOfSupplier(List<Supplier> supplierList){
        return supplierList.stream()
                .collect(Collectors.toMap(Supplier::getCustomerId , s -> s));
    }
    public static Map<String, MaxDiscountOwner> getMaxDiscountOwnerMap(List<SupplierDiscount>supplierDiscountList, Map<Integer, Supplier> mapCustomerIdOfSupplier){
        return supplierDiscountList.stream()
                .collect(Collectors.groupingBy(
                        SupplierDiscount::getStoreName,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .max(Comparator.comparingInt(SupplierDiscount::getDiscountPercentage)
                                                .thenComparing(SupplierDiscount::getCustomerId))
                                        .map(discount -> new MaxDiscountOwner(
                                                discount.storeName,
                                                mapCustomerIdOfSupplier.get(discount.customerId)
                                        )).orElse(null)
                        )
                ));
    }

    public static List<MaxDiscountOwner> convertMapDiscounterOwnerToList(Map<String, MaxDiscountOwner> maxDiscountOwnerMap){
        return maxDiscountOwnerMap.values().stream()
                .sorted(Comparator.comparing(owner -> owner.storeName))
                .collect(Collectors.toList());
    }


}
