import java.util.Scanner;

class ElectricityBill {
    int consumerNo;
    String consumerName;
    int prevMonthReading;
    int currMonthReading;
    String ebConnectionType;

    ElectricityBill(int consumerNo, String consumerName, int prevMonthReading, int currMonthReading, String ebConnectionType) {
        this.consumerNo = consumerNo;
        this.consumerName = consumerName;
        this.prevMonthReading = prevMonthReading;
        this.currMonthReading = currMonthReading;
        this.ebConnectionType = ebConnectionType;
    }

    double calculateBill() {
        int unitsConsumed = currMonthReading - prevMonthReading;
        double billAmount = 0;

        if (ebConnectionType.equalsIgnoreCase("domestic")) {
            if (unitsConsumed <= 100) {
                billAmount = unitsConsumed * 1;
            } else if (unitsConsumed <= 200) {
                billAmount = 100 * 1 + (unitsConsumed - 100) * 2.50;
            } else if (unitsConsumed <= 500) {
                billAmount = 100 * 1 + 100 * 2.50 + (unitsConsumed - 200) * 4;
            } else {
                billAmount = 100 * 1 + 100 * 2.50 + 300 * 4 + (unitsConsumed - 500) * 6;
            }
        } else if (ebConnectionType.equalsIgnoreCase("commercial")) {
            if (unitsConsumed <= 100) {
                billAmount = unitsConsumed * 2;
            } else if (unitsConsumed <= 200) {
                billAmount = 100 * 2 + (unitsConsumed - 100) * 4.50;
            } else if (unitsConsumed <= 500) {
                billAmount = 100 * 2 + 100 * 4.50 + (unitsConsumed - 200) * 6;
            } else {
                billAmount = 100 * 2 + 100 * 4.50 + 300 * 6 + (unitsConsumed - 500) * 7;
            }
        }

        return billAmount;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter consumer details:");
        System.out.print("Consumer Number: ");
        int consumerNo = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Consumer Name: ");
        String consumerName = scanner.nextLine();
        System.out.print("Previous Month Reading: ");
        int prevMonthReading = scanner.nextInt();
        System.out.print("Current Month Reading: ");
        int currMonthReading = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Type of EB Connection (domestic or commercial): ");
        String ebConnectionType = scanner.nextLine();

        ElectricityBill bill = new ElectricityBill(consumerNo, consumerName, prevMonthReading, currMonthReading, ebConnectionType);
        double billAmount = bill.calculateBill();

        System.out.println("\nElectricity Bill Details:");
        System.out.println("Consumer Number: " + bill.consumerNo);
        System.out.println("Consumer Name: " + bill.consumerName);
        System.out.println("Previous Month Reading: " + bill.prevMonthReading);
        System.out.println("Current Month Reading: " + bill.currMonthReading);
        System.out.println("Type of EB Connection: " + bill.ebConnectionType);
        System.out.println("Bill Amount: Rs. " + billAmount);

        scanner.close();
    }
}
