// Interface for currency conversion
interface CurrencyConverter {
    double convertToINR(double amount);
}

// Class for converting Dollar to INR
class DollarConverter implements CurrencyConverter {
    @Override
    public double convertToINR(double amount) {
        return amount * 74.39; // Assuming 1 Dollar = 74.39 INR
    }
}

// Class for converting Euro to INR
class EuroConverter implements CurrencyConverter {
    @Override
    public double convertToINR(double amount) {
        return amount * 87.21; // Assuming 1 Euro = 87.21 INR
    }
}

// Class for converting Yen to INR
class YenConverter implements CurrencyConverter {
    @Override
    public double convertToINR(double amount) {
        return amount * 0.68; // Assuming 1 Yen = 0.68 INR
    }
}

public class Main3 {
    public static void main(String[] args) {
        double amount = 100; // Amount to be converted

        // Convert Dollar to INR
        CurrencyConverter dollarConverter = new DollarConverter();
        double inrFromDollar = dollarConverter.convertToINR(amount);
        System.out.println(amount + " Dollar(s) = " + inrFromDollar + " INR");

        // Convert Euro to INR
        CurrencyConverter euroConverter = new EuroConverter();
        double inrFromEuro = euroConverter.convertToINR(amount);
        System.out.println(amount + " Euro(s) = " + inrFromEuro + " INR");

        // Convert Yen to INR
        CurrencyConverter yenConverter = new YenConverter();
        double inrFromYen = yenConverter.convertToINR(amount);
        System.out.println(amount + " Yen(s) = " + inrFromYen + " INR");
    }
}
