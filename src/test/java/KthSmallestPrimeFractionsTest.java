import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthSmallestPrimeFractionsTest {

    private final KthSmallestPrimeFractions instance = new KthSmallestPrimeFractions();

    @Test
    void kthSmallestPrimeFraction_example1() {
        final int[] result = this.instance.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
        assertEquals(2, result[0]);
        assertEquals(5, result[1]);
    }

    @Test
    void kthSmallestPrimeFraction_example2() {
        final int[] result = this.instance.kthSmallestPrimeFraction(new int[]{1, 7}, 1);
        assertEquals(1, result[0]);
        assertEquals(7, result[1]);
    }
}