package com.algorithm.riccardo.test;

import com.algorithm.riccardo.priorityqueue.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTests{

    class DoubleComparator implements Comparator<Double> {
        @Override
        public int compare(Double i1, Double i2){
            return i1.compareTo(i2);
        }
    }//inner class


    static Node<Double,Double> i1, i2, i3;
    static PriorityQueue<Double,Double> queue;

    @BeforeEach //before each tests
    public void FibqueueTests(){
        i1 = new Node<Double,Double>(new Double(2),new Double(2));
        i2 = new Node<Double,Double>(new Double(3),new Double(3));
        i3 = new Node<Double,Double>(new Double(4),new Double(4));
        queue = new PriorityQueue<Double,Double>(new DoubleComparator());
    }

    @Test
    public void testIsEmpty(){

        assertTrue(queue.isEmpty());
    }

    @Test
    public void testoneElement() throws Exception{
        queue.insert(i1);

        assertFalse(queue.isEmpty());
    }


    @Test
    public void testSizeZero(){

        assertEquals(0,queue.getSize());
    }

    @Test
    public void testSizeOneElement() throws Exception{
        queue.insert(i1);

        assertEquals(1,queue.getSize());
    }

    @Test
    public void testSizeTwoElements() throws Exception{
        queue.insert(i1);
        queue.insert(i2);

        assertEquals(2,queue.getSize());
    }


    @Test
    public void testMethodParent() throws Exception{
        queue.insert(i1);
        queue.insert(i3);
        queue.insert(new Node<Double,Double>(new Double(1),new Double(1)));
        queue.insert(new Node<Double,Double>(new Double(9),new Double(9)));
        queue.insert(new Node<Double,Double>(new Double(19),new Double(19)));
        queue.insert(new Node<Double,Double>(new Double(29),new Double(29)));
        queue.insert(new Node<Double,Double>(new Double(15),new Double(15)));
        queue.insert(new Node<Double,Double>(new Double(10),new Double(10)));
        queue.insert(new Node<Double,Double>(new Double(11),new Double(11)));

        assertEquals(queue.getParent(1),queue.getParent(2));
    }

    @Test
    public void testStructureWithHepifyAndInsert() throws Exception{
        PriorityQueue<Double,Double> que = queue;
        queue.insert(i1);
        queue.insert(i3);
        queue.insert(new Node<Double,Double>(new Double(1),new Double(1)));
        queue.insert(new Node<Double,Double>(new Double(9),new Double(9)));
        queue.insert(new Node<Double,Double>(new Double(19),new Double(19)));
        queue.insert(new Node<Double,Double>(new Double(29),new Double(29)));
        queue.insert(new Node<Double,Double>(new Double(15),new Double(15)));
        queue.insert(new Node<Double,Double>(new Double(10),new Double(10)));
        queue.insert(new Node<Double,Double>(new Double(11),new Double(11)));
        que.insert(new Node<Double,Double>(new Double(29),new Double(29)));
        que.insert(new Node<Double,Double>(new Double(1),new Double(11)));
        que.insert(new Node<Double,Double>(new Double(2),new Double(19)));
        que.insert(new Node<Double,Double>(new Double(3),new Double(10)));
        que.insert(new Node<Double,Double>(new Double(4),new Double(4)));
        que.insert(new Node<Double,Double>(new Double(1),new Double(1)));
        que.insert(new Node<Double,Double>(new Double(15),new Double(15)));
        que.insert(new Node<Double,Double>(new Double(2),new Double(2)));
        que.insert(new Node<Double,Double>(new Double(9),new Double(9)));

        assertEquals(que.getPriorityQueue(),queue.getPriorityQueue());

    }

    @Test
    public void testGetMaximum() throws Exception{
        queue.insert(i1);
        queue.insert(i3);
        queue.insert(new Node<Double,Double>(new Double(1),new Double(1)));
        queue.insert(new Node<Double,Double>(new Double(9),new Double(9)));
        queue.insert(new Node<Double,Double>(new Double(19),new Double(19)));
        queue.insert(new Node<Double,Double>(new Double(29),new Double(29)));
        queue.insert(new Node<Double,Double>(new Double(15),new Double(15)));
        queue.insert(new Node<Double,Double>(new Double(10),new Double(10)));
        queue.insert(new Node<Double,Double>(new Double(11),new Double(11)));

        assertEquals(queue.getElement(0).getElement(),queue.getMinimumElement().getElement());
    }

    @Test
    public void testChangeKey() throws Exception{
        queue.insert(i1);
        queue.insert(i3);
        queue.insert(new Node<Double,Double>(new Double(1),new Double(1)));
        queue.insert(new Node<Double,Double>(new Double(9),new Double(9)));
        queue.insert(new Node<Double,Double>(new Double(19),new Double(19)));
        queue.insert(new Node<Double,Double>(new Double(29),new Double(29)));
        queue.insert(new Node<Double,Double>(new Double(15),new Double(15)));
        queue.insert(new Node<Double,Double>(new Double(10),new Double(10)));
        queue.insert(new Node<Double,Double>(new Double(11),new Double(11)));
        queue.changeKey(i1,new Double(7));

        assertEquals(new Double(7),queue.getElement(2).getElement());

        queue.changeKey(i3,new Double(100));

        assertEquals(new Double(100),queue.getElement(1).getElement());
    }

    @Test
    public void testChangePriority() throws Exception{
        queue.insert(i1);
        queue.insert(i3);
        queue.insert(new Node<Double,Double>(new Double(1),new Double(1)));
        queue.insert(new Node<Double,Double>(new Double(9),new Double(9)));
        queue.insert(new Node<Double,Double>(new Double(21),new Double(21)));
        queue.insert(new Node<Double,Double>(new Double(29),new Double(29)));
        queue.insert(new Node<Double,Double>(new Double(15),new Double(15)));
        queue.insert(new Node<Double,Double>(new Double(10),new Double(10)));
        queue.insert(new Node<Double,Double>(new Double(11),new Double(11)));
        queue.changePriority(i3,new Double(100));

        assertEquals(new Double(100),queue.getElement(7).getPriority());

        queue.changePriority(i1,new Double(0.95));

        assertEquals(new Double(0.95),queue.getElement(0).getPriority());
        assertEquals(new Double(2),queue.getElement(0).getElement());
    }
}