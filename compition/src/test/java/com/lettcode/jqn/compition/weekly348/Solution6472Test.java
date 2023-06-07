package com.lettcode.jqn.compition.weekly348;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class Solution6472Test {

    @Test
    void matrixSumQueries() {
        Solution6472 solution = new Solution6472();
        int n = 3;
        int[][] queries = {{0, 0, 1}, {1, 2, 2}, {0, 2, 3}, {1, 0, 4}};
        long plus = solution.matrixSumQueriesV1(n, queries);
        System.out.println(plus);
    }

    @Test
    void matrixSumQueriesCase1() {
        Solution6472 solution = new Solution6472();

        int n = 8;
        int[][] queries = {{0, 6, 30094}, {0, 7, 99382}, {1, 2, 18599}, {1, 3, 49292}, {1, 0, 81549}, {1, 1, 38280}, {
                0, 0, 19405}, {0, 4, 30065}, {1, 4, 60826}, {1, 5, 9241}, {0, 5, 33729}, {0, 1, 41456}, {0, 2, 62692}, {0, 3, 30807}, {
                1, 7, 70613}, {1, 6, 9506}, {0, 5, 39344}, {1, 0, 44658}, {1, 1, 56485}, {1, 2, 48112}, {0, 6, 43384}};

        //2783119
        long plus = solution.matrixSumQueriesV1(n, queries);

        System.out.println(plus);
    }

    @Test
    void matrixSumQueriesCase2() {
        String filename = "/Users/mylg/opensource/personal/lettcode/compition/src/test/java/com/lettcode/jqn/compition/weekly348/a.json";
        Solution6472 solution = new Solution6472();
        int n = 6302;
        int[][] queries = json(filename);
        long begin = System.currentTimeMillis();
        long plus = solution.matrixSumQueriesV1(n, queries);
        long end = System.currentTimeMillis();
        System.out.println(plus);
        System.out.println("time=" + (end - begin) + "ms");

    }

    private int[][] json(String filename) {
        String s = readFile(filename);
        int[][] value = JSONObject.parseObject(s, int[][].class);
        return value;
    }

    private static String readFile(String jsonFile) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
//             01.FileInputStream（字节流） 实现了InputStream接口，用来读取文件中的字节流，参数是文件或者文件路径+文件名称
            FileInputStream fileInputStream = new FileInputStream(jsonFile);

            // 02.将 fileInputStream（字节流） 流作为参数，转为InputStreamReader（字符流）
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

            // 03.将 字符流（参数）转为字符串流，带缓冲的流读取，默认缓冲区8k
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String tempString;

            while ((tempString = bufferedReader.readLine()) != null) {// 直接返回读取的字符串
                // 将字符串 添加到 stringBuilder中
                stringBuilder.append(tempString);
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}