package before.you.start;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    private Solution solution = new Solution();

    @Test
    void majorityElement() {
        Assertions.assertEquals(3, solution.majorityElement(new int[]{ 3, 2, 3 }));
        Assertions.assertEquals(5, solution.majorityElement(new int[]{ 6, 5, 5 }));
    }

    @Test
    void merge() {
        int[] num1 = new int[]{ 1, 2, 3, 0, 0, 0 };
        int[] num2 = new int[]{ 2, 5, 6 };
        int[] result = new int[]{ 1, 2, 2, 3, 5, 6 };
        solution.merge(num1, 3, num2, 3);
        Assertions.assertArrayEquals(result, num1);
    }

    @Test
    void superEggDrop() {
        Assertions.assertEquals(2, solution.superEggDrop(1, 2));
        Assertions.assertEquals(3, solution.superEggDrop(2, 6));
        Assertions.assertEquals(4, solution.superEggDrop(2, 9));
        Assertions.assertEquals(4, solution.superEggDrop(3, 14));
        Assertions.assertEquals(6, solution.superEggDrop(3, 41));
        Assertions.assertEquals(4, solution.superEggDrop(2, 7));
        Assertions.assertEquals(5, solution.superEggDrop(3, 15));
    }

    @Test
    void superEggDropDebug() {
        Assertions.assertEquals(16, solution.superEggDrop(4, 200));
    }
}
