package leetCode.Cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MyLRU {

    private final int size;

    private final Deque<Integer> deque;

    private final Map<Integer, Object> map;

    public MyLRU(int size) {
        this.size = size;
        this.deque = new LinkedList<>();
        this.map = new HashMap<>();
    }

    //
    public Object get(int key) {
        if (deque.contains(key)) {
            deque.remove(key);
            deque.addLast(key);
            return map.get(key);
        }
        return null;
    }

    public void put(int key, Object value) {
        if (deque.contains(key)) {
            deque.remove(key);
            deque.addLast(key);
            map.put(key, value);
        }

        //
        if (deque.size() == size) {
            Integer integer = deque.removeFirst();
            map.remove(integer);
        }
        deque.addLast(key);
        map.put(key, value);
    }
}
