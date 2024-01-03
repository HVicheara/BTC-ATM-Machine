public class Currency {
    private String code;
    private String symbol;
    private double exchangeRate;

    public Currency(String code, String symbol, double exchangeRate) {
        this.code = code;
        this.symbol = symbol;
        this.exchangeRate = exchangeRate;
    }

    public static Currency getCurrencyByCode(String currencyCode) {
        // Replace this with a real implementation to fetch Currency object by code
        // For simplicity, let's assume you have a list of supported currencies
        Currency btc = new Currency("BTC", "₿", 43593.50);
        Currency usd = new Currency("USD", "$", 1);
        Currency khr = new Currency("KHR", "R", 4100);
        
        switch (currencyCode) {
            case "USD":
                return usd;
            case "KHR":
                return khr;
            case "BTC":
                return btc;
            default:
                return null;
        }
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public double convert(double amount, Currency targetCurrency) {
        double convertedAmount = amount * (targetCurrency.getExchangeRate() / this.exchangeRate);
        return roundToTwoDecimals(convertedAmount);
    }

    private double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}