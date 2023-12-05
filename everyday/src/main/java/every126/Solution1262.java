package every126;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.cn/problems/greatest-sum-divisible-by-three/description/
 * <p>
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 */
public class Solution1262 {
    public int maxSumDivThree(int[] nums) {
        List<Integer> oneCollection = new ArrayList<>(nums.length / 2);
        List<Integer> twoCollection = new ArrayList<>(nums.length / 2);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int mod = nums[i] % 3;
            if (mod == 0) {
                sum += nums[i];
            } else if (mod == 1) {
                oneCollection.add(nums[i]);
            } else {
                twoCollection.add(nums[i]);
            }
        }
        return sum + combine(oneCollection, twoCollection);
    }

    private int combine(List<Integer> oneCollection, List<Integer> twoCollection) {
        if (oneCollection.isEmpty()) {
            return sumAll(twoCollection);
        } else if (twoCollection.isEmpty()) {
            return sumAll(oneCollection);
        }

        if (oneCollection.size() % 3 == twoCollection.size() % 3) {
            int sum = 0;
            int i = 0;
            for (; i < Math.min(oneCollection.size(), twoCollection.size()); i++) {
                sum += oneCollection.get(i) + twoCollection.get(i);
            }

            for (; i < oneCollection.size(); i++) {
                sum += oneCollection.get(i);
            }

            for (; i < twoCollection.size(); i++) {
                sum += twoCollection.get(i);
            }
            return sum;
        }

        //其中有一个剩了一个
        if (oneCollection.size() == 1) {
            return sumOne(oneCollection.get(0), twoCollection);
        } else if (twoCollection.size() == 1) {
            return sumOne(twoCollection.get(0), oneCollection);
        }


        //[2,3];[2,4],[3,4]
        int sum = sumLastThree(oneCollection) + sumLastThree(twoCollection);
        switch (oneCollection.size() + twoCollection.size()) {
            case 5:
                if (oneCollection.size() == 2) {
                    sum += sumFive(oneCollection, twoCollection);
                } else {
                    sum += sumFive(twoCollection, oneCollection);
                }
                break;
            case 6:
                if (oneCollection.size() == 2) {
                    sum += sumSix(oneCollection, twoCollection);
                } else {
                    sum += sumSix(twoCollection, oneCollection);
                }
                break;
            case 7:
                if (oneCollection.size() == 3) {
                    sum += sumSeven(oneCollection, twoCollection);
                } else {
                    sum += sumSeven(twoCollection, oneCollection);
                }
                break;
        }

        return sum;
    }


    private int sumLastThree(List<Integer> collection) {
        Collections.sort(collection);
        if (collection.size() <= 4) {
            return 0;
        }
        int sum = 0;
        for (int i = collection.size() - 3; i > 1; i = i - 3) {
            sum += collection.remove(i + 2) + collection.remove(i + 1) + collection.remove(i);
        }
        return sum;
    }

    private int sumAll(List<Integer> collection) {
        if (collection.size() < 3) {
            return 0;
        }

        Collections.sort(collection);
        int start = collection.size() % 3;
        int sum = 0;
        for (; start < collection.size(); start++) {
            sum += collection.get(start);
        }
        return sum;
    }

    private int sumOne(int value, List<Integer> collection) {
        int sum = sumLastThree(collection);
        switch (collection.size()) {
            case 2:
                sum += value + collection.get(1);
                break;
            case 3:
                sum += Math.max(collection.get(0) + collection.get(1), value) + collection.get(2);
                break;
        }
        return sum;
    }

    private int sumFive(List<Integer> two, List<Integer> three) {
        //a,b
        //0,1,2
        //0+1+2
        //b+a+2+1
        return Math.max(two.get(0) + two.get(1), three.get(0)) + three.get(1) + three.get(2);
    }

    private int sumSix(List<Integer> two, List<Integer> four) {
        //a,b
        //0,1,2,3
        //0,1+b  ,2,3
        //2,3,b,a
        return Math.max(four.get(0) + four.get(1), two.get(0)) + two.get(1) + four.get(2) + four.get(3);
    }

    private int sumSeven(List<Integer> three, List<Integer> four) {
        //a,b,c
        //0,1,2,3
        return Math.max(three.get(0) + three.get(1), four.get(0)) + three.get(2) + four.get(1) + four.get(2) + four.get(3);
    }

}
