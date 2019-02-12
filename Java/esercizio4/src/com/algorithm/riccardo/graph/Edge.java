/**
 * Edge Class. An edge is the connection between two vertices of the same graph. Right now we won't make any assumption
 * of the graph type and we will create the edges weighted with the weight as a double.
 *
 * @author Riccardo
 * 
 */

package com.algorithm.riccardo.graph;

public class Edge {

    private double weight;

    public Edge(double weight) {
        this.weight = weight;
    }

    // Getter
    public double getWeight() { return weight; }
}
