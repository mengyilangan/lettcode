package every195;

/**
 * @author mylg
 * @date 24/12/23
 */
public class Solution1954 {
    public long minimumPerimeter(long neededApples) {

        long sum = 0;
        for (long i = 1; i <= neededApples; i++) {
            sum += i * i * 12;
            if (sum >= neededApples) {
                return i * 8;
            }
        }
        return 0;
    }
}
