package every269;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution2699Test {

    /**
     * 查找的是最短路径
     */
    @Test
    void modifiedGraphEdges() {
        Solution2699 solution = new Solution2699();
        int[][] edges = {{4, 1, -1}, {2, 0, -1}, {0, 3, -1}, {4, 3, -1}};
        int n = 5, source = 0, destination = 1, target = 5;
        int[][] value = solution.modifiedGraphEdges(n, edges, source, destination, target);
        System.out.println(Arrays.deepToString(value));
    }

    @Test
    void modifiedGraphEdgesCase1() {
        int[][] edges = {{1, 3, 10}, {4, 2, -1}, {0, 3, 7}, {4, 0, 7}, {3, 2, -1}, {1, 4, 5}, {2, 0, 8}, {1, 0, 3}, {1, 2, 5}};
        int n = 5, source = 3, destination = 4, target = 11;

        Solution2699 solution = new Solution2699();
        int[][] value = solution.modifiedGraphEdges(n, edges, source, destination, target);
        System.out.println(Arrays.deepToString(value));
    }

    @Test
    void modifiedGraphEdgesCase2() {
        //[[0,1,-1},{1,2,-1},{3,1,-1},{3,0,2},{0,2,5]]

        int[][] edges = {{0, 1, -1}, {1, 2, -1}, {3, 1, -1}, {3, 0, 2}, {0, 2, 5}};
        int n = 4, source = 2, destination = 3, target = 8;

        Solution2699 solution = new Solution2699();
        int[][] value = solution.modifiedGraphEdges(n, edges, source, destination, target);
        System.out.println(Arrays.deepToString(value));
    }

    @Test
    void modifiedGraphEdgesCase3() {
        int[][] edges = {{3, 0, 1}, {2, 1, -1}, {2, 3, 6}, {4, 2, 6}, {1, 3, 2}, {2, 0, 7}, {0, 4, 10}, {0, 1, 6}};
        int n =5,source = 1, destination = 4, target = 14;
        Solution2699 solution = new Solution2699();
        int[][] value = solution.modifiedGraphEdges(n, edges, source, destination, target);
        System.out.println(Arrays.deepToString(value));
    }
}