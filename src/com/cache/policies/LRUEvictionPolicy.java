package com.cache.policies;

import com.cache.model.DoublyLinkedList;
import com.cache.model.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    DoublyLinkedList<Key> dll;
    Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy() {
        dll = new DoublyLinkedList<>();
        mapper = new HashMap<>();
    }

    public void accessedKey(Key key) {
        if (mapper.containsKey(key)) {
            dll.detachNode(mapper.get(key));
            dll.addNodeAtLast(mapper.get(key));
        } else {
            DoublyLinkedListNode<Key> newNode = new DoublyLinkedListNode<>(key);
            dll.addNodeAtLast(newNode);
            mapper.put(key, newNode);
        }
    }

    public Key evictKey() {
        DoublyLinkedListNode<Key> firstNode = dll.getFirstNode();
        if (firstNode != null)
            dll.detachNode(firstNode);
        return firstNode.getElement();
    }
}
