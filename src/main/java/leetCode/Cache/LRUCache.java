package leetCode.Cache;

import java.util.*;

class LRUCache {

    LinkedList<Integer> deque;
    Map<Integer,Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        deque = new LinkedList<>();
        map = new HashMap();
    }
    
    public int get(int key) {
        if (deque.contains(key)){
            boolean remove = deque.remove(Integer.valueOf(key));
            deque.addLast(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (deque.contains(key)){
            boolean remove = deque.remove(Integer.valueOf(key));
            deque.addLast(key);
            map.put(key,value);
            return;
        }
        if (deque.size() == capacity){
            map.remove(deque.removeFirst());
        }
        deque.add(key);
        map.put(key,value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );


        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        // cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));
        //cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        //cache.get(1);       // 返回 -1 (未找到)
        //cache.get(3);       // 返回  3
        //cache.get(4);       // 返回  4
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}
