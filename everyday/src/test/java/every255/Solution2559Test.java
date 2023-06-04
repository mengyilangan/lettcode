package every255;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution2559Test {

    @Test
    public void testVowelStrings() {
        Solution2559 solution = new Solution2559();
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        int[] result = solution.vowelStrings(words, queries);
        System.out.println(Arrays.toString(result));
    }
}