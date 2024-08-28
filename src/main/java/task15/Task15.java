package task15;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.*;

/*
A sequence of information about goods goodList of type Good
and a sequence of prices of goods in various stores storePriceList of type StorePrice are given.
Each element of the goodList sequence includes the <product_SKU>, , <country_of_origin> fields.
Each element of the storePriceList sequence includes the <product_SKU>, <store_Title>, fields.
For each country of origin get the number of stores offering goods manufactured in that country,
as well as the minimum price for goods from this country for all stores (CountryStat values).
If no product is found for a certain country that is presented in any store,
then the number of stores and the minimum price are assumed to be 0. Sort the list by country of origin.
Look at the template on the end of the task before solving the problem. For example:
input: { Good(1, “milk”, “Poland”), Good(2, “milk”, “Russia”) }, { StorePrice(1, “BigShop”, BigDecimal(“12.50”)), StorePrice(1, “SushiBar”, BigDecimal(“10.50”)), StorePrice(2, “BigShop”, BigDecimal(“12.50”)) }
output: { CountryStat(“Poland”, 2, BigDecimal(“10.50)), CountryStat(“Russia”, 1, BigDecimal(“12.50")) }
An example of solving a task in AutoCode.
Task. Given a sequence of strings stringList. Get a new list of non-empty strings from stringList.
public static List<String> getStringList(List<String> stringList){
    return stringList.stream()
            .filter(string -> !string.isEmpty())
            .collect(Collectors.toList());
}
Consider that the values have already been set for stringList, and the assignment of new values is an error.
Return the result of solving the problem via the function.
 */
public class Task15 {

    public static void main(String[] args) {
        // Example inputs
        List<Good> goodList = Arrays.asList(
                new Good(1, "Poland"),
                new Good(2, "Russia")
        );

        List<StorePrice> storePriceList = Arrays.asList(
                new StorePrice(1, "BigShop", new BigDecimal("12.50")),
                new StorePrice(1, "SushiBar", new BigDecimal("10.50")),
                new StorePrice(2, "BigShop", new BigDecimal("12.50"))
        );

        // Map SKU to country
        Map<Integer, String> skuToCountryMap = getMapToCountry(goodList);

        // Map SKU to list of prices
        Map<Integer, List<StorePrice>> skuToPricesMap = getMapSkuToCountry(storePriceList);

        // Call solution method
        List<CountryStat> result = solution(goodList, skuToPricesMap);

        // Print list
        result.forEach(System.out::println);
    }

    public static Map<Integer, String> getMapToCountry(List<Good> goodList){
        return goodList.stream().collect(Collectors.toMap(Good::getProductSKU, Good::getCountryOfOrigin));
    }

    public static Map<Integer, List<StorePrice>> getMapSkuToCountry(List<StorePrice> storePricesList){
        return storePricesList.stream().collect(Collectors.groupingBy(StorePrice::getProductSKU));
    }

    public static List<CountryStat> solution(List<Good> goodList,
                                             Map<Integer, List<StorePrice>> skuToPricesMap){

        // Map country to prices
        Map<String, Map<String, List<BigDecimal>>> countryToStorePrices = goodList.stream()
                .flatMap(good -> {
                    List<StorePrice> prices = skuToPricesMap.getOrDefault(good.getProductSKU(), Collections.emptyList());
                    return prices.stream().map(storePrice -> new AbstractMap.SimpleEntry<>(good.getCountryOfOrigin(), storePrice));
                })
                .collect(Collectors.groupingBy(
                        Entry::getKey,
                        Collectors.groupingBy(
                                storePriceEntry -> storePriceEntry.getValue().getStoreTitle(),
                                Collectors.mapping(
                                        storePriceEntry -> storePriceEntry.getValue().getPrice(),
                                        Collectors.toList()
                                )
                        )
                ));

        // Calculate statistics for each country
        return countryToStorePrices.entrySet().stream()
                .map(entry -> {
                    String country = entry.getKey(); // Get the country name
                    Map<String, List<BigDecimal>> storePricesMap = entry.getValue(); // Get the map of store prices for the country

                    int storeCount = storePricesMap.size(); // Count of stores
                    BigDecimal minPrice = storePricesMap.values().stream()
                            .flatMap(Collection::stream) // Flatten the list of lists of prices
                            .min(BigDecimal::compareTo) // Find the minimum price
                            .orElse(BigDecimal.ZERO); // Default to BigDecimal.ZERO if no prices are present

                    return new CountryStat(country, storeCount, minPrice); // Create CountryStat instance
                })
                .sorted(Comparator.comparing(CountryStat::getCountryOfOrigin)) // Sort by country name
                .collect(Collectors.toList());

    }
}


