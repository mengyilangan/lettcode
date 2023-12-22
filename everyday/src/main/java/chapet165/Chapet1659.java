//package chapet165;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * https://leetcode.cn/problems/maximize-grid-happiness/
// * 给你四个整数m、、n和。有一个网格，和两种introvertsCount类型的人：内向的和外向的人。共有 一个内向的和个外向的人。extrovertsCountm x nintrovertsCountextrovertsCount
// * <p>
// * 请您决定网格中应当居住多少人，并为每个人分配一个网格单元。注意，必须让所有人都生活在网格中。
// * <p>
// * 每个人的幸福感计算如下：
// * <p>
// * 内向的人开始时有120一个幸福感，但每存在一个邻居（内向的或外向的）他都会失去  30一个幸福感。
// * 外向的人开始时有40一个幸福感，每个存在一个邻居（内向的或外向的）他都会得到  20一个幸福感。
// * 邻居是指居住在一个人所在单元的上、下、左、右四个直接相邻单元中的其他人。
// * <p>
// * 网格幸福感 是每个人的幸福感的总和。返回最大的网格幸福感。
// * <p>
// * /**
// * 1 <= m, n <= 5
// * 0 <= introvertsCount, extrovertsCount <= min(m * n, 6)
// */
//public class Chapet1659 {
//    private static Map<Integer, Integer> treeMap = new HashMap<>();
//
//    static {
//        treeMap.put(1, 1);
//        treeMap.put(2, 1);
//        treeMap.put(3, 1);
//        treeMap.put(4, 2);
//        treeMap.put(5, 3);
//        treeMap.put(6, 3);
//        treeMap.put(8, 4);
//        treeMap.put(9, 5);
//        treeMap.put(10, 5);
//        treeMap.put(12, 6);
//        treeMap.put(15, 8);
//        treeMap.put(16, 8);
//        treeMap.put(20, 10);
//        treeMap.put(25, 13);
//    }
//
//    /**
//     * 最多5*5,是不是可以枚举了
//     *
//     * @param m
//     * @param n
//     * @param introvertsCount
//     * @param extrovertsCount
//     * @return
//     */
//    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
//        //只有一个人,直接返回
//        if (introvertsCount + extrovertsCount <= 1) {
//            return introvertsCount * 120 + extrovertsCount * 40;
//        } else if (extrovertsCount == 0) {
//            int multi = m * n;
//            if (introvertsCount <= treeMap.get(multi)) {
//                return introvertsCount * 120;
//            }
//
//        }
//
//
//        int max = Math.max(m, n);
//        int min = Math.min(m, n);
//        switch (min) {
//            case 1:
//                return one(max, introvertsCount, extrovertsCount);
//            case 2:
//
//            default:
//                return 0;
//        }
//    }
//
//    /**
//     * 一维
//     *
//     * @param count
//     * @param introvertsCount
//     * @param extrovertsCount
//     * @return
//     */
//    public int one(int count, int introvertsCount, int extrovertsCount) {
//        //没有内向的人
//        if (introvertsCount == 0) {
//            if (extrovertsCount <= 1) {
//                return extrovertsCount * 40;
//            }
//            return extrovertsCount * (40 + 20 * 2) - 20 * 2;
//        }
//
//        //只有一个内向的人
//        if (introvertsCount == 1) {
//            //有空白
//            if (introvertsCount + extrovertsCount < count) {
//                return introvertsCount + extrovertsCount * (40 + 20 * 2) - 20 * 2;
//            }
//            return introvertsCount - 30 + extrovertsCount * (40 + 20 * 2) - 20 * 2;
//        }
//
//        //如果有余量
//        int free = count - extrovertsCount - introvertsCount;
//        if (free == 0) {
//            return (120 - 60) * introvertsCount + (40 + 20 * 2) * extrovertsCount + 60;
//        }
//
//        //有俩内向的人
//        if (introvertsCount == 2) {
//            switch (extrovertsCount) {
//                case 0:
//                    return 120 * 2;
//                case 1:
//                    return 120 * 2 + 40 - free * 10;
//                case 2:
//                    return 120 + 40 + 20 + 40 + 40 + 120 - 30;
//            }
//        }
//
//        //有仨内向的人
//        if (introvertsCount == 3) {
//            switch (extrovertsCount) {
//                case 0:
//                    return
//            }
//        }
//    }
//}
