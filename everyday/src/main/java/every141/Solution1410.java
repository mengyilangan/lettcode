package every141;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution1410 {
    /**
     * 双引号：字符实体为 &quot; ，对应的字符是 " 。
     * 单引号：字符实体为 &apos; ，对应的字符是 ' 。
     * 与符号：字符实体为 &amp; ，对应对的字符是 & 。
     * 大于号：字符实体为 &gt; ，对应的字符是 > 。
     * 小于号：字符实体为 &lt; ，对应的字符是 < 。
     * 斜线号：字符实体为 &frasl; ，对应的字符是 / 。
     */
    private static final Map<String, String> replaces = new HashMap<>();

    static {
        replaces.put("&quot;", "\"");
        replaces.put("&apos;", "'");
        replaces.put("&amp;", "&");
        replaces.put("&gt;", ">");
        replaces.put("&lt;", "<");
        replaces.put("&frasl;", "/");
    }

    /**
     * 如何构建树
     */
    public static void init() {
        Tree root = new Tree('&');
    }


    private static class Tree {
        char c;

        Map<Character, Tree> treeMap;

        public Tree(char c) {
            this.c = c;
        }

        public Tree(char c, Tree... trees) {
            this.c = c;
            this.treeMap = Arrays.stream(trees).collect(Collectors.toMap(i -> i.c, i -> i));
        }
    }

    private static class TreeNode extends Tree {
        String word;

        String replace;

        public TreeNode(String word, String replace) {
            super(word.charAt(word.length() - 1));
            this.word = word;
            this.replace = replace;
        }
    }

    /**
     * 构建一个树,看是否匹配到
     *
     * @param text
     * @return
     */
    public String entityParser(String text) {
        return "";
    }
}
