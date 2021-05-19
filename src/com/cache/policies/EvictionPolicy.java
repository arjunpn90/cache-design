package com.cache.policies;

public interface EvictionPolicy<Key> {
    void accessedKey(Key key);
    Key evictKey();
}
