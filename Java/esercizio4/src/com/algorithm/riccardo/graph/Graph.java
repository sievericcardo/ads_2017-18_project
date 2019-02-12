/**
 *  Graph file containing the declaration of the methods that are to implemented in Directed and Unidirected Graphs.
 *  Since we will create both directed and undirected graph we need to declare a set of methods that need to be
 *  implemented in subclasses. As such, the Graph Class will be defined as abstract.
 *
 *  @author Riccardo Sieve
 * 
 *  @param <V>: generic Vertex of the Graph
 *  @param <E>: generic Edge of the Graph
 */

package com.algorithm.riccardo.graph;

import java.util.HashMap;
import java.util.Set;

public abstract class Graph<V,E> {

    // Getter
    public abstract Set<Vertex<V>> getVertices(); // Get all vertices
    public abstract Set<Vertex<V>> getNeighbours(Vertex<V> vertex); // Get all neighbours for a given vertex
    public abstract Double getWeight(Vertex<V> sourceVertex, Vertex<V> destinationVertex) throws Exception;
    public abstract int getNumberVertices();
    public abstract HashMap<Vertex<V>, Double> getEdge(Vertex<V> vertex) throws Exception;
    public abstract int getNumberEdges() throws Exception;
    public abstract Double getTotalWeight() throws Exception;

    public abstract void addVertex(Vertex<V> vertex) throws Exception;
    public abstract boolean vertexExists(Vertex<V> vertex) throws Exception;
    public abstract boolean addEdge(Vertex<V> sourceVertex, Vertex<V> destinationVertex, Double weight) throws Exception;
    public abstract boolean emptyGraph(); // true if graph is empty
}
