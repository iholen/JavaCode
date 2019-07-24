package interviews.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 实现LRU(Least Recently Used)缓存
 * LRU缓存把最近最少使用的数据移除，让给最新读取的数据
 *
 * 实现方式1: 利用 LinkedHashMap 的 removeEldestEntry 方法
 * 实现方式2: 双向链表 + Hashtable
 *
 * 参考文章: https://blog.csdn.net/sd4015700/article/details/24720221
 *
 * @author huliang
 * @date 2019-07-10 17:42
 * @description 利用 LinkedHashMap 的 removeEldestEntry 方法
 */
public class LRUCache<K, V> {

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.get(3);
        cache.put(5, 5);
        cache.put(6, 6);
        Set<Map.Entry<Integer, Integer>> entries = cache.getAll();
        entries.forEach(entry -> System.out.println("key:" + entry.getKey() + ", value: " + entry.getValue()));
    }

    private LinkedHashMap<K, V> linkedHashMap;
    private int cacheSize;
    private float loadFactor = 0.75f;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        int hashCapacity = Double.valueOf(Math.ceil(cacheSize / loadFactor) + 1).intValue();
        linkedHashMap = new LinkedHashMap<K, V>(hashCapacity, loadFactor, true) {

            private static final long serialVersionUID = -5849145012798697353L;

            @Override
            public boolean removeEldestEntry(Map.Entry<K,V> eldest) {
                return size() > LRUCache.this.cacheSize;
            }

        };
    }

    public synchronized V get(K key) {
        return linkedHashMap.get(key);
    }

    public synchronized void put(K key, V value) {
        linkedHashMap.put(key, value);
    }

    public synchronized void clear() {
        linkedHashMap.clear();
    }

    public synchronized Set<Map.Entry<K,V>> getAll() {
        return linkedHashMap.entrySet();
    }

}
