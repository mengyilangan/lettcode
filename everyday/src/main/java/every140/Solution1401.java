package every140;

/**
 * https://leetcode.cn/problems/circle-and-rectangle-overlapping/
 * 给你一个以 (radius, xCenter, yCenter) 表示的圆和一个与坐标轴平行的矩形 (x1, y1, x2, y2) ，其中 (x1, y1) 是矩形左下角的坐标，而 (x2, y2) 是右上角的坐标。
 * <p>
 * 如果圆和矩形有重叠的部分，请你返回 true ，否则返回 false 。
 * <p>
 * 换句话说，请你检测是否 存在 点 (xi, yi) ，它既在圆上也在矩形上（两者都包括点落在边界上的情况）。
 * 1 <= radius <= 2000
 * -104 <= xCenter, yCenter <= 104
 * -104 <= x1 < x2 <= 104
 * -104 <= y1 < y2 <= 104
 */
public class Solution1401 {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        Rectangle rectangle = new Rectangle(x1, y1, x2, y2);
        int[][] circlePoints = {{xCenter, yCenter}, {xCenter - radius, yCenter}, {xCenter + radius, yCenter}, {xCenter, yCenter - radius}, {xCenter, yCenter + radius},};
        for (int[] point : circlePoints) {
            if (rectangle.containsPoint(point[0], point[1])) {
                return true;
            }
        }

        circlePoints = new int[][]{
                {x1, yCenter},
                {x2, yCenter},
                {xCenter, y1},
                {xCenter, y2}
        };

        for (int[] point : circlePoints) {
            if (Math.abs(point[0] - xCenter) + Math.abs(point[1] - yCenter) <= radius) {
                if (rectangle.containsPoint(point[0], point[1])) {
                    return true;
                }
            }
        }


        int radiusSquare = radius * radius;
        int[][] values = {{x1, y1}, {x2, y2}, {x1, y2}, {x2, y1}};
        for (int[] point : values) {
            int distanceX = point[0] - xCenter;
            int distanceY = point[1] - yCenter;
            int distanceSquare = distanceX * distanceX + distanceY * distanceY;
            if (radiusSquare >= distanceSquare) {
                return true;
            }
        }
        return false;
    }

    private static class Rectangle {
        private int[] leftDown;

        private int[] rightUp;

        public Rectangle(int x1, int y1, int x2, int y2) {
            int minX = x1;
            int maxX = x2;
            if (x1 > x2) {
                maxX = x1;
                minX = x2;
            }

            int minY = y1;
            int maxY = y2;
            if (y1 > y2) {
                maxY = y1;
                minY = y2;
            }
            this.leftDown = new int[]{minX, minY};
            this.rightUp = new int[]{maxX, maxY};
        }

        public boolean containsPoint(int x, int y) {
            //圆心在矩形内
            return leftDown[0] <= x && x <= rightUp[0] && leftDown[1] <= y && y <= rightUp[1];
        }
    }
}
