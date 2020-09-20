package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void isPalindrome() {
        Assertions.assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
        Assertions.assertFalse(solution.isPalindrome("race a car"));
    }
}
