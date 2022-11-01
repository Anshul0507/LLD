package LRUCache;

public class Test {

  public static void main(String[] args) {
    //["LRUCache","put","put","get","put","get","put","get","get","get"]
    //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    LRUCache lruCache = new LRUCache(2);
    lruCache.put(1,1);
    lruCache.displayCache();

    lruCache.put(2,2);
    lruCache.displayCache();

    lruCache.get(1);
    lruCache.displayCache();

    lruCache.put(3,3);
    lruCache.displayCache();

    lruCache.get(2);
    lruCache.displayCache();

    lruCache.put(4,4);
    lruCache.displayCache();

    lruCache.get(1);
    lruCache.displayCache();

    lruCache.get(3);
    lruCache.displayCache();

    lruCache.get(4);
    lruCache.displayCache();
  }

}
