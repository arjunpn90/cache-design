package com.cache.factories;

import com.cache.Cache;
import com.cache.policies.LRUEvictionPolicy;
import com.cache.storage.HashBasedStorage;

public class CacheFactory<Key, Value> {
    public Cache<Key, Value>  defaultCache(int capacity) {
        return new Cache<Key, Value>(new HashBasedStorage<Key, Value>(capacity), new LRUEvictionPolicy<Key>());
    }
}
