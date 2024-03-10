package every036;

/**
 * 有两个水壶，容量分别为 jug1Capacity 和 jug2Capacity 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 targetCapacity 升。
 * <p>
 * 如果可以得到 targetCapacity 升水，最后请用以上水壶中的一或两个来盛放取得的 targetCapacity 升水。
 * <p>
 * 你可以：
 * <p>
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * <p>
 * 1 <= jug1Capacity, jug2Capacity, targetCapacity <= 10^6
 */
public class Solution365 {
    /**
     * 示例 1:
     * <p>
     * 输入: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
     * 输出: true
     * 解释：来自著名的 "Die Hard"
     * 示例 2:
     * <p>
     * 输入: jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5
     * 输出: false
     * 示例 3:
     * <p>
     * 输入: jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3
     * 输出: true
     *
     * @param jug1Capacity
     * @param jug2Capacity
     * @param targetCapacity
     * @return
     */

    // 4,6,8
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity == jug1Capacity || targetCapacity == jug2Capacity) {
            return true;
        }

        int sum = jug1Capacity + jug2Capacity;
        if (targetCapacity > sum) {
            return false;
        } else if (targetCapacity == sum) {
            return true;
        }

        int min = jug1Capacity;
        int max = jug2Capacity;
        if (min > max) {
            min = jug2Capacity;
            max = jug1Capacity;
        }

        //两个水杯一样,等于没有水杯
        if (min == max) {
            return false;
        }

        //需要两杯水
        if (targetCapacity > max) {

        } else if (targetCapacity < min) {
            //需要差值水
        }


        //13-11=2；
        //11-2=9
        //13-9=4;
        //11-4=7
        //13-7=6
        //11-6=5
        //13-5=8
        //11-8=3
        //13-3=10
        //11-10=1;


        if (targetCapacity % min == 0) {
            return true;
        }

        //大的水杯是小的倍数,需要几个小水杯才行
        int value = max % min;
        if (value == 0) {
            return targetCapacity % min == 0;
        }

        //这是不断向大的里面浇水
        if ((targetCapacity - value) % min == 0) {
            return true;
        }

        //用小水杯拖底
        int diff = min - value;

        return (targetCapacity - diff) % min == 0;
    }
}
