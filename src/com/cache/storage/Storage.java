package com.cache.storage;

import com.cache.exceptions.NotFoundException;
import com.cache.exceptions.StorageFullException;

public interface Storage<Key, Value> {
    void add(Key key, Value val) throws StorageFullException;

    Value get(Key key) throws NotFoundException;

    void remove(Key key) throws NotFoundException;
}
