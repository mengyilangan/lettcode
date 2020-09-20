package every146;

import java.util.LinkedHashMap;

public class Solution {

}

class LRUCache {

    private final LinkedHashMap<Integer, Integer> map;

    private final int capacity;

    public LRUCache(int capacity) {
        map           = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (map.size() == capacity) {
            /**
             * 清楚老旧数据
             */
        }
    }

    private static class LinkedHashMap<K, V> extends java.util.LinkedHashMap<K, V> {

    }
}
