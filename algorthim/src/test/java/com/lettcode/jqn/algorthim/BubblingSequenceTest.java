package com.lettcode.jqn.algorthim;

import com.lettcode.jqn.algorthim.sort.BubblingSequence;
import org.junit.jupiter.api.Test;

/**
 * @author jiangqiaonan
 * @date 2020-09-20
 */
class BubblingSequenceTest {

    @Test
    void bubbleSort() {
        int[] a = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        BubblingSequence.bubbleSort(a);
    }
}
