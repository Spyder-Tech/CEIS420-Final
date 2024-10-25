import java.util.ArrayList;
import java.util.Iterator;

public class SalesPerson {
    private String name;
    private String title;
    private ArrayList<Double> sales;

    // Constructor
    public SalesPerson(String name, String title) {
        this.name = name;
        this.title = title;
        this.sales = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Double> getSales() {
        return sales;
    }

    public void addSale(double sale) {
        sales.add(sale);
    }

    // Iterator for sales
    public Iterator<Double> iterSales() {
        return sales.iterator();
    }

    // Method to generate sales report data
    public SalesReport getSalesReport() {
        double total = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for (double sale : sales) {
            total += sale;
            if (sale < min) min = sale;
            if (sale > max) max = sale;
        }
        double average = sales.size() > 0 ? total / sales.size() : 0;

        return new SalesReport(total, min, max, average);
    }

    // Inner class to hold report data
    public class SalesReport {
        private double total;
        private double min;
        private double max;
        private double average;

        public SalesReport(double total, double min, double max, double average) {
            this.total = total;
            this.min = min;
            this.max = max;
            this.average = average;
        }

        public double getTotal() {
            return total;
        }

        public double getMin() {
            return min;
        }

        public double getMax() {
            return max;
        }

        public double getAverage() {
            return average;
        }
    }
}
