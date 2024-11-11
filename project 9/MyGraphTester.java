/*
Author: Ghailan Fadah
Course: 231
class: MyGraphTester
Date: 12/12/21
Description: creates a graph and runs shortest path on it 
*/

import java.util.ArrayList;

public class MyGraphTester {

    // test the graph using 10 connected vertices
    public void test1() {

        // make the vertices
        Vertex v0 = new Vertex(6, 6, false);
        Vertex v1 = new Vertex(8, 4, false);
        Vertex v2 = new Vertex(7, 2, false);
        Vertex v3 = new Vertex(5, 2, false);
        Vertex v4 = new Vertex(4, 4, false);
        Vertex v5 = new Vertex(6, 5, false);
        Vertex v6 = new Vertex(7, 4, false);
        Vertex v7 = new Vertex(7, 3, false);
        Vertex v8 = new Vertex(5, 3, false);
        Vertex v9 = new Vertex(5, 4, false);

        // build the graph
        Graph g = new Graph();

        g.addBiEdge(v0, v1);
        g.addBiEdge(v0, v4);
        g.addBiEdge(v0, v5);
        g.addBiEdge(v1, v6);
        g.addBiEdge(v1, v2);
        g.addBiEdge(v2, v7);
        g.addBiEdge(v2, v3);
        g.addBiEdge(v3, v8);
        g.addBiEdge(v3, v4);
        g.addBiEdge(v4, v9);
        g.addBiEdge(v5, v8);
        g.addBiEdge(v5, v7);
        g.addBiEdge(v6, v8);
        g.addBiEdge(v6, v9);
        g.addBiEdge(v7, v9);
       
        

        // print out before shortestPath
        ArrayList<Vertex> set = g.getVertices();

        System.out.println("Before shortestPath");
        for (Vertex v : set) {
            System.out.println(v);
        }

        // run shortest path from node (6, 6)
        g.shortestPath(v0);

        // print out after shortest path
        System.out.println("\nAfter shortestPath");
        for (Vertex v : set) {
            System.out.println(v);
        }

        // print out what the values should be
        System.out.println("Cost for node (6,6) should be: 0.0");
        System.out.println("Cost for node (8,4) should be: 2.8");
        System.out.println("Cost for node (4,4) should be: 2.8");
        System.out.println("Cost for node (6,5) should be: 1");
        System.out.println("Cost for node (7,4) should be: 3.8");
        System.out.println("Cost for node (7,2) should be: 4.2");
        System.out.println("Cost for node (7,3) should be: 3.2");
        System.out.println("Cost for node (7,4) should be: 3.8");
        System.out.println("Cost for node (5,2) should be: 4.2");
        System.out.println("Cost for node (5,3) should be: 3.2");
        System.out.println("Cost for node (5,4) should be: 3.8");



    }

    // test a graph with 10 connected vertices
    public void test2() {

        // make the vertices
        Vertex v0 = new Vertex(6, 6, false);
        Vertex v1 = new Vertex(8, 4, false);
        Vertex v2 = new Vertex(7, 2, false);
        Vertex v3 = new Vertex(5, 2, false);
        Vertex v4 = new Vertex(4, 4, false);
        Vertex v5 = new Vertex(6, 5, false);
        Vertex v6 = new Vertex(7, 4, false);
        Vertex v7 = new Vertex(7, 3, false);
        Vertex v8 = new Vertex(5, 3, false);
        Vertex v9 = new Vertex(5, 4, false);

        // build the graph
        Graph g = new Graph();

        g.addBiEdge(v0, v1);
        g.addBiEdge(v0, v4);
        g.addBiEdge(v0, v5);
        g.addBiEdge(v1, v6);
        g.addBiEdge(v1, v2);
        g.addBiEdge(v2, v7);
        g.addBiEdge(v2, v3);
        g.addBiEdge(v3, v8);
        g.addBiEdge(v3, v4);
        g.addBiEdge(v4, v9);
        g.addBiEdge(v5, v8);
        g.addBiEdge(v5, v7);
        g.addBiEdge(v6, v8);
        g.addBiEdge(v6, v9);
        g.addBiEdge(v7, v9);
       
        

        // print out before shortestPath
        // ArrayList<Vertex> set = g.getVertices();

        // System.out.println("Before shortestPath");
        // for (Vertex v : set) {
        //     System.out.println(v);
        // }

        // run shortest path from node (6, 6)
        //g.shortestPath(v8);
        //g.breadthSearch(v0);
        g.depthSearch(v0);

        // print out after shortest path
        // System.out.println("\nAfter shortestPath");
        // for (Vertex v : set) {
        //     System.out.println(v);
        // }

        // // print out what the values should be
        // System.out.println("Cost for node (6,6) should be: 3.2");
        // System.out.println("Cost for node (8,4) should be: 3.2");
        // System.out.println("Cost for node (4,4) should be: 3.2");
        // System.out.println("Cost for node (6,5) should be: 2.2");
        // System.out.println("Cost for node (7,4) should be: 2.2");
        // System.out.println("Cost for node (7,2) should be: 3");
        // System.out.println("Cost for node (7,3) should be: 4");
        // System.out.println("Cost for node (7,4) should be: 3.8");
        // System.out.println("Cost for node (5,2) should be: 1");
        // System.out.println("Cost for node (5,3) should be: 0");
        // System.out.println("Cost for node (5,4) should be: 4.2");



    }



    // main method
    public static void main(String[] argv) {

        MyGraphTester gt = new MyGraphTester();

        //gt.test1();
        gt.test2();

    }

}
