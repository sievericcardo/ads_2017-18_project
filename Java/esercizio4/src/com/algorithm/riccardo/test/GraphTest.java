package com.algorithm.riccardo.test;

import com.algorithm.riccardo.graph.*;
import com.algorithm.riccardo.prim.*;
import com.algorithm.riccardo.priorityqueue.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GraphTest {

    static Vertex<Double> vertex1, vertex2, vertex3;
    static UndirectedGraph<Double, Double> undirectedGraph;
    static DirectedGraph<Double, Double> directedGraph;
    private Prim<Double> prim;

    @BeforeEach
    public void GraphTest() {
        vertex1 = new Vertex<Double>(new Double(5));
        vertex2 = new Vertex<Double>(new Double(10));
        vertex3 = new Vertex<Double>(new Double(15));

        undirectedGraph = new UndirectedGraph<Double, Double>();
        directedGraph = new DirectedGraph<Double, Double>();
        prim = new Prim<Double>();
    }

    @Test
    public void testIsEmpty() {
        assertTrue (undirectedGraph.emptyGraph());
        assertTrue (directedGraph.emptyGraph());
    }

    @Test
    public void testOneElement() throws Exception {
        undirectedGraph.addVertex(vertex1);
        undirectedGraph.addVertex(vertex2);
        undirectedGraph.addEdge(vertex1, vertex2, new Double(100));
        assertFalse(undirectedGraph.emptyGraph());

        directedGraph.addVertex(vertex1);
        directedGraph.addVertex(vertex2);
        directedGraph.addEdge(vertex1, vertex2, new Double(100));
        assertFalse(directedGraph.emptyGraph());
    }

    @Test
    public void testNumberVertices()throws Exception{
        undirectedGraph.addVertex(vertex1);
        undirectedGraph.addVertex(vertex2);
        undirectedGraph.addVertex(vertex3);
        assertTrue(3 == undirectedGraph.getNumberVertices());

        directedGraph.addVertex(vertex1);
        directedGraph.addVertex(vertex2);
        directedGraph.addVertex(vertex3);
        assertTrue(3 == directedGraph.getNumberVertices());
    }

    @Test
    public void testNumberEdges()throws Exception{
        undirectedGraph.addVertex(vertex1);
        undirectedGraph.addVertex(vertex2);
        undirectedGraph.addVertex(vertex3);
        undirectedGraph.addEdge(vertex1,vertex2,new Double(100));
        undirectedGraph.addEdge(vertex2,vertex3,new Double(150));
        assertTrue(2 == undirectedGraph.getNumberEdges());

        directedGraph.addVertex(vertex1);
        directedGraph.addVertex(vertex2);
        directedGraph.addVertex(vertex3);
        directedGraph.addEdge(vertex1,vertex2,new Double(100));
        directedGraph.addEdge(vertex2,vertex3,new Double(150));
        assertTrue(2 == directedGraph.getNumberEdges());
    }

    @Test
    public void testTotalWeight()throws Exception{
        undirectedGraph.addVertex(vertex1);
        undirectedGraph.addVertex(vertex2);
        undirectedGraph.addVertex(vertex3);
        undirectedGraph.addEdge(vertex1,vertex2,new Double(100));
        undirectedGraph.addEdge(vertex2,vertex3,new Double(150));
        assertTrue(2 == undirectedGraph.getNumberEdges());

        directedGraph.addVertex(vertex1);
        directedGraph.addVertex(vertex2);
        directedGraph.addVertex(vertex3);
        directedGraph.addEdge(vertex1,vertex2,new Double(100));
        directedGraph.addEdge(vertex2,vertex3,new Double(150));
        assertFalse(undirectedGraph.getTotalWeight() == directedGraph.getTotalWeight());
    }

    @Test
    public void testPrim()throws Exception{
        prim.addVertex(vertex1);
        prim.addVertex(vertex2);
        prim.addVertex(vertex3);
        prim.addEdge(vertex1,vertex2,new Double(100));
        prim.addEdge(vertex2,vertex3,new Double(150));
        prim.addEdge(vertex3,vertex1,new Double(200));
        undirectedGraph = prim.minimumSpanningTree(vertex1);
        assertTrue(250.00 == undirectedGraph.getTotalWeight());
    }
}
