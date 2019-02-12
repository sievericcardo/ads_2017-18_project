/**
 *  Code for the creation of the Directed Graph (it extends the Graph Class)
 *
 *  @author Riccardo Sieve
 * 
 *  @param <V>: generic Vertex of the Graph
 *  @param <E>: generic Edge of the Graph
 */
package com.algorithm.riccardo.graph;

import java.util.HashMap;
import java.util.Set;

public class DirectedGraph<V,E> extends Graph<V,E> {

    // I create the adj list as a hashmap with hashmap as key
    protected HashMap<Vertex<V>, HashMap<Vertex<V>, Double>> adjacencyList;
    protected HashMap<V, Vertex<V>> vertices;

    public DirectedGraph() {
        this.adjacencyList = new HashMap<Vertex<V>, HashMap<Vertex<V>, Double>>();
        this.vertices = new HashMap<V, Vertex<V>>();
    }

    /**
     *  @return the virst vertex of the graph
     */
    public Vertex<V> getFirstVertex() {
        return adjacencyList.keySet().iterator().next();
    }

    /**
     * @param string: String that will be used to get the element (we use hashmap with O(1) in lookup)
     * @return the Vertex corresponding to s
     */
    public Vertex<V> getVertex(String string) {
        return vertices.get(string);
    }

    /**
     *  @return the set with all the vertices of the graph
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
     *  @return total weight of the graph
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

        return totalWeight;
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
     *  @return the total number of edges
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

        return count;
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
     *  @return true if the two vertices did not exists in the graph
     *  @throws Exception
     */
    @Override
    public boolean addEdge(Vertex<V> sourceVertex, Vertex<V> destinationVertex, Double weight) throws Exception {
        if(!vertexExists(sourceVertex) || !vertexExists(destinationVertex))
            return false;
        Vertex<V> source = vertices.get(sourceVertex.getVertexName());
        Vertex<V> destination = vertices.get(destinationVertex.getVertexName());

        adjacencyList.get(source).put(destination, weight);

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
