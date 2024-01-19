package every270;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 状态转移,逐步求解:
 * 给你一个下标从 0 开始的字符串 s 和一个单词字典 dictionary 。你需要将 s 分割成若干个 互不重叠 的子字符串，每个子字符串都在 dictionary 中出现过。s 中可能会有一些 额外的字符 不在任何子字符串中。
 * <p>
 * 请你采取最优策略分割 s ，使剩下的字符 最少 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leetscode", dictionary = ["leet","code","leetcode"]
 * 输出：1
 * 解释：将 s 分成两个子字符串：下标从 0 到 3 的 "leet" 和下标从 5 到 8 的 "code" 。只有 1 个字符没有使用（下标为 4），所以我们返回 1 。
 * 示例 2：
 * <p>
 * 输入：s = "sayhelloworld", dictionary = ["hello","world"]
 * 输出：3
 * 解释：将 s 分成两个子字符串：下标从 3 到 7 的 "hello" 和下标从 8 到 12 的 "world" 。下标为 0 ，1 和 2 的字符没有使用，所以我们返回 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 50
 * 1 <= dictionary.length <= 50
 * 1 <= dictionary[i].length <= 50
 * dictionary[i] 和 s 只包含小写英文字母。
 * dictionary 中的单词互不相同。
 *
 * @author mylg
 * @date 9/1/24
 */
public class Solution2707 {
    public int minExtraChar(String s, String[] dictionary) {
        List<Index> list = new ArrayList<>();
        for (String dict : dictionary) {
            if (s.contains(dict)) {
                int start = s.indexOf(dict);
                Index index = new Index(start, dict);
                list.add(index);
            }
        }

        List<Index> sorted = list.stream().sorted(Comparator.comparingInt(Index::getStart)).collect(Collectors.toList());
        return 1;
    }
}


class Index {
    int start;

    int end;

    String word;

    public Index(int start, String word) {
        this.start = start;
        this.end   = start + word.length();
        this.word  = word;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getWord() {
        return word;
    }
}
