/**
 *  Code for the Node of the Priority Queue based on the Fibonacci Heap
 *
 *  @author Riccardo Sieve
 *  @version 1.5
 *  @param <E>: type of Fibonacci Heap element
 */

package com.algorithm.riccardo.priorityqueue;

import java.util.Comparator;

public class Node<E,P> {

    private E element;
    private P priority;

    public Node (E element, P priority) {
        this.element = element;
        this.priority = priority;
    }

    public Node (E element) {
        this.element = element;
    }

    // getters
    public E getElement() { return this.element; }
    public P getPriority() { return this.priority; }

    // setters
    public void setElement (E element) { this.element = element; }
    public void setPriority (P priority) {this.priority = priority; }

    @Override
    public String toString() {
        return "Element: " + getElement() + " with priority: " + getPriority();
    }
}
