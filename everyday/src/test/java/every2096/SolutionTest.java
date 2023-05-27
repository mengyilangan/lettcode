package every2096;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SolutionTest {
    private Solution solution = new Solution();

    /**
     * 表达式 "a" 表示字符串 "a"。
     */
    @Test
    public void braceExpansionIIOne() {
        List<String> result = solution.braceExpansionII("a");
        List<String> expect = Collections.singletonList("a");
        assertEqualList(expect, result, "a");
    }

    private void assertEqualList(List<String> expect, List<String> actual, String message) {
        message = "表达式计算错误:" + message + ";结果=" + actual;
        Assertions.assertEquals(expect.size(), actual.size(), message);
        Assertions.assertTrue(expect.containsAll(actual), message);
        Assertions.assertTrue(actual.containsAll(expect), message);
    }

    /**
     * 表达式 "{a,b,c}" 表示字符串 "a","b","c"。
     */
    @Test
    public void testOnly() {
        String expression = "{a,b,c}";
        List<String> result = solution.braceExpansionII(expression);
        List<String> expect = Arrays.asList("a", "b", "c");
        assertEqualList(expect, result, expression);
    }


    /**
     * 表达式 "{a,b,c}" 表示字符串 "a","b","c"。
     */
    @Test
    public void testUnion() {
        String expression = "{{a,b},{b,c}}";
        List<String> result = solution.braceExpansionII(expression);
        List<String> expect = Arrays.asList("a", "b", "c");
        assertEqualList(expect, result, expression);
    }

    /**
     * {a,b}{c,d}=["ac","ad","bc","bd"]
     */
    @Test
    public void testMulti() {
        String expression = "{a,b}{c,d}";
        List<String> result = solution.braceExpansionII(expression);
        List<String> expect = Arrays.asList("ac", "ad", "bc", "bd");
        assertEqualList(expect, result, expression);
    }

    /**
     * a{b,c,d}
     */
    @Test
    public void testV1() {
        String expression = "a{b,c,d}";
        List<String> result = solution.braceExpansionII(expression);
        List<String> expect = Arrays.asList("ab", "ac", "ad");
        assertEqualList(expect, result, expression);
    }


    @Test
    public void testV2() {
        String expression = "a{b,c}{d,e}f{g,h}";
        List<String> result = solution.braceExpansionII(expression);
        List<String> expect = Arrays.asList("abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh");
        assertEqualList(expect, result, expression);
    }

}