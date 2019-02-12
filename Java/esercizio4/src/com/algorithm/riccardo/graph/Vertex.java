/**
 * Vertex Class. Every Vertex of the Graph will contain a name. The name can be of whatever type since it is defined
 * as type T.
 * We then have a boolean flag visitedVertex to check whether or not we already visited the Vertex, the node to the
 * previous vertex and the List of adjacent edges.
 *
 * @author Riccardo
 * @version 2.0
 * @param <T>: generic Vertex of the Graph
 */

package com.algorithm.riccardo.graph;

public class Vertex<T> {

    private T vertexName;
    private double key;
    private Vertex<T> previousVertex;

    public Vertex(T vertexName) {
        this.vertexName = vertexName;
    }

    // Setters
    public void setPreviousVertex (Vertex<T> previousVertex) { this.previousVertex = previousVertex; }
    public void setKey (double key) { this.key = key; }

    // Getters
    public T getVertexName() { return this.vertexName; }
    public Vertex<T> getPreviousVertex() { return this.previousVertex; }
    public double getKey() { return this.key; }

    @Override
    public String toString() { return getVertexName() + ""; }
}
