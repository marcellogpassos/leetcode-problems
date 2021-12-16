import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMedianSortedArraysTest {

    private final FindMedianSortedArrays instance = new FindMedianSortedArrays();

    @Test
    void findMedianSortedArrays_example1() {
        final double result = this.instance.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        assertEquals(2.0, result);
    }

    @Test
    void findMedianSortedArrays_example2() {
        final double result = this.instance.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        assertEquals(2.5, result);
    }
}