//package every286;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class Solution2866Test {
//    private Solution2866 solution = new Solution2866();
//
//    @Test
//    void case1() {
//        long value = solution.maximumSumOfHeights(Arrays.asList(5, 3, 4, 1, 1));
//        Assertions.assertEquals(13, value);
//    }
//
//    @Test
//    void case2() {
//        long value = solution.maximumSumOfHeights(Arrays.asList(6, 5, 3, 9, 2, 7));
//        Assertions.assertEquals(22, value);
//    }
//
//    @Test
//    void case3() {
//        long value = solution.maximumSumOfHeights(Arrays.asList(3, 2, 5, 5, 2, 3));
//        Assertions.assertEquals(18, value);
//    }
//
//    @Test
//    void case4() {
//        long value = solution.maximumSumOfHeights(Arrays.asList(3, 5, 3, 5, 1, 5, 4, 4, 4));
//         Assertions.assertEquals(22, value);
//    }
//}