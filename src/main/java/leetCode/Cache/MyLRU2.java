package leetCode.Cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyLRU2<K,V> extends LinkedHashMap<K,V> {

    final private int maxSize;

    public MyLRU2(int maxSize){
        super(maxSize,0.75f,true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > maxSize;
    }

}
