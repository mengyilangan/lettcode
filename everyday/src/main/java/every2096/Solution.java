package every2096;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.hsf.HSFJSONUtils;

import java.util.*;

/**
 * https://leetcode.cn/problems/brace-expansion-ii/
 * 如果你熟悉 Shell 编程，那么一定了解过花括号展开，它可以用来生成任意字符串。
 * <p>
 * 花括号展开的表达式可以看作一个由 花括号、逗号 和 小写英文字母 组成的字符串，定义下面几条语法规则：
 * <p>
 * 如果只给出单一的元素 x，那么表达式表示的字符串就只有 "x"。R(x) = {x}
 * 例如，表达式 "a" 表示字符串 "a"。
 * 而表达式 "w" 就表示字符串 "w"。
 * 当两个或多个表达式并列，以逗号分隔，我们取这些表达式中元素的并集。R({e_1,e_2,...}) = R(e_1) ∪ R(e_2) ∪ ...
 * 例如，表达式 "{a,b,c}" 表示字符串 "a","b","c"。
 * 而表达式 "{{a,b},{b,c}}" 也可以表示字符串 "a","b","c"。
 * 要是两个或多个表达式相接，中间没有隔开时，我们从这些表达式中各取一个元素依次连接形成字符串。R(e_1 + e_2) = {a + b for (a, b) in R(e_1) × R(e_2)}
 * 例如，表达式 "{a,b}{c,d}" 表示字符串 "ac","ad","bc","bd"。
 * 表达式之间允许嵌套，单一元素与表达式的连接也是允许的。
 * 例如，表达式 "a{b,c,d}" 表示字符串 "ab","ac","ad"。
 * 例如，表达式 "a{b,c}{d,e}f{g,h}" 可以表示字符串 "abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"。
 * 给出表示基于给定语法规则的表达式 expression，返回它所表示的所有字符串组成的有序列表。
 */
public class Solution {

    public List<String> braceExpansionII(String expression) {
        if (expression.length() == 1) {
            switch (expression) {
                case ",":
                case "{":
                case "}":
                    return Collections.emptyList();
                default:
                    return Collections.singletonList(expression);
            }
        }
        return new ArrayList<>(multi(expression));
    }

    private Set<String> multi(String expression) {
        expression = expression.replace("},{", ",");
        List<Fragment> roots = new ArrayList<>();
        Map<String, Fragment> fragmentMap = new HashMap<>();
        Fragment fragment = null;
        StringBuilder builder = new StringBuilder();
        for (char c : expression.toCharArray()) {
            switch (c) {
                case '{':
                    if (fragment == null) {
                        fragment = new Fragment();
                        fragmentMap.put(fragment.getIds(), fragment);
                    }
                    if (builder.length() > 0) {
                        fragment.words.add(builder.toString());
                        builder = new StringBuilder();
                    }
                    Fragment child = new Fragment();
                    fragmentMap.put(child.getIds(), child);
                    child.parent = fragment;
                    fragment = child;
                    break;
                case '}':
                    if (builder.length() > 0) {
                        fragment.words.add(builder.toString());
                        builder = new StringBuilder();
                    }

                    if (fragment.parent != null) {
                        Fragment parent = fragment.parent;
                        parent.children.add(fragment.getIds());
                        fragment = fragment.parent;
                    } else {
                        roots.add(fragment);
                        fragment = null;
                    }
                    break;
                case ',':
                    if (fragment == null) {
                        fragment = new Fragment();
                        fragmentMap.put(fragment.getIds(), fragment);
                    }
                    fragment.words.add(builder.toString());
                    builder = new StringBuilder();
                    break;
                default:
                    builder.append(c);
                    break;
            }
        }
        if (fragment != null) {
            roots.add(fragment);
        }
        System.out.println("roots_size=" + roots.size() + ",roots = " + JSON.toJSON(roots));
        System.out.println("index=" + JSON.toJSON(fragmentMap));
        Set<String> result = new HashSet<>();
        for (Fragment parent : roots) {
            result.addAll(assemble(Collections.<String>emptyList(), parent, fragmentMap));
        }
        return result;
    }

    private Set<String> assemble(Collection<String> prefix, Fragment current, Map<String, Fragment> fragmentMap) {
        Set<String> resultPrefix = new HashSet<>();
        if (!current.words.isEmpty()) {
            if (prefix.isEmpty()) {
                resultPrefix.addAll(current.words);
            } else {
                for (String item : prefix) {
                    for (String word : current.words) {
                        resultPrefix.add(item.concat(word));
                    }
                }
            }
        } else {
            resultPrefix.addAll(prefix);
        }


        if (current.children.isEmpty()) {
            return resultPrefix;
        }

        for (String child : current.children) {
            Fragment fragment = fragmentMap.get(child);
            resultPrefix = assemble(resultPrefix, fragment, fragmentMap);
        }
        return resultPrefix;

    }
}
