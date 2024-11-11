/*
Author: Ghailan Fadah
Course: 231
class: Graph
Date: 12/12/21
Description: creates a vertex for a graph  
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javax.management.Query;

public class Graph {

    // fields for class
    private ArrayList<Vertex> listVer;

    // constructor
    public Graph() {

        this.listVer = new ArrayList<Vertex>();

    }

    // returns an arrayList of all the vertices in the graph
    public ArrayList<Vertex> getVertices() {
        return this.listVer;
    }

    // returns the number of vertices in the graph
    public int vertexCount() {
        return listVer.size();
    }

    // checks to see if a vertex in the graph
    public boolean inGraph(Vertex query) {

        // loops over all the vertices in the list
        for (Vertex v : listVer) {

            // if the two vertices are equal return true
            if (v.equals(query) == true) {
                return true;
            }
        }

        // else return false
        return false;
    }

    // adds an edge between two vertices: one way
    public void addUniEdge(Vertex v1, Vertex v2) {

        // if both are not in the graph add both
        if (!inGraph(v1) && !inGraph(v2)) {
            listVer.add(v1);
            listVer.add(v2);

            // if v2 is not in the graph add it
        } else if (inGraph(v1) && !inGraph(v2)) {
            listVer.add(v2);

            // if v1 is not in the grpah add it
        } else if (!inGraph(v1) && inGraph(v2)) {
            listVer.add(v1);
        }

        // call the connect method for v1 and connect it to v2
        v1.connect(v2);

    }

    // adds an edge between two vertices: two way
    public void addBiEdge(Vertex v1, Vertex v2) {

        // if both are not in the graph add both
        if (!inGraph(v1) && !inGraph(v2)) {
            listVer.add(v1);
            listVer.add(v2);

            // if v2 is not in the graph add it
        } else if (inGraph(v1) && !inGraph(v2)) {
            listVer.add(v2);

            // if v1 is not in the graph add it
        } else if (!inGraph(v1) && inGraph(v2)) {
            listVer.add(v1);
        }

        // calls the connect method and connects both vertices in both ways
        v1.connect(v2);
        v2.connect(v1);
    }

    // implends Dijkstra's Algorithm
    public void shortestPath(Vertex v0) {

        // loops over all the vertices and
        // Initialize all vertices in G to be unmarked, have a large cost, and a null
        // parent
        for (Vertex v : this.listVer) {
            v.setMark(false);
            v.setParent(null);
            v.setDistance(Double.MAX_VALUE);
        }

        // Create a priority queue, pq, to hold objects of type Vertex
        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();

        // Set the cost of v0 to 0 and add it to pq
        v0.setDistance(0.0);
        pq.add(v0);

        // while loop
        while (!pq.isEmpty()) {

            // remove v from pq where v is the vertex with lowest cost
            Vertex v = pq.poll();

            // if v is already marked as visited, continue
            if (v.getMark()) {
                continue;
            }

            // mark v as visited
            v.setMark(true);

            /*
             * for each vertex w that neighbors v:
             * compute the distance between v and w
             * if w is not marked and v.cost + distance < w.cost:
             * w.cost = v.cost + distance
             * make v the parent of w
             * add w to pq
             */

            for (Vertex w : v.getNeighbors()) {

                double dis = v.distance(w);

                if (!w.getMark() && (v.getDistance() + dis) < w.getDistance()) {
                    w.setDistance(v.getDistance() + dis);
                    w.setParent(v);
                    pq.add(w);
                }
            }

        }
    }

    public void depthSearch(Vertex start){
        Stack<Vertex> stack = new Stack<Vertex>();
        Set<Vertex> visited = new HashSet<Vertex>();

        stack.push(start);

        while(!stack.isEmpty()){
            Vertex current = stack.pop();

            if(!visited.contains(current)){
                visited.add(current);
                System.out.println(current);
            }

            for(Vertex adj : current.getNeighbors()){
                if(!visited.contains(adj)){
                    stack.push(adj);
                }
            }
        }
    }

    public void breadthSearch(Vertex start){
       MyQueue<Vertex> q = new MyQueue<Vertex>();
       Set<Vertex> visited = new HashSet<Vertex>();

       q.offer(start);

        while(!q.isEmpty()){
            Vertex current = q.poll();

            if(!visited.contains(current)){
                visited.add(current);
                System.out.println(current);
            }

            for(Vertex adj : current.getNeighbors()){
                if(!visited.contains(adj)){
                    q.offer(adj);
                }
            }
        }
    }

    // testing area
    public static void main(String[] args) {

        Vertex ver1 = new Vertex(0, 0, true, true, 5, null);
        Vertex ver2 = new Vertex(2, 10, true, true, 8, null);
        Vertex ver3 = new Vertex(4, 8, true, true, 10, null);
        Vertex ver4 = new Vertex(6, 6, true, true, 23, null);
        Vertex ver5 = new Vertex(8, 4, true, true, 2, null);
        Vertex ver6 = new Vertex(10, 2, true, true, 1, null);

        Graph g = new Graph();

        g.addUniEdge(ver1, ver2);
        g.addUniEdge(ver1, ver3);
        g.addUniEdge(ver1, ver4);
        g.addUniEdge(ver1, ver5);
        g.addUniEdge(ver1, ver6);

        g.addUniEdge(ver2, ver3);
        g.addUniEdge(ver2, ver4);
        g.addUniEdge(ver2, ver5);
        g.addUniEdge(ver2, ver6);

        g.addUniEdge(ver3, ver4);
        g.addUniEdge(ver3, ver5);
        g.addUniEdge(ver3, ver6);

        g.addUniEdge(ver4, ver5);
        g.addUniEdge(ver4, ver6);

        g.addUniEdge(ver5, ver6);

        System.out.println(g.listVer);

        g.shortestPath(ver1);

        System.out.println(g.listVer);

    }

}
