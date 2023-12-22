package every149;
import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/parallel-courses-ii/
 * <p>
 * 给你一个整数 n 表示某所大学里课程的数目，编号为 1 到 n ，数组 relations 中， relations[i] = [xi, yi]
 * 表示一个先修课的关系，也就是课程 xi 必须在课程 yi 之前上。同时你还有一个整数 k 。
 * <p>
 * 在一个学期中，你 最多 可以同时上 k 门课，前提是这些课的先修课在之前的学期里已经上过了。
 * <p>
 * 请你返回上完所有课最少需要多少个学期。题目保证一定存在一种上完所有课的方式。
 * <p>
 * 1 <= n <= 15
 * 1 <= k <= n
 * 0 <= relations.length <= n * (n-1) / 2
 * relations[i].length == 2
 * 1 <= xi, yi <= n
 * xi != yi
 */
public class Solution1494 {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int min = n / k + n % k;//===>最少需要的学期数
        if (min >= n || relations.length == 0) {
            return min;
        } else if (relations.length == n * (n - 1) / 2) {
            return n;
        }

        Map<Integer, Course> courseMap = new HashMap<>();
        for (int[] relation : relations) {
            Course parent = courseMap.get(relation[1]);
            Course child = courseMap.get(relation[0]);
            parent.addChild(child);
        }

        TreeMap<Integer, Set<Integer>> levelCourse = new TreeMap<>();

        TreeSet<Integer> overLevel = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            Course course = courseMap.getOrDefault(i, new Course(i));
            Set<Integer> courseIds = levelCourse.getOrDefault(course.level, new TreeSet<>());
            courseIds.add(i);

            levelCourse.put(i, courseIds);
            if (courseIds.size() > k) {
                overLevel.add(course.level);
            }
        }

        //没有超过的层级
        if (overLevel.isEmpty()) {
            return levelCourse.lastKey();
        }

        //只有最后一层超了
        if (overLevel.size() == 1 && Objects.equals(overLevel.iterator().next(), levelCourse.lastKey())) {
            Map.Entry<Integer, Set<Integer>> entry = levelCourse.lastEntry();
            return entry.getKey() + (entry.getValue().size() - 1) / k;
        }

        do {
            //处理这一层
            int level = overLevel.first();
            overLevel.remove(level);
            Set<Integer> courseIds = levelCourse.get(level);
            if (courseIds.size() <= k) {
                continue;
            }

            //向下一层裂变,每一层的courseId更新
            List<Course> sortCourse = courseIds.stream()
                    .map(courseMap::get)
                    .sorted(Comparator.comparing(Course::getMaxDepth)
                            .thenComparing(Course::childSize))
                    .limit(1)
                    .collect(Collectors.toList());


        } while (overLevel.isEmpty());

        return levelCourse.lastKey();
    }

    public static class Course {
        private final int i;

        private final Map<Integer, Course> childCourse;

        private final Map<Integer, Course> parentCourse;

        private int level = 1;

        private int maxDepth = 1;

        private int maxWidth = 1;

        public int childSize() {
            return childCourse.size();
        }

        public int getLevel() {
            return level;
        }

        public int getMaxDepth() {
            return maxDepth;
        }

        public Course(int i) {
            this.i = i;
            this.childCourse = new HashMap<>();
            this.parentCourse = new HashMap<>();
        }

        /**
         * 宽度是向上查找的
         * 深度是向下查找的
         *
         * @param child
         */
        public void addChild(Course child) {
            int beforeSize = child.childSize();
            this.childCourse.put(child.i, child);
            if (maxWidth == beforeSize) {
                this.maxWidth = this.maxWidth + 1;
                refreshParent();
            }
            child.addParent(this);
            this.maxDepth = Math.max(child.maxDepth, maxDepth);
            refreshParent();
        }

        public void addParent(Course parent) {
            parentCourse.put(parent.i, parent);
        }

        private int refreshLevel(int parentLevel) {
            int atLeastLevel = parentLevel + 1;
            if (atLeastLevel <= level) {
                return maxDepth;
            }

            level = atLeastLevel;
            for (Course course : childCourse.values()) {
                this.maxDepth = Math.max(course.refreshLevel(level) + 1, maxDepth);
            }
            return this.maxDepth;
        }

        private void refreshParent() {
            if (parentCourse.size() == maxDepth)

                for (Course course : parentCourse.values()) {

                }
        }
    }
}
