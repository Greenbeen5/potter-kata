package li.lizhou;

import org.junit.jupiter.api.Test;

import static li.lizhou.potter.BookStore.getPrice;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookStoreTest {

    @Test
    public void basic_test() {
        assertEquals(0, getPrice(new int[0]));
        assertEquals(8, getPrice(new int[]{0}));
        assertEquals(8, getPrice(new int[]{1}));
        assertEquals(8, getPrice(new int[]{2}));
        assertEquals(8, getPrice(new int[]{3}));
        assertEquals(8, getPrice(new int[]{4}));
        assertEquals(8 * 2, getPrice(new int[]{0, 0}));
        assertEquals(8 * 3, getPrice(new int[]{1, 1, 1}));
    }

    @Test
    public void simple_discount_test() {
        assertEquals(8 * 2 * 0.95, getPrice(new int[]{0, 1}));
        assertEquals(8 * 3 * 0.9, getPrice(new int[]{0, 2, 4}));
        assertEquals(8 * 4 * 0.8, getPrice(new int[]{0, 1, 2, 4}));
        assertEquals(8 * 5 * 0.75, getPrice(new int[]{0, 1, 2, 3, 4}));
    }

    @Test
    public void several_discount_test() {
        assertEquals(8 + 8 * 2 * 0.95,
                getPrice(new int[]{0, 0, 1}));
        assertEquals(2 * (8 * 2 * 0.95),
                getPrice(new int[]{0, 0, 1, 1}));
        assertEquals(8 * 4 * 0.8 +
                              8 * 2 * 0.95,
                getPrice(new int[]{0, 0, 1, 2, 2, 3}));
        assertEquals(8 + 8 * 5 * 0.75,
                getPrice(new int[]{0, 1, 1, 2, 3, 4}));
    }

    @Test
    public void edge_cases_test() {
        assertEquals(2 * (8 * 4 * 0.8),
                getPrice(new int[]{0, 0, 1, 1, 2, 2, 3, 4}));
        assertEquals(3 * (8 * 5 * 0.75) +
                        2 * (8 * 4 * 0.8),
                getPrice(new int[]{0, 0, 0, 0, 0,
                                             1, 1, 1, 1, 1,
                                             2, 2, 2, 2,
                                             3, 3, 3, 3, 3,
                                             4, 4, 4, 4}));
    }
}
