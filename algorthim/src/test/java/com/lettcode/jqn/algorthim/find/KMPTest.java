package com.lettcode.jqn.algorthim.find;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KMPTest {

    private KMP kmp = new KMP();

    @Test
    void indexOf() {
        String main = "ATGTGAGCTGGTGTGTGCFAA";
        String mod = "GTGTGCF";
        int index = kmp.indexOf(main, mod);
        System.out.println("首次出现位置:" + index);
        System.out.println(main.indexOf(mod));
    }
}