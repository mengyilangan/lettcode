package every038;

/**
 * @author mylg
 * @date 7/1/24
 */
public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        int[] expect = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int index = c - 'a';
            expect[index] += 1;
        }
        int sum = ransomNote.length();
        for (char c : magazine.toCharArray()) {
            int index = c - 'a';
            if (expect[index] > 0) {
                expect[index] -= 1;
                sum -= 1;
            }
        }
        return sum == 0;
    }
}
