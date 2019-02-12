/**
 *  Priority Queue code.
 *
 *  The queue is defined as a Fibonacci Heap so that its complexity will be in O(lg n) in both insertion and deletion
 *
 *  @author: Riccardo Sieve
 * 
 *  @param <Node>: type of PriorityQueue elements.
 *  @param <E>: Generic type of element.
 *  @param <P>: Generic type of Priority (generally an integer or float)
 */
package com.algorithm.riccardo.priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.ExecutionException;

public class PriorityQueue<E,P> {

    protected ArrayList<Node<E,P>> priorityQueue;
    protected Comparator<? super P> comparator;

    /**
     *  Constructor use to initialise the structure with the following data:
     *  @param comparator: comparator implementing a relation order of priorityQueue between elements
     */
    public PriorityQueue(Comparator<? super P> comparator) {
        this.priorityQueue = new ArrayList<Node<E,P>>();
        this.comparator = comparator;
    }

    /**
     *  @return priorityQueue structure
     */
    public ArrayList<Node<E,P>> getPriorityQueue() { return this.priorityQueue; }

    /**
     *
     *  @param position: position of the elemnt we are going to take from the array list
     *  @return element in position passed to the method
     */
    public Node<E,P> getElement(int position) { return (this.priorityQueue).get(position); }

    /**
     *
     *  @return element in position (aka element with minimum priority)
     */
    public Node<E,P> getMinimumElement() { return getElement(0); }

    /**
     *  @param i: index of the current position to calculate the index of the parent node
     *  @return index of the parent node
     *  @throws Exception: if the index is outside the bound it will throw an exception
     */
    public int getParentPosition (int i) throws Exception {
        if(i == 0)
            throw new Exception ("Out of bounds");
        else
            return (i - 1) / 2;
    }

    /**
     *  @param i: index of the current position to calculate the parent of the node
     *  @return the parent of the element
     *  @throws Exception: if the element is outside the bound it will throw an exception
     */
    public Node<E,P> getParent (int i) throws Exception {
        if(i == 0)
            throw new Exception("Out of bound exception");
        else
            return getElement(getParentPosition(i));
    }

    /**
     *  @return size of the priorityQueue
     */
    public int getSize() { return (this.priorityQueue).size(); }

    /**
     *  @param i: parameter of the index passed to get children
     *  @param n: parameter used the check dimension
     *  @return true if the elements are smaller than size
     */
    public boolean isSmaller (int i, int n) {
        return (2 * i) + n < getSize();
    }

    /**
     *  @param i: index of the current position to move to the left child
     *  @return position of the left child
     */
    public int getLeftChildPosition (int i) {
        return isSmaller(i, 1) ? ((2 * i) + 1) : i;
    }

    /**
     *  @param i: index of the current position to get the left child
     *  @return left child
     */
    public Node<E,P> getLeftChildElement (int i) {
        return getElement(getLeftChildPosition(i));
    }

    /**
     *  @param i: index of the current position to move to the right chiild
     *  @return position of the right child
     */
    public int getRightChildPosition (int i) {
        return isSmaller(i, 2) ? ((2 * i) + 2) : i;
    }

    public Node<E,P> getRightChildElement (int i) {
        return getElement(getRightChildPosition(i));
    }

    /**
     *  @param position position of the element
     *  @param element: element to be added to the structure
     *  @throws Exception exception that can be thrown in case of error
     */
    public void setPriorityQueue(int position, Node<E,P> element) throws Exception { this.priorityQueue.set(position, element); }

    /**
     *  Check if the queue is empty
     *  @return true if the the structure is empty
     */
    public boolean isEmpty() {
        return (this.priorityQueue).isEmpty();
    }

    /**
     *  @param position: position of the current element
     *  @param parentPosition position of the parent of the current element
     *  @throws Exception
     */
    public void swap(int position, int parentPosition) throws Exception {
        Node<E,P> temp = getElement(position);
        setPriorityQueue(position, getElement(parentPosition));
        setPriorityQueue(parentPosition, temp);
    }

