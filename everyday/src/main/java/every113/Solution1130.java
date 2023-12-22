package every113;

import java.util.*;

/**
 * https://leetcode.cn/problems/minimum-cost-tree-from-leaf-values/description/
 */
public class Solution1130 {
    /**
     * 给你一个正整数数组 arr，考虑所有满足以下条件的二叉树：
     * <p>
     * 每个节点都有 0 个或是 2 个子节点。
     * 数组 arr 中的值与树的中序遍历中每个叶节点的值一一对应。
     * 每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积。
     * 在所有这样的二叉树中，返回每个非叶节点的值的最小可能总和。这个和的值是一个 32 位整数。
     * <p>
     * 如果一个节点有 0 个子节点，那么该节点为叶节点。
     *
     * @param arr
     * @return
     */
    public int mctFromLeafValues(int[] arr) {

        //每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积
        Map<String, ReduceTree> reduceTreeMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            ReduceTree reduceTree = new ReduceTree(arr, i);
            reduceTreeMap.put(reduceTree.key, reduceTree);
        }


        Map<String, ReduceTree> newGenerate = innerCombine(reduceTreeMap, Collections.emptyMap());

        //可以做一遍去重
        for (int i = 2; i < arr.length && !newGenerate.isEmpty(); i++) {
            Map<String, ReduceTree> current = innerCombine(newGenerate, reduceTreeMap);
            List<ReduceTree> values = new ArrayList<>(reduceTreeMap.values());
            reduceTreeMap.putAll(current);
            Map<String, ReduceTree> has = innerCombineHistory(newGenerate, values, reduceTreeMap);
            reduceTreeMap.putAll(has);
            current.putAll(has);
            newGenerate = current;
        }


        reduceTreeMap.putAll(newGenerate);
        int sum = Integer.MAX_VALUE;
        for (ReduceTree reduceTree : reduceTreeMap.values()) {
            if (reduceTree.first == 0 && reduceTree.end == arr.length - 1) {
                sum = Math.min(sum, reduceTree.totalSum);
            }
        }
        return sum;
    }
    /**
     * 自己和自己做merge
     *
     * @return
     */
    private Map<String, ReduceTree> innerCombine(Map<String,ReduceTree> collection, Map<String, ReduceTree> contains) {
        //新增的,需要自己和自己做merge
        Map<String, ReduceTree> result = new HashMap<>();
        ArrayList<ReduceTree> reduceTrees = new ArrayList<>(collection.values());
        for (int j = 0; j < reduceTrees.size(); j++) {
            ReduceTree tree = reduceTrees.get(j);
            for (int k = j + 1; k < reduceTrees.size(); k++) {
                ReduceTree newTree = tree.combineReduceTree(reduceTrees.get(k));
                if (newTree == null) {
                    continue;
                }

                ReduceTree old = result.get(newTree.key);
                if (old != null) {
                    if (newTree.compare(old) < 0) {
                        result.put(newTree.key, newTree);
                    }
                    continue;
                }


                old = contains.get(newTree.key);
                if (old == null) {
                    result.put(newTree.key, newTree);
                    continue;
                }

                if (newTree.compare(old) < 0) {
                    result.put(newTree.key, newTree);
                }
            }
        }
        return result;
    }

    /**
     * 自己和历史的做merge
     *
     * @param s1
     * @param contains
     * @return
     */
    private Map<String, ReduceTree> innerCombineHistory(Map<String,ReduceTree> s1, List<ReduceTree> s2, Map<String, ReduceTree> contains) {
        Map<String, ReduceTree> result = new HashMap<>();
        for (ReduceTree tree : s1.values()) {
            for (ReduceTree target : s2) {
                ReduceTree newTree = tree.combineReduceTree(target);
                if (newTree == null) {
                    continue;
                }
                ReduceTree old = result.get(newTree.key);
                if (old != null) {
                    if (newTree.compare(old) < 0) {
                        result.put(newTree.key, newTree);
                    }
                    continue;
                }

                old = contains.get(newTree.key);
                if (old == null) {
                    result.put(newTree.key, newTree);
                    continue;
                }

                if (newTree.compare(old) < 0) {
                    result.put(newTree.key, newTree);
                }
            }
        }
        return result;
    }

     static class ReduceTree {
        public String key;
        public int first = 0;

        public int end;

        public int totalSum;

        public int multi;

        public int max;

        public ReduceTree() {
        }


        public ReduceTree(int[] arr, int index) {
            this.multi = 0;
            this.totalSum = 0;
            this.first = index;
            this.end = index;
            this.max = arr[index];
            key = String.valueOf(first);
        }

        public boolean isAlone() {
            return first == end;
        }

        public int compare(ReduceTree target) {
            return Integer.compare(this.totalSum, target.totalSum);
        }


        /**
         * this:左子树
         * right:右子树
         *
         * @param right
         * @return
         */
        public boolean isCombineRight(ReduceTree right) {
            return right.first == this.end + 1;
        }


        public ReduceTree combineReduceTree(ReduceTree reduceTree) {
            if (isCombineRight(reduceTree)) {
                ReduceTree result = new ReduceTree();
                result.multi = this.max * reduceTree.max;
                result.first = this.first;
                result.end = reduceTree.end;
                result.max = Math.max(this.max, reduceTree.max);
                result.totalSum = result.multi + this.totalSum + reduceTree.totalSum;
                result.key = String.format("%d_%d", first, end);
                return result;
            } else if (reduceTree.isCombineRight(this)) {
                ReduceTree result = new ReduceTree();
                result.multi = this.max * reduceTree.max;
                result.first = reduceTree.first;
                result.end = this.end;
                result.max = Math.max(this.max, reduceTree.max);
                result.totalSum = result.multi + this.totalSum + reduceTree.totalSum;
                result.key = String.format("%d_%d", result.first, result.end);
                return result;
            }
            return null;
        }
    }
}
