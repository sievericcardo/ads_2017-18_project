/**
 *  Prim Class for the Prim Algorithm.
 *  We parse every vertex of the graph and we check every weight associated with them. For every iteration we take
 *  the vertex whose weight is the minimum and insert it into a spanning tree.
 *  To do this we make use fo the PriorityQueue structure since it has complexity time of O(lg n).
 *
 *  Note that the following one is the greedy implementation of the Prim Algorithm, therefore it may not find the
 *  optimal solution.
 *
 *
 * @author Riccardo
 * 
 */

package com.algorithm.riccardo.prim;


import com.algorithm.riccardo.graph.*; // Importing the structures
import com.algorithm.riccardo.priorityqueue.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class Prim<V> extends UndirectedGraph<V,Double> {

    class PriorityQueueComparator implements Comparator<Double> {

        @Override
        public int compare(Double element1, Double element2) {
            return element1.compareTo(element2);
        }
    }

    public Prim() {
        super();
    }

    /**
     *  @param sourceVertex: initial vertex in which we start iterating
     *  @return the minimum spanning tree corresponding
     *  @throws Exception
     */
    public UndirectedGraph<V,Double> minimumSpanningTree(Vertex<V> sourceVertex) throws Exception {
        return prim(sourceVertex);
    }

    public UndirectedGraph<V,Double> prim(Vertex<V> sourceVertex) throws Exception {
        Map<Vertex<V>, Node<Vertex<V>, Double>> map = new HashMap<>();
        UndirectedGraph<V, Double> forest = new UndirectedGraph<>();
        PriorityQueue<Vertex<V>, Double> priorityQueue = new PriorityQueue<Vertex<V>, Double>(new PriorityQueueComparator());

        for(Vertex<V> vertex: getVertices()) {
            vertex.setKey(Double.POSITIVE_INFINITY);
            vertex.setPreviousVertex(null);
        }

        sourceVertex.setKey(0);

        for(Vertex<V> vertex: getVertices()) {
            Node<Vertex<V>, Double> node = new Node<Vertex<V>, Double>(vertex, vertex.getKey());
            map.put(vertex, node);
            priorityQueue.insert(node);
        }

        while(!priorityQueue.isEmpty()) {
            Vertex<V> minimumVertex = priorityQueue.remove().getElement();

            forest.addVertex(minimumVertex);

            if(minimumVertex.getPreviousVertex() != null) {
                forest.addEdge(minimumVertex.getPreviousVertex(),
                               minimumVertex,
                               getWeight(minimumVertex.getPreviousVertex(), minimumVertex));
            }

            for(Vertex<V> vertex: getNeighbours(minimumVertex)) {
                if(priorityQueue.contains(map.get(vertex))) {
                    if(vertex.getKey() > getWeight(minimumVertex, vertex)) {
                        vertex.setKey(getWeight(minimumVertex, vertex));
                        vertex.setPreviousVertex(minimumVertex);

                        priorityQueue.changePriority(map.get(vertex), getWeight(minimumVertex, vertex));
                    }
                }
            }
        }

        return forest;
    }
}
