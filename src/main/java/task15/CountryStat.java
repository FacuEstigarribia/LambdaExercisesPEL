package task15;

import java.math.BigDecimal;

public class CountryStat {
    String countryOfOrigin;
    int storeCount;
    BigDecimal minPrice;

    CountryStat(String countryOfOrigin, int storeCount, BigDecimal minPrice) {
        this.countryOfOrigin = countryOfOrigin;
        this.storeCount = storeCount;
        this.minPrice = minPrice;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    @Override
    public String toString() {
        return "(" + countryOfOrigin + ", " + storeCount + ", " + minPrice + ")";
    }
}
