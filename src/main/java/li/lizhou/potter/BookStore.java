package li.lizhou.potter;

public class BookStore {
    public static final double BOOK_PRICE = 8.0d;
    private static final int SERIES = 5;
    private static final double[] DISCOUNTS = {1.0, 0.95, 0.9, 0.8, 0.75};

    public static double getPrice(int[] books) {
        double price = 0.0d;
        int[] seriesCount = new int[SERIES];
        for (int book : books) {
            if(book < SERIES && book >= 0) seriesCount[book]++;
        }
        for(int i = 0; i < SERIES; ++i) {
            price += seriesCount[i] * BOOK_PRICE;
        }

        return price;
    }
}
