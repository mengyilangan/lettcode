package every004;

import every004.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    private Solution solution = new Solution();

    @org.junit.jupiter.api.Test
    void findMedianSortedArrays() {
        Assertions.assertEquals(2.0, solution.findMedianSortedArrays(new int[]{ 1, 3 }, new int[]{ 2 }));
        Assertions.assertEquals(2.5, solution.findMedianSortedArrays(new int[]{ 1, 2 }, new int[]{ 3, 4 }));
        Assertions.assertEquals(2, solution.findMedianSortedArrays(new int[]{ 1, 2 }, new int[]{ 1, 2, 3 }));

    }

    @Test
    void findMedianSortedArrays1() {
        Assertions.assertEquals(3, solution.findMedianSortedArrays(new int[]{ 3, 4, 5 }, new int[]{ 1, 2 }));

    }
}
