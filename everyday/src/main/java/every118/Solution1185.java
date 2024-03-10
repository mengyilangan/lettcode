package every118;

/**
 * @author mylg
 * @date 31/12/23
 */
public class Solution1185 {
    private static final String[] WEEKS = {
        "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    };

    private static final int[] SUM = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };

    private static final int YEAR = 1971;

    private static final int START_INDEX = 4;

    public String dayOfTheWeek(int day, int month, int year) {
        int move = (day + SUM[month - 1]) % 7;
        if (year == 1972) {
            if (month > 2) {
                move += 1;
            }

            move += 365;
        } else if (year > 1972) {
            ////1973~1976==>1, 1977~1980=>2
            //(2100-1976)=124/4=31
            int two = (year - 1973) / 4 + 1;
            if (month <= 2) {

            } else if (year % 100 == 0) {
                if (year % 400 == 0) {
                    two += 1;
                }
            } else if (year % 4 == 0) {
                two += 1;
            }
            move = move + ((year - YEAR) * 365 + two) % 7;
        }
        move = (move + START_INDEX) % 7;
        return WEEKS[move];
    }


}
