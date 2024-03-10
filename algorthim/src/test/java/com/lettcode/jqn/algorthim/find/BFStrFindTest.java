package com.lettcode.jqn.algorthim.find;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BFStrFindTest {

    private BFStrFind bfStrFind = new BFStrFind();

    private RKStrFind rkStrFind = new RKStrFind();

    @Test
    public void case1() {
        String main = "abcdefgh";
        String mode = "bcde";
        Assertions.assertTrue(bfStrFind.contains(main, mode));
        Assertions.assertTrue(rkStrFind.contains(main, mode));
    }

    @Test
    public void case2() {
        String main = "abbcefgh";
        String mode = "bce";
        Assertions.assertTrue(bfStrFind.contains(main, mode));
        Assertions.assertTrue(rkStrFind.contains(main, mode));
    }

    @Test
    public void case3() {
        String main = "aaaaaaaaaaaaaaaaab";
        String mode = "aaab";
        Assertions.assertTrue(bfStrFind.contains(main, mode));
        Assertions.assertTrue(rkStrFind.contains(main, mode));
    }
}