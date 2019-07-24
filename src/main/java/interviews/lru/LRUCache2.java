package interviews.lru;

import java.util.Hashtable;

/**
 * 实现LRU(Least Recently Used)缓存
 * LRU缓存把最近最少使用的数据移除，让给最新读取的数据
 *
 * 实现方式1: 利用 LinkedHashMap 的 removeEldestEntry 方法
 * 实现方式2: 双向链表 + Hashtable
 *
 * 参考文章: https://blog.csdn.net/sd4015700/article/details/24720221
 *
 * 双向链表 + Hashtable
 * @author huliang
 * @date 2019-07-10 17:42
 * @description 双向链表 + Hashtable
 */
public class LRUCache2<K, V> {

    public static void main(String[] args) {
        LRUCache2<Integer, Integer> cache2 = new LRUCache2<>();

        cache2.put(1, 1);
        cache2.put(2, 2);
        cache2.put(3, 3);
        cache2.get(2);

        System.out.println(cache2.first.value);
        cache2.put(4, 4);
        System.out.println(cache2.first.value);
    }

    private Integer DEFAULT_SIZE = 3;
    private Hashtable<K, Entry<K, V>> table = new Hashtable<>();
    private int cacheSize = DEFAULT_SIZE;
    private Entry first;
    private Entry last;

    public V get(K key) {
        Entry<K, V> entry = table.get(key);
        if (entry == null) return null;

        moveToFirst(entry);
        return entry.value;
    }

    public void put(K key, V value) {
        Entry<K, V> entry = table.get(key);

        if (entry == null) {
            if (table.size() >= cacheSize)
                removeLast();

            entry = new Entry<>(key, value);
        }

        moveToFirst(entry);
        table.put(key, entry);
    }

    private void removeLast() {
        if (last == null) return;

        table.remove(last.key);
        if (last.prev == null) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
    }

    private void moveToFirst(Entry<K, V> entry) {
        if (entry == null || entry == first)
            return;

        if (first == null) {
            first = entry;
            last = entry;
            return;
        } else if (entry.prev == entry.next) {
            entry.next = first;
            first.prev = entry;
            first = entry;
            return;
        }

        if (entry == last) {
            entry.prev.next = null;
            last = entry.prev;
        } else {
            entry.prev.next = entry.next;
            entry.next.prev = entry.prev;
        }

        entry.next = first;
        entry.prev = null;
        first = entry;
    }

}

class Entry<K, V> {
    Entry prev;
    Entry next;
    K key;
    V value;

    Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

}