    /**
     *  @param element: element to be inserted in the priorityQueue
     *  @throws Exception
     */
    public void insert(Node<E,P> element) throws Exception {
        priorityQueue.add(element);

        int index = priorityQueue.indexOf(element);
        int iterator = 0;

        while(index > 0 && (this.comparator).compare(getParent(index).getPriority(),
                getElement(index).getPriority()) > 0) {
            swap(index, getParentPosition(index));
            index = getParentPosition(index);
            iterator++;
        }
    }

    /**
     *  @param element: current element
     *  @param newElement: new element
     *  @throws Exception
     */
    public void changeKey (Node<E,P> element, E newElement) throws Exception {
        int position = getPriorityQueue().indexOf(element);
        getElement(position).setElement(newElement);
    }

    /**
     *  @param left position of the leftChild
     *  @param right position of the rightChild
     *  @return the index of the child with minimum priority
     */
    private int minimumIndex(int left, int right) {
        if((this.comparator).compare(getElement(left).getPriority(),
                getElement(right).getPriority()) > 0)
            return right;
        else
            return left;
    }

    /**
     *  @param leftChild: left child
     *  @param rightChild: right child
     *  @return minimum priority between the two children
     */
    private P minimumPriority (Node<E,P> leftChild, Node<E,P> rightChild) {
        if((this.comparator).compare(leftChild.getPriority(),
                rightChild.getPriority()) < 0)
            return leftChild.getPriority();
        else
            return rightChild.getPriority();
    }

    /**
     *  @return node at position 0
     *  @throws Exception
     */
    public Node<E,P> remove() throws Exception {
        if(getSize() == 0)
            throw new Exception("Queue does not contain element");

        Node<E,P> minimumElement = getElement(0);

        setPriorityQueue(0, getElement(getSize()-1));
        this.priorityQueue.remove(getSize() - 1);

        int position = 0;
        int flag = 0;

        while(position < getSize() && (this.comparator).compare(getElement(position).getPriority(),
                minimumPriority(getLeftChildElement(position),
                        getRightChildElement(position))) > 0) {
            flag = minimumIndex(getLeftChildPosition(position), getRightChildPosition(position));
            swap(position, minimumIndex(getLeftChildPosition(position), getRightChildPosition(position)));
            position = flag;
        }

        return minimumElement;
    }

    /**
     *  @param element: current element
     *  @param newPriority: new priority for the element
     *  @throws Exception
     */
    public void changePriority(Node<E,P> element, P newPriority) throws Exception {
        if(getSize() == 0)
            throw new Exception("Queue does not contain element");
        else if ((this.comparator).compare(element.getPriority(), newPriority) < 0) {
            int position = getPriorityQueue().indexOf(element);
            int flag = 0;

            getElement(position).setPriority(newPriority);

            while(position < getSize() && (this.comparator).compare(getElement(position).getPriority(),
                    minimumPriority(getLeftChildElement(position),
                            getRightChildElement(position))) > 0) {
                flag = minimumIndex(getLeftChildPosition(position), getRightChildPosition(position));
                swap(position, flag);
                position = flag;
            }
        } else if ((this.comparator).compare(element.getPriority(), newPriority) > 0) {
            int index = getPriorityQueue().indexOf(element);
            getElement(index).setPriority(newPriority);

            while(index > 0 && (this.comparator).compare(getParent(index).getPriority(),
                    getElement(index).getPriority()) > 0) {
                swap(index, getParentPosition(index));
                index = getParentPosition(index);
            }
        }
    }

    /**
     *  @param element: element to check if present in the queue
     *  @return true if the element is present
     */
    public boolean contains(Node<E,P> element) {
        boolean presence = false;

        for(int i=0; i<getSize() && !presence; i++) {
            if(getElement(i).getElement().toString().equals(element.getElement().toString()))
                presence = true;
        }

        return presence;
    }

    public void printQueue() {
        for(int i=0; i<getSize(); i++) {
            System.out.println("\n" + getElement(i).getElement() + " Left Child: " + getLeftChildElement(i).getElement());
            System.out.println("\n" + getElement(i).getElement() + " Right Child: " + getRightChildElement(i).getElement());
        }
    }
}

