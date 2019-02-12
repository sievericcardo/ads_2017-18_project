/**
 *  Code for the creation of the Undirected Graph (it extends the Graph Class).
 *  The structure of the undirected graph will be used for the prim algorithm.
 *
 *  @author Riccardo Sieve
 * 
 *  @param <V>: generic Vertex of the Graph
 *  @param <E>: generic Edge of the Graph
 */
package com.algorithm.riccardo.graph;

import java.util.HashMap;
import java.util.Set;

public class UndirectedGraph<V,E> extends Graph<V,E> {

    protected HashMap<Vertex<V>, HashMap<Vertex<V>, Double>> adjacencyList;
    protected HashMap<V, Vertex<V>> vertices;

    public UndirectedGraph() {
        this.adjacencyList = new HashMap<Vertex<V>, HashMap<Vertex<V>, Double>>();
        this.vertices = new HashMap<V, Vertex<V>>();
    }

    /**
     *  @return the first vertex of the graph
     */
    public Vertex<V> getFirstVertex() {
        return adjacencyList.keySet().iterator().next();
    }

    /**
     *  @param string: string passed for which we want to get the vertex
     *  @return the wanted vertex
     */
    public Vertex<V> getVertex(String string) {
        return vertices.get(string);
    }

    /**
     *  @return the set containing all the vertices of the graph
     */
    @Override
    public Set<Vertex<V>> getVertices() {
        return adjacencyList.keySet();
    }

    /**
     *  @param vertex: vertex iin which we want to lookup to its neighbours
     *  @return the set of all the vertices neighbours of vertex
     */
    @Override
    public Set<Vertex<V>> getNeighbours(Vertex<V> vertex) {
        Vertex<V> myVertex = vertices.get(vertex.getVertexName());
        return adjacencyList.get(myVertex).keySet();
    }

    /**
     *  @param sourceVertex: vertex in which we start the execution
     *  @param destinationVertex: target vertex
     *  @return the weight of the edge that insists between the two vertices
     *  @throws Exception
     */
    @Override
    public Double getWeight(Vertex<V> sourceVertex, Vertex<V> destinationVertex) throws Exception {
        if(!vertexExists(sourceVertex) || !vertexExists(destinationVertex))
            return 0.0;

        Vertex<V> source = vertices.get(sourceVertex.getVertexName());
        Vertex<V> destination = vertices.get(destinationVertex.getVertexName());

        return adjacencyList.get(source).get(destination);
    }

    /**
     *  @return total weight of the graph divided by two since it's undirected and all weight would be taken twice
     *  @throws Exception
     */
    @Override
    public Double getTotalWeight() throws Exception {
        Double totalWeight = 0.0;

        for(HashMap<Vertex<V>, Double> iterator : adjacencyList.values()) {
            for(Double weight: iterator.values()) {
                totalWeight += weight;
            }
        }

        return totalWeight / 2;
    }

    /**
     *  @return the total number of vertices
     */
    @Override
    public int getNumberVertices() {
        return adjacencyList.keySet().size();
    }

    /**
     *  @param vertex: vertex in which we lookup
     *  @return return the hashmap of the adjacent vertices of "vertex"
     *  @throws Exception
     */
    @Override
    public HashMap<Vertex<V>, Double> getEdge(Vertex<V> vertex) throws Exception {
        if(!vertexExists(vertex))
            throw new Exception("The given vertex does not exist");

        Vertex<V> myVertex = vertices.get(vertex.getVertexName());

        return this.adjacencyList.get(myVertex);
    }

    /**
     *  @return the total number of edges divided by two since all vertices would be counted twice in undirected graphs
     *  @throws Exception
     */
    @Override
    public int getNumberEdges() throws Exception {
        if(emptyGraph())
            throw new Exception("Empty graph");

        int count = 0;
        for (Vertex<V> vertex: getVertices()) {
            for(Vertex<V> neighbour: getNeighbours(vertex)) {
                count++;
            }
        }

        return count / 2;
    }

    /**
     *  @param vertex: vertex to be checked
     *  @return true if the vertex is in the map
     *  @throws Exception
     */
    @Override
    public boolean vertexExists(Vertex<V> vertex) throws Exception {
        return vertices.containsKey(vertex.getVertexName());
    }

    /**
     *  @param vertex: vertex to be added to the graph
     *  @throws Exception
     */
    @Override
    public void addVertex(Vertex<V> vertex) throws Exception {
        if(vertexExists(vertex))
            return;
        this.adjacencyList.put(vertex, new HashMap<Vertex<V>, Double>());
        this.vertices.put(vertex.getVertexName(), vertex);
    }

    /**
     *  @param sourceVertex: source vertex in which insists an edge
     *  @param destinationVertex: target vertex of the edge
     *  @param weight: double value corresponding to the weight of the edge
     *  @return true if the two vertices did not exists in the graph and the two corresponding edges have been created
     *  @throws Exception
     */
    @Override
    public boolean addEdge(Vertex<V> sourceVertex, Vertex<V> destinationVertex, Double weight) throws Exception {
        if(!vertexExists(sourceVertex) || !vertexExists(destinationVertex))
            return false;
        Vertex<V> source = vertices.get(sourceVertex.getVertexName());
        Vertex<V> destination = vertices.get(destinationVertex.getVertexName());

        adjacencyList.get(source).put(destination, weight);
        adjacencyList.get(destination).put(source, weight);

        return true;
    }

    /**
     *  @return true if the graph is empty
     */
    @Override
    public boolean emptyGraph() {
        return this.adjacencyList.isEmpty();
    }

    @Override
    public String toString() {
        String string = "";

        for(Vertex<V> vertex: getVertices()) {
            string += vertex.toString() + ": ";

            for(Vertex<V> myVertex: getNeighbours(vertex)) {
                string += "(" + myVertex.getVertexName().toString() + ", " + myVertex.getVertexName().toString() + ")";
            }

            string += "\n";
        }

        return string;
    }
}
