package com.lettcode.mylg.compition.weekly379;

/**
 * @author mylg
 * @date 7/1/24
 */
public class Solution100170 {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        long line = 0;
        int max = 0;
        for (int[] list : dimensions) {
            int width = list[0];
            int height = list[1];
            long current = width * width + height * height;
            if (current < line) {
                continue;
            } else if (current > line) {
                line = current;
                max  = width * height;
            } else {
                max = Math.max(max, width * height);
            }
        }
        return max;
    }
}
