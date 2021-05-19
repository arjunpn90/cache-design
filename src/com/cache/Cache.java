package com.cache;

import com.cache.exceptions.NotFoundException;
import com.cache.exceptions.StorageFullException;
import com.cache.policies.EvictionPolicy;
import com.cache.storage.HashBasedStorage;
import com.cache.storage.Storage;

public class Cache<Key, Value> {
    private Storage<Key, Value> storage;
    private EvictionPolicy<Key> evictionPolicy;

    public Cache(Storage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public void put(Key key, Value val) {
        try {
            storage.add(key, val);
            evictionPolicy.accessedKey(key);
        } catch (StorageFullException ex) {
            System.out.println("Got storage full. Will try to evict.");
            Key keyToRemove = evictionPolicy.evictKey();
            storage.remove(keyToRemove);
            System.out.println("Creating space by evicting item..." + keyToRemove);
            put(key, val);
        }
    }

    public Value get(Key key) {
        try {
            Value requiredValue = storage.get(key);
            evictionPolicy.accessedKey(key);
            return requiredValue;
        } catch (NotFoundException ex) {
            System.out.println("Tried to access non-existing key.");
            return null;
        }
    }
}
