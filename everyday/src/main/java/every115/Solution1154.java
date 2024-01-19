package every115;

/**
 * @author mylg
 * @date 1/1/24
 */
public class Solution1154 {
    private static final int[] SUM = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };

    public int dayOfYear(String date) {
        String[] dates = date.split("-");
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        int res = SUM[month - 1] + day;
        if (month <= 2) {
            return res;
        }
        int year = Integer.parseInt(dates[0]);
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                res += 1;
            }
        } else if (year % 4 == 0) {
            res += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("08"));
    }
}
