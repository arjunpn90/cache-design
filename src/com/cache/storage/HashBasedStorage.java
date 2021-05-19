package com.cache.storage;

import com.cache.exceptions.NotFoundException;
import com.cache.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashBasedStorage<Key, Value> implements Storage<Key, Value> {

    Map<Key, Value> storage;
    int capacity;

    public HashBasedStorage(int capacity) {
        storage = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void add(Key key, Value val) throws StorageFullException {
        if (storage.size() == capacity) throw new StorageFullException("Capacity full......");
        storage.put(key, val);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        return storage.get(key);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        if (!storage.containsKey(key)) throw new NotFoundException(key + " not found in cache.......");
        storage.remove(key);
    }
}
