package com.jqn.interview;

import java.util.HashSet;
import java.util.Set;

public class Happy {
    private static int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int i = n % 10;
            n = n / 10;
            sum += i * i;
        }
        return sum;
    }

    private static boolean isHappyNumber(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSum(n);
        }
        return n == 1;
    }
}
