package sec02;

public class Sales {
    String name;
    static int totalSales;

    public Sales(String name) {
        this.name = name;
        totalSales++;
    }
    public static int getSales() {
        return totalSales;
    }
}
