package every087;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        //路障遍历
        Map<Integer, Set<Integer>> obstacleMap = new HashMap<>();
        for (int[] obstacle : obstacles) {
            Set<Integer> values = obstacleMap.getOrDefault(obstacle[0], new HashSet<>());
            values.add(obstacle[1]);
            obstacleMap.put(obstacle[0], values);
        }

        int max = 0;
        Way way = new Way(obstacleMap);
        for (int command : commands) {
            if (command < 0) {
                way.move(command);
                continue;
            }

            //确认能否移动到目的地
            switch (way.current) {
                case NORTH:
                case WEST:

            }

        }
        return max;
    }

    public static class Way {
        private int x;
        private int y;

        private Direction current;
        private Map<Integer, Set<Integer>> obstacleMap;

        public Way(Map<Integer, Set<Integer>> obstacleMap) {
            this.obstacleMap = obstacleMap;
            current = Direction.NORTH;
        }

        private static final Map<Direction, Direction> left = new HashMap<>(5);

        static {
            left.put(Direction.NORTH, Direction.WEST);
            left.put(Direction.WEST, Direction.SOUTH);
            left.put(Direction.SOUTH, Direction.EAST);
            left.put(Direction.EAST, Direction.NORTH);
        }

        private static final Map<Direction, Direction> right = new HashMap<>(5);

        static {
            right.put(Direction.NORTH, Direction.EAST);
            right.put(Direction.EAST, Direction.SOUTH);
            right.put(Direction.SOUTH, Direction.WEST);
            right.put(Direction.WEST, Direction.NORTH);
        }

        public void move(int command) {
            if (command == -1) {
                current = right.get(current);
            } else if (command == -2) {
                current = left.get(current);
            }
        }
    }


    public static enum Direction {
        NORTH, SOUTH, WEST, EAST;
    }
}
