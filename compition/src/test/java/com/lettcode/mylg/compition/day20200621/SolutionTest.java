package com.lettcode.mylg.compition.day20200621;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {

    @Test
    void fileNameEnd() {
        Solution solution = new Solution();
        System.out.println(solution.fileNameEnd("onepiece"));
        System.out.println(solution.fileNameEnd("onepiece(1)"));
        System.out.println(solution.fileNameEnd("onepiece(10)"));
        System.out.println(solution.fileNameEnd("onepiece10)"));
    }

    @Test
    void getFolderNames() {
        Solution solution = new Solution();
        String[] names = { "pes", "fifa", "gta", "pes(2019)" };
        String[] result = solution.getFolderNames(names);
        System.out.println(Arrays.toString(result));
    }

    @Test
    void getFolderNamesV1() {
        Solution solution = new Solution();
        String[] names = { "gta", "gta(1)", "gta", "avalon" };
        String[] result = solution.getFolderNames(names);
        System.out.println(Arrays.toString(result));
    }

    @Test
    void getFolderNamesV2() {
        Solution solution = new Solution();
        String[] names = { "onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece" };
        String[] result = solution.getFolderNames(names);
        System.out.println(Arrays.toString(result));
    }


    @Test
    void getFolderNamesV4() {
        Solution solution = new Solution();
        String[] names = { "x(4)(1)", "x(4)", "x(4)" };
        String[] result = solution.getFolderNames(names);
        System.out.println(Arrays.toString(result));
    }

    @Test
    void getFoldNamesV3() {
        String[] names = {
            "k", "a(4)", "j", "g", "m", "g(4)(4)", "w(1)(1)", "b", "y", "k(1)(2)", "x(1)(4)", "f", "f(3)", "i(3)",
            "r(2)(4)", "f", "j(1)", "e", "v(4)", "l", "v", "p", "j(4)", "g", "w", "s", "m", "t(2)", "j(3)", "w(1)", "v",
            "o", "e", "w", "s", "m", "x(4)(1)", "i(1)(2)", "l", "w(2)", "t", "y(4)", "i", "k(1)", "w", "q", "u",
            "b(1)(4)", "t(3)", "c(3)", "u", "i(4)(2)", "h", "l", "f", "y", "c(1)(2)", "z(3)", "i", "o", "d", "x(4)",
            "o(4)(2)", "w", "k", "r", "m(4)", "e(2)", "t", "b", "j", "r", "b", "v", "c", "g", "n(2)", "l(1)", "v", "z",
            "g(3)", "c(4)", "l", "p(4)", "r(1)(2)", "c", "r", "g(1)(1)", "c(2)(2)", "i", "e", "m", "a", "r", "a",
            "u(1)(3)", "i(1)(3)", "q", "z", "w(2)", "m", "k", "x", "z", "p(4)", "h", "r", "s", "l(2)(4)", "o", "x",
            "o(4)", "f", "m", "h(2)(2)", "s(2)(4)", "q", "c(3)(4)", "s(1)(1)", "n", "y(4)", "v(2)", "f", "c", "k(1)(2)",
            "z(4)", "c(3)", "n", "z", "f", "w", "n", "p", "l(1)", "p(4)(4)", "r(4)(2)", "o", "t", "k", "d(2)(1)",
            "n(4)", "f", "m", "k(4)(4)", "a", "i", "m(4)(4)", "y", "j", "m(1)", "c(2)(1)", "l(2)", "m", "p(3)(3)", "r",
            "k(3)", "u", "m", "u", "k", "z", "r", "k(4)", "r(2)(4)", "f(3)(4)", "c", "r", "n", "n(4)(1)", "k(1)", "y",
            "g(1)(2)", "h", "y", "w", "r", "i(4)", "p(1)(2)", "w(3)(3)", "b", "j", "f", "g", "x", "h(4)(3)", "b(1)",
            "x(4)", "g", "z(1)", "a", "i(2)(1)", "n", "i", "j", "n", "z", "w", "u", "h", "q", "j", "z", "m", "z", "o",
            "l", "c", "k", "j", "q(4)", "h", "v(3)(3)", "a(2)(3)", "f", "g", "r", "g(1)(3)", "y", "w(3)(4)", "i(2)",
            "e(3)", "q(2)(4)", "q(3)(3)", "p(2)", "f", "f(1)", "g", "c", "u(4)", "k", "l(3)", "o", "o", "r", "v(3)",
            "n", "l(2)(2)", "f", "d", "l", "y(4)", "t(3)", "l", "q", "f", "z", "n", "o(4)", "s", "c", "c(4)(2)", "d",
            "v", "l", "e", "g(1)", "d(3)(4)", "s(4)(4)", "s", "u", "p", "i", "o", "t(1)", "a", "d(2)", "x", "w", "r",
            "z(2)", "k(2)", "d", "g(2)(1)", "j", "q(2)", "f", "k", "h", "x", "g", "r(2)(4)", "z(2)(1)", "m", "q", "j",
            "o", "p(1)", "w", "e", "l", "n(4)", "x", "e", "w", "q", "q", "y", "y(2)(2)", "k", "l", "e", "x", "p(2)",
            "x(4)(3)", "l(1)", "g", "y", "f", "p", "h", "q(3)", "d(2)", "n", "f", "f(1)", "e", "m", "h", "y", "d(4)",
            "e", "u", "q(2)(3)", "f", "w", "a", "n", "q(1)(1)", "c(1)(4)", "t", "j", "i", "d(3)(2)", "k(1)(2)", "k",
            "m", "p", "n", "z", "w(3)", "j", "h(2)", "e", "t", "j(2)(4)", "t(3)", "r(1)", "q", "w", "g(4)", "w(2)", "d",
            "h", "g", "y", "b(3)(3)", "n", "y(1)", "r", "a(1)", "j", "r", "v", "b", "p", "k(3)", "g", "n", "y", "v(1)",
            "f", "s(4)", "b", "d", "s(1)", "g(3)(3)", "l(1)", "v(4)", "e", "u", "z(1)(1)", "c", "m(2)(2)", "n",
            "f(3)(3)", "d", "d", "x(3)", "d", "j", "v(3)", "u", "b", "o(3)", "u(3)(3)", "n", "e(4)(4)", "u", "h", "l",
            "z", "z(3)(1)", "r(4)", "y(1)(3)", "q(4)", "x", "t", "l(4)(1)", "e(1)", "m", "o", "y", "u", "l", "e", "j",
            "g", "t(1)(1)", "u", "t", "n", "t(4)(4)", "o", "w", "b(2)", "p(2)", "t(3)", "c(1)", "c", "m", "v", "w(1)",
            "q(1)", "c", "l(2)", "r", "k(4)", "w", "u(4)(2)", "n(2)", "o(2)", "g", "l", "e", "i", "q", "q(1)(2)",
            "k(1)", "j(2)", "d", "l", "a", "h", "i", "i", "c(1)", "k(2)(2)", "m", "m", "c", "i", "r", "u(4)", "l(3)",
            "e", "e(2)(3)", "d", "g", "b(2)", "v", "i", "a", "s", "k", "h", "a", "b(3)", "n(3)(1)", "q", "b", "j(1)(4)",
            "n", "q", "v", "c", "q", "o", "d(2)", "y(3)(1)", "d(2)(4)", "u", "m(3)", "u(2)(4)", "t(2)(3)", "e", "v(1)",
            "g", "f", "a", "m", "n", "b", "y", "g", "y", "x", "j", "r", "d(1)(1)", "z(3)(2)", "s(2)", "i", "z(1)(3)",
            "w", "n(4)", "r", "f(4)(3)", "e", "c(1)", "i(2)", "d(2)(1)", "w(2)", "p", "e", "b", "j", "k(2)(4)", "r",
            "d", "e", "x", "c", "c", "r", "b(1)", "m(1)(3)", "x(1)", "i", "m", "y", "w", "e(2)(4)", "n", "c", "o(1)",
            "s(1)(1)", "y", "i(1)", "m(2)(3)", "f(2)(4)", "p", "w(2)", "t", "d", "o", "o", "g(4)", "c", "h", "t", "o",
            "t", "h(3)", "c(3)(1)", "w(4)(4)", "u", "q", "f", "o", "l(3)(2)", "q(3)", "r", "k", "y(1)(4)", "z", "y",
            "t", "j(3)", "e", "a", "p", "w", "r", "n", "n", "r", "m", "j", "s", "i", "x", "s(4)", "l", "m", "s", "b(4)",
            "c", "k", "k(3)", "m", "b(1)", "x(3)", "b", "q", "s", "v", "g", "n", "a", "f(3)(2)", "i", "n(2)", "k", "y",
            "v(1)(1)", "w", "k", "h", "o(2)(3)", "g(4)(4)", "k(4)", "d", "l(2)", "g(3)(4)", "t(2)", "c", "c(4)", "y",
            "b", "h", "k", "x", "p(1)(3)", "a(2)", "n(4)", "n(4)(2)", "h", "x", "b(3)", "p", "p(2)(2)", "c(4)", "e",
            "g", "o(3)(2)", "i", "e", "a", "u", "t", "y", "v", "f", "o", "s(4)(2)", "o(4)(4)", "d", "m(1)", "e", "a",
            "p(2)(2)", "r(3)", "d(1)(2)", "i(3)", "r", "b", "p", "e", "e", "m", "c", "f", "a", "j", "o", "u", "j(3)(2)",
            "y(4)(2)", "u", "w(4)", "o", "x", "l", "z", "u(3)(4)", "d", "b(3)(2)", "b(1)(2)", "u(4)", "t", "x", "u",
            "u", "z(1)(1)", "y(4)(1)", "p", "g", "x", "s(1)", "k", "h", "d", "a(2)", "b", "t", "h", "l", "n", "e(4)(2)",
            "a(2)", "x(3)", "z", "y", "m", "h(3)(2)", "m", "d(2)", "j(3)(3)", "e", "u", "m", "x", "n", "l", "x", "o",
            "p", "w", "b", "n(4)(2)", "g(3)", "f(4)", "t", "c(1)(4)", "t(2)(2)", "l(4)", "v", "w", "d", "q", "d", "a",
            "e", "m(4)(3)", "o", "z", "x(3)", "a", "i(4)"
        };
        Solution solution = new Solution();
        String[] result = solution.getFolderNames(names);

        String[] expect = {
            "k", "a(4)", "j", "g", "m", "g(4)(4)", "w(1)(1)", "b", "y", "k(1)(2)", "x(1)(4)", "f", "f(3)", "i(3)",
            "r(2)(4)", "f(1)", "j(1)", "e", "v(4)", "l", "v", "p", "j(4)", "g(1)", "w", "s", "m(1)", "t(2)", "j(3)",
            "w(1)", "v(1)", "o", "e(1)", "w(2)", "s(1)", "m(2)", "x(4)(1)", "i(1)(2)", "l(1)", "w(2)(1)", "t", "y(4)",
            "i", "k(1)", "w(3)", "q", "u", "b(1)(4)", "t(3)", "c(3)", "u(1)", "i(4)(2)", "h", "l(2)", "f(2)", "y(1)",
            "c(1)(2)", "z(3)", "i(1)", "o(1)", "d", "x(4)", "o(4)(2)", "w(4)", "k(2)", "r", "m(4)", "e(2)", "t(1)",
            "b(1)", "j(2)", "r(1)", "b(2)", "v(2)", "c", "g(2)", "n(2)", "l(1)(1)", "v(3)", "z", "g(3)", "c(4)", "l(3)",
            "p(4)", "r(1)(2)", "c(1)", "r(2)", "g(1)(1)", "c(2)(2)", "i(2)", "e(3)", "m(3)", "a", "r(3)", "a(1)",
            "u(1)(3)", "i(1)(3)", "q(1)", "z(1)", "w(2)(2)", "m(5)", "k(3)", "x", "z(2)", "p(4)(1)", "h(1)", "r(4)",
            "s(2)", "l(2)(4)", "o(2)", "x(1)", "o(4)", "f(4)", "m(6)", "h(2)(2)", "s(2)(4)", "q(2)", "c(3)(4)",
            "s(1)(1)", "n", "y(4)(1)", "v(2)(1)", "f(5)", "c(2)", "k(1)(2)(1)", "z(4)", "c(3)(1)", "n(1)", "z(5)",
            "f(6)", "w(5)", "n(3)", "p(1)", "l(1)(2)", "p(4)(4)", "r(4)(2)", "o(3)", "t(4)", "k(4)", "d(2)(1)", "n(4)",
            "f(7)", "m(7)", "k(4)(4)", "a(2)", "i(4)", "m(4)(4)", "y(2)", "j(5)", "m(1)(1)", "c(2)(1)", "l(2)(1)",
            "m(8)", "p(3)(3)", "r(5)", "k(3)(1)", "u(2)", "m(9)", "u(3)", "k(5)", "z(6)", "r(6)", "k(4)(1)",
            "r(2)(4)(1)", "f(3)(4)", "c(5)", "r(7)", "n(5)", "n(4)(1)", "k(1)(1)", "y(3)", "g(1)(2)", "h(2)", "y(5)",
            "w(6)", "r(8)", "i(4)(1)", "p(1)(2)", "w(3)(3)", "b(3)", "j(6)", "f(8)", "g(4)", "x(2)", "h(4)(3)",
            "b(1)(1)", "x(4)(2)", "g(5)", "z(1)(1)", "a(3)", "i(2)(1)", "n(6)", "i(5)", "j(7)", "n(7)", "z(7)", "w(7)",
            "u(4)", "h(3)", "q(3)", "j(8)", "z(8)", "m(10)", "z(9)", "o(5)", "l(4)", "c(6)", "k(6)", "j(9)", "q(4)",
            "h(4)", "v(3)(3)", "a(2)(3)", "f(9)", "g(6)", "r(9)", "g(1)(3)", "y(6)", "w(3)(4)", "i(2)(2)", "e(3)(1)",
            "q(2)(4)", "q(3)(3)", "p(2)", "f(10)", "f(1)(1)", "g(7)", "c(7)", "u(4)(1)", "k(7)", "l(3)(1)", "o(6)",
            "o(7)", "r(10)", "v(3)(1)", "n(8)", "l(2)(2)", "f(11)", "d(1)", "l(5)", "y(4)(2)", "t(3)(1)", "l(6)",
            "q(5)", "f(12)", "z(10)", "n(9)", "o(4)(1)", "s(3)", "c(8)", "c(4)(2)", "d(2)", "v(5)", "l(7)", "e(4)",
            "g(1)(4)", "d(3)(4)", "s(4)(4)", "s(4)", "u(5)", "p(3)", "i(6)", "o(8)", "t(1)(1)", "a(5)", "d(2)(2)",
            "x(3)", "w(8)", "r(11)", "z(2)(1)", "k(2)(1)", "d(3)", "g(2)(1)", "j(10)", "q(2)(1)", "f(13)", "k(8)",
            "h(5)", "x(5)", "g(8)", "r(2)(4)(2)", "z(2)(1)(1)", "m(11)", "q(6)", "j(11)", "o(9)", "p(1)(1)", "w(9)",
            "e(5)", "l(8)", "n(4)(2)", "x(6)", "e(6)", "w(10)", "q(7)", "q(8)", "y(7)", "y(2)(2)", "k(9)", "l(9)",
            "e(7)", "x(7)", "p(2)(1)", "x(4)(3)", "l(1)(3)", "g(9)", "y(8)", "f(14)", "p(5)", "h(6)", "q(3)(1)",
            "d(2)(3)", "n(10)", "f(15)", "f(1)(2)", "e(8)", "m(12)", "h(7)", "y(9)", "d(4)", "e(9)", "u(6)", "q(2)(3)",
            "f(16)", "w(11)", "a(6)", "n(11)", "q(1)(1)", "c(1)(4)", "t(5)", "j(12)", "i(7)", "d(3)(2)", "k(1)(2)(2)",
            "k(10)", "m(13)", "p(6)", "n(12)", "z(11)", "w(3)(1)", "j(13)", "h(2)(1)", "e(10)", "t(6)", "j(2)(4)",
            "t(3)(2)", "r(1)(1)", "q(9)", "w(12)", "g(4)(1)", "w(2)(3)", "d(5)", "h(8)", "g(10)", "y(10)", "b(3)(3)",
            "n(13)", "y(1)(1)", "r(12)", "a(1)(1)", "j(14)", "r(13)", "v(6)", "b(4)", "p(7)", "k(3)(2)", "g(11)",
            "n(14)", "y(11)", "v(1)(1)", "f(17)", "s(4)(1)", "b(5)", "d(6)", "s(1)(2)", "g(3)(3)", "l(1)(4)", "v(4)(1)",
            "e(11)", "u(7)", "z(1)(1)(1)", "c(9)", "m(2)(2)", "n(15)", "f(3)(3)", "d(7)", "d(8)", "x(3)(1)", "d(9)",
            "j(15)", "v(3)(2)", "u(8)", "b(6)", "o(3)(1)", "u(3)(3)", "n(16)", "e(4)(4)", "u(9)", "h(9)", "l(10)",
            "z(12)", "z(3)(1)", "r(4)(1)", "y(1)(3)", "q(4)(1)", "x(8)", "t(7)", "l(4)(1)", "e(1)(1)", "m(14)", "o(10)",
            "y(12)", "u(10)", "l(11)", "e(12)", "j(16)", "g(12)", "t(1)(1)(1)", "u(11)", "t(8)", "n(17)", "t(4)(4)",
            "o(11)", "w(13)", "b(2)(1)", "p(2)(2)", "t(3)(3)", "c(1)(1)", "c(10)", "m(15)", "v(7)", "w(1)(2)",
            "q(1)(2)", "c(11)", "l(2)(3)", "r(14)", "k(4)(2)", "w(14)", "u(4)(2)", "n(2)(1)", "o(2)(1)", "g(13)",
            "l(12)", "e(13)", "i(8)", "q(10)", "q(1)(2)(1)", "k(1)(3)", "j(2)(1)", "d(10)", "l(13)", "a(7)", "h(10)",
            "i(9)", "i(10)", "c(1)(3)", "k(2)(2)", "m(16)", "m(17)", "c(12)", "i(11)", "r(15)", "u(4)(3)", "l(3)(2)",
            "e(14)", "e(2)(3)", "d(11)", "g(14)", "b(2)(2)", "v(8)", "i(12)", "a(8)", "s(5)", "k(11)", "h(11)", "a(9)",
            "b(3)(1)", "n(3)(1)", "q(11)", "b(7)", "j(1)(4)", "n(18)", "q(12)", "v(9)", "c(13)", "q(13)", "o(12)",
            "d(2)(4)", "y(3)(1)", "d(2)(4)(1)", "u(12)", "m(3)(1)", "u(2)(4)", "t(2)(3)", "e(15)", "v(1)(2)", "g(15)",
            "f(18)", "a(10)", "m(18)", "n(19)", "b(8)", "y(13)", "g(16)", "y(14)", "x(9)", "j(17)", "r(16)", "d(1)(1)",
            "z(3)(2)", "s(2)(1)", "i(13)", "z(1)(3)", "w(15)", "n(4)(3)", "r(17)", "f(4)(3)", "e(16)", "c(1)(5)",
            "i(2)(3)", "d(2)(1)(1)", "w(2)(4)", "p(8)", "e(17)", "b(9)", "j(18)", "k(2)(4)", "r(18)", "d(12)", "e(18)",
            "x(10)", "c(14)", "c(15)", "r(19)", "b(1)(2)", "m(1)(3)", "x(1)(1)", "i(14)", "m(19)", "y(15)", "w(16)",
            "e(2)(4)", "n(20)", "c(16)", "o(1)(1)", "s(1)(1)(1)", "y(16)", "i(1)(1)", "m(2)(3)", "f(2)(4)", "p(9)",
            "w(2)(5)", "t(9)", "d(13)", "o(13)", "o(14)", "g(4)(2)", "c(17)", "h(12)", "t(10)", "o(15)", "t(11)",
            "h(3)(1)", "c(3)(1)(1)", "w(4)(4)", "u(13)", "q(14)", "f(19)", "o(16)", "l(3)(2)(1)", "q(3)(2)", "r(20)",
            "k(12)", "y(1)(4)", "z(13)", "y(17)", "t(12)", "j(3)(1)", "e(19)", "a(11)", "p(10)", "w(17)", "r(21)",
            "n(21)", "n(22)", "r(22)", "m(20)", "j(19)", "s(6)", "i(15)", "x(11)", "s(4)(2)", "l(14)", "m(21)", "s(7)",
            "b(4)(1)", "c(18)", "k(13)", "k(3)(3)", "m(22)", "b(1)(3)", "x(3)(2)", "b(10)", "q(15)", "s(8)", "v(10)",
            "g(17)", "n(23)", "a(12)", "f(3)(2)", "i(16)", "n(2)(2)", "k(14)", "y(18)", "v(1)(1)(1)", "w(18)", "k(15)",
            "h(13)", "o(2)(3)", "g(4)(4)(1)", "k(4)(3)", "d(14)", "l(2)(5)", "g(3)(4)", "t(2)(1)", "c(19)", "c(4)(1)",
            "y(19)", "b(11)", "h(14)", "k(16)", "x(12)", "p(1)(3)", "a(2)(1)", "n(4)(4)", "n(4)(2)(1)", "h(15)",
            "x(13)", "b(3)(2)", "p(11)", "p(2)(2)(1)", "c(4)(3)", "e(20)", "g(18)", "o(3)(2)", "i(17)", "e(21)",
            "a(13)", "u(14)", "t(13)", "y(20)", "v(11)", "f(20)", "o(17)", "s(4)(2)(1)", "o(4)(4)", "d(15)", "m(1)(2)",
            "e(22)", "a(14)", "p(2)(2)(2)", "r(3)(1)", "d(1)(2)", "i(3)(1)", "r(23)", "b(12)", "p(12)", "e(23)",
            "e(24)", "m(23)", "c(20)", "f(21)", "a(15)", "j(20)", "o(18)", "u(15)", "j(3)(2)", "y(4)(2)(1)", "u(16)",
            "w(4)(1)", "o(19)", "x(14)", "l(15)", "z(14)", "u(3)(4)", "d(16)", "b(3)(2)(1)", "b(1)(2)(1)", "u(4)(4)",
            "t(14)", "x(15)", "u(17)", "u(18)", "z(1)(1)(2)", "y(4)(1)(1)", "p(13)", "g(19)", "x(16)", "s(1)(3)",
            "k(17)", "h(16)", "d(17)", "a(2)(2)", "b(13)", "t(15)", "h(17)", "l(16)", "n(24)", "e(4)(2)", "a(2)(4)",
            "x(3)(3)", "z(15)", "y(21)", "m(24)", "h(3)(2)", "m(25)", "d(2)(5)", "j(3)(3)", "e(25)", "u(19)", "m(26)",
            "x(17)", "n(25)", "l(17)", "x(18)", "o(20)", "p(14)", "w(19)", "b(14)", "n(4)(2)(2)", "g(3)(1)", "f(4)(1)",
            "t(16)", "c(1)(4)(1)", "t(2)(2)", "l(4)(2)", "v(12)", "w(20)", "d(18)", "q(16)", "d(19)", "a(16)", "e(26)",
            "m(4)(3)", "o(21)", "z(16)", "x(3)(4)", "a(17)", "i(4)(3)"
        };

        for (int i = 0; i <= expect.length; i++) {
            Assertions.assertEquals(expect[i], result[i], "两者不相等:" + names[i] + ";i=" + i);
        }
    }
}
