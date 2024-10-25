import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SalesTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<SalesPerson> salesPeople = new ArrayList<>();
        double companyTotal = 0;

        // Collect data for multiple sales people
        for (int i = 0; i < 3; i++) { // Adjust for more salespeople
            System.out.println("Enter the name of Sales Person " + (i + 1) + ":");
            String name = scanner.nextLine();
            System.out.println("Enter the title of Sales Person " + (i + 1) + ":");
            String title = scanner.nextLine();

            SalesPerson salesPerson = new SalesPerson(name, title);
            System.out.println("How many sales values will you enter for " + name + "?");
            int numberOfSales = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < numberOfSales; j++) {
                System.out.println("Enter sale value " + (j + 1) + ":");
                double saleValue = Double.parseDouble(scanner.nextLine());
                salesPerson.addSale(saleValue);
            }

            salesPeople.add(salesPerson);
        }

        // Print sales report
        for (SalesPerson salesperson : salesPeople) {
            SalesPerson.SalesReport report = salesperson.getSalesReport();
            System.out.println("Sales Report for " + salesperson.getName() + " (" + salesperson.getTitle() + "):");
            System.out.println("Total Sales: " + report.getTotal());
            System.out.println("Min Sale: " + report.getMin());
            System.out.println("Max Sale: " + report.getMax());
            System.out.println("Average Sale: " + report.getAverage());
            System.out.println();

            companyTotal += report.getTotal();
        }

        System.out.println("Total Sales for the entire company: " + companyTotal);
        scanner.close();
    }
}
