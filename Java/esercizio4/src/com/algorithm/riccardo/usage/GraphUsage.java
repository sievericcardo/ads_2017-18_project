/**
 *  Usage file for the Prim Algorithm. It gets the Dataset containing all the Nodes and weights and perform the Prim
 *  Algorithm over it
 *
 *  @author Riccardo Sieve
 *  @version 2.0
 */
package com.algorithm.riccardo.usage;

import com.algorithm.riccardo.graph.*;
import com.algorithm.riccardo.prim.*;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GraphUsage {

    public static final Charset ENCODING = StandardCharsets.UTF_8;

    public static void main (String args[]) {

        Prim<String> prim = new Prim<>();

        Path inputFilePath = Paths.get("/Users/riccardo/Documents/Università/Progetti/datasets/italian_dist_graph.csv");

        System.out.println("Starting simulation");

        // Interleaving space to differentiate between the two parts
        System.out.println("-----------------------------------------");

        try(BufferedReader reader = Files.newBufferedReader(inputFilePath, ENCODING)) {
            String line = null;

            while((line = reader.readLine()) != null) {
                String[] temp = line.split(",");
                Vertex<String> sourceVertex = new Vertex<>(temp[0]);
                Vertex<String> destinationVertex = new Vertex<>(temp[1]);
                Double weight = new Double(temp[2]);

                try {
                    prim.addVertex(sourceVertex);
                    prim.addVertex(destinationVertex);
                    prim.addEdge(sourceVertex, destinationVertex, weight);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Number of vertices in the Graph: " + prim.getNumberVertices());
            System.out.println("Number of undirected edges: " + prim.getNumberEdges());
            System.out.println("");
            System.out.printf("Total Weight: %.3f km\n", prim.getTotalWeight());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Interleaving space to differentiate between the two parts
        System.out.println("-----------------------------------------");

        try {
            UndirectedGraph<String, Double> forest = prim.minimumSpanningTree(prim.getFirstVertex());

            System.out.println("Number of vertices in the forest: " + forest.getNumberVertices());
            System.out.println("Number of undirected edges: " + forest.getNumberEdges());
            System.out.println("");
            System.out.printf("Total Weight: %.3f km\n", forest.getTotalWeight()/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Interleaving space to differentiate between the two parts
        System.out.println("-----------------------------------------");
        System.out.println("End of the simulation");
        System.out.println("-----------------------------------------");
    }
}
