package every125;

import java.util.*;
import java.util.stream.Collectors;

public class Solution1253 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        boolean enough = true;
        List<Integer> one = new ArrayList<>();
        for (int i = 0; i < colsum.length && enough; i++) {
            switch (colsum[i]) {
                case 1:
                    one.add(i);
                case 0:
                    first.add(0);
                    second.add(0);
                    break;
                case 2:
                    lower -= 1;
                    upper -= 1;
                    first.add(1);
                    second.add(1);
                    if (lower < 0 || upper < 0) {
                        enough = false;
                    }
                    break;
            }
        }

        if (!enough || upper + lower != one.size() || (upper == 0 && !one.isEmpty())) {
            return Collections.emptyList();
        }

        if (!one.isEmpty()) {
            Iterator<Integer> indexIterator = one.iterator();
            while (upper > 0 && indexIterator.hasNext()) {
                int index = indexIterator.next();
                upper -= 1;
                first.set(index, 1);
            }

            while (lower > 0 && indexIterator.hasNext()) {
                int index = indexIterator.next();
                lower -= 1;
                second.set(index, 1);
            }

        }

        List<List<Integer>> result = new ArrayList<>(2);
        result.add(first);
        result.add(second);
        return result;
    }
}
