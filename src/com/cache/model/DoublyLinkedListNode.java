package com.cache.model;

public class DoublyLinkedListNode<E> {
    DoublyLinkedListNode<E> prev;
    DoublyLinkedListNode<E> next;
    E element;

    public DoublyLinkedListNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

    public E getElement() {
        return element;
    }
}
