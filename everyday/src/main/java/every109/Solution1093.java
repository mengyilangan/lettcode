package every109;

import java.util.TreeMap;

/**
 * 我们对 0 到 255 之间的整数进行采样，并将结果存储在数组 count 中：count[k] 就是整数 k 在样本中出现的次数。
 * <p>
 * 计算以下统计数据:
 * <p>
 * minimum ：样本中的最小元素。
 * maximum ：样品中的最大元素。
 * mean ：样本的平均值，计算为所有元素的总和除以元素总数。
 * median ：
 * 如果样本的元素个数是奇数，那么一旦样本排序后，中位数 median 就是中间的元素。
 * 如果样本中有偶数个元素，那么中位数median 就是样本排序后中间两个元素的平均值。
 * mode ：样本中出现次数最多的数字。保众数是 唯一 的。
 * 以浮点数数组的形式返回样本的统计信息 [minimum, maximum, mean, median, mode] 。与真实答案误差在 10-5 内的答案都可以通过。
 * count.length == 256
 * 0 <= count[i] <= 10的9次方
 * 1 <= sum(count) <= 10的9次方
 * count 的众数是 唯一 的
 */
public class Solution1093 {
    public double[] sampleStats(int[] count) {
        int min = -1;
        int max = 0;
        long sum = 0;
        long times = 0;
        int mod = 0;
        //超过0的数值
        TreeMap<Long, Integer> timesNumber = new TreeMap<>();
        for (int i = 0; i < count.length; i++) {
            //该数值没有出现
            if (count[i] == 0) {
                continue;
            }

            //首次赋值最小值
            if (min < 0) {
                min = i;
            }

            //赋值最大值
            max = i;

            //频次结束的数
            times += count[i];
            timesNumber.put(times, i);

            //重新赋值众数
            if (count[mod] < count[i]) {
                mod = i;
            }
            sum += (long) count[i] * i;
        }
        timesNumber.put(0L, min);
        timesNumber.put(times, max);
        double[] result = new double[5];
        result[0] = min;
        result[1] = max;
        result[2] = sum * 1.0 / times;
        result[4] = mod;

        long before = (times + 1) / 2;
        long after = before + (times + 1) % 2;
        int sumMedian = getValue(timesNumber, before) + getValue(timesNumber, after);
        result[3] = sumMedian * 1.0 / 2;
        return result;
    }

    private int getValue(TreeMap<Long, Integer> timesNumber, long index) {
        if (timesNumber.containsKey(index)) {
            return timesNumber.get(index);
        }

        return timesNumber.higherEntry(index).getValue();
    }
}
