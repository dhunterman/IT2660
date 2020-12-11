import java.io.*;
import java.util.*;
import java.util.Scanner;


class Graph {
    private int V; //number of vertices (aka nodes)
    private int E; //number of edges (aka connections)
    private Integer[] travelled;
    private Integer[] dist;
    private Set<Integer> known;

    private LinkedList<Integer> NL[]; //Node list with node connections
    private LinkedList<Integer> WL[]; //weights list of edges

    private boolean vis[]; //visited? boolean array. True if node has been visited

    public Graph(int V, int E) {

        this.V = V;
        this.E = E;
        NL = new LinkedList[V];
        WL = new LinkedList[V];
        vis = new boolean[V];
        travelled = new Integer[V];
        dist = new Integer[V];
        known = new HashSet<Integer>();

        for(int i = 0; i < V; i++) {
            NL[i] = new LinkedList<Integer>();
            WL[i] = new LinkedList<Integer>();
        }
    }

    public void addEdgesAndWeights(int v1, int v2,int size,int weight) {
        //undirected graph
        //limit number of node connections to "size"
        if (v1!=v2) {
            if (!NL[v2].contains(v1)&&NL[v2].size()<size) {
                NL[v2].add(v1);
                WL[v2].add(weight);
            }
            if (!NL[v1].contains(v2)&&NL[v1].size()<size) {
                NL[v1].add(v2);
                WL[v1].add(weight);
            }
        }
    }

    public boolean containsEdge(int v1, int v2) {
        if(NL[v1].contains(v2)) {
            return true;
        } else {
            return false;
        }
    }

    public void clearVis() {
        for(int i = 0; i < V; i++) {
            vis[i] = false;
        }
    }

    public void clearDist() {
        for(int i = 0; i < V; i++) {
            dist[i] = 0;
        }
    }

    public void clearTrav() {
        for (int i = 0; i < V; i++) {
            travelled[i] = -1;
        }
    }

    public boolean basicSearch(int v1) {


        if (v1 <= V) {
            if (!NL[v1].isEmpty()) {
                System.out.println("Node " + v1 + " found. Node " + v1 + " contains " + NL[v1].size() + " nodes.");
                return true;
            } else {
                System.out.println("Node " + v1 + " not found. ");
                return false;
            }
        } else {
            System.out.println("Node " + v1 + " not found. ");
            return false;
        }
    }

    public void printVE () {
        for (int i = 0; i < V; i++) {
            System.out.print("Node " + i + " has " + NL[i].size() + " connections and is connected " +
                    "to the following nodes and (weights):");
            for (int m = 0; m < NL[i].size(); m++) {
                if(m<NL[i].size()) {
                    if(m<NL[i].size() - 1) {
                        System.out.print(NL[i].get(m) +" (" + WL[i].get(m) + "), ");
                    } else {
                        System.out.print(NL[i].get(m) + " (" + WL[i].get(m) + ")");
                    }
                }
            }
            System.out.println("");
        }
    }

    public boolean areAllVisited (boolean[] array) {
        for (boolean b : array) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public int howFull (Integer[] hf) {
        int z = 0;
        for (int i = 0; i < hf.length; i++) {
            if (hf[i] != null) {
                z++;
            }
        }
        return z;

    }

    public int firstUnvisitedChild(int node) {
        //returns position of the first unvisited child of parent node
        for (int i = 0; i < NL[node].size() - 1; i++) {
            if (!vis[NL[node].get(i)]) {
                return i;
            }
        }
        return -1;
    }

    public void BFS(int start, int search) {
        int n = 0;
        int count  = 0;
        int s1 = 0;
        clearVis(); //indicate that no vertices have been visited by making all vis[] booleans false
        clearDist(); //reset the distance array for calculating min distances from start to search
        clearTrav(); //reset the travelled array for creating shortest path from start to search
        Deque<Integer> queue = new ArrayDeque<>(V);

        queue.offer(start);
        vis[start] = true;

        while (!queue.isEmpty()) {
            //queue will not be empty until the search term is found or all search paths have been exhausted
            int node = queue.poll(); //extracts the "parent" node from the queue

            //loop through all edges of the node

            for (int i = 0; i < NL[node].size(); i++) {
                //System.out.println("parent node: " + node + ", child node: " + edges[n].get(i) + ", node child # "
                // + i + ", visited list size: " + prev.size());
                if (!vis[NL[node].get(i)]) { //if node has not been visited yet
                    vis[NL[node].get(i)] = true; //mark the node as visited
                    travelled[NL[node].get(i)] = node; //add the node to the travelled array to help calculate shortest path
                    dist[NL[node].get(i)] = dist[node] + 1;
                    queue.offer(NL[node].get(i));
                    count++;
                }
                if (NL[node].get(i) == search) { //if the search node is found
                    System.out.println("Node " + search + " found!");
                    System.out.println("Total nodes examined when searching from " + start + " to " + search +
                            " is " + count + ".");
                    return;
                }

            }
            if (areAllVisited(vis)) {
                System.out.println("Node " + search + " cannot be found from start position of " + start + ".");
                System.out.println("Total nodes examined during the search is " + count + ".");
            }

        }
    }

    public void DFS(int start, int search) {
        int count  = 0;
        clearVis(); //indicate that no vertices have been visited by making all vis[] booleans false
        clearDist(); //reset the distance array for calculating min distances from start to search
        clearTrav(); //reset the travelled array for creating shortest path from start to search
        Deque<Integer> queue = new ArrayDeque<>(V);

        queue.offer(start);
        vis[start] = true;
        count++;

        while (!queue.isEmpty()) {
            //queue will not be empty until the search term is found or all search paths have been exhausted
            //System.out.println("Queue peek 1 " + queue.peek());
            int node = queue.poll(); //extracts the "parent" node from the queue
            vis[node] = true;

            while (firstUnvisitedChild(node)!=-1) { //if the node has an unvisited child, visit the child
                //System.out.println("parent node is " + node + " and child node is " + NL[node].get(firstUnvisitedChild(node)));
                //System.out.println("Queue peek 2 " + queue.peek());

                int firstUC = NL[node].get(firstUnvisitedChild(node));
                //System.out.println("Child node is " + firstUC + ", and fUC function returns " + firstUnvisitedChild(node));
                if (firstUC == search) { //if the search node is found
                    System.out.println("Node " + search + " found!");
                    System.out.println("Total nodes examined when searching from " + start + " to " + search +
                           " is " + count + ".");
                    return;
                }

                vis[firstUC] = true; //mark child node as visited
                travelled[node] = firstUC; //add the child node to the travelled array of the parent node
                dist[firstUC] = dist[node] + 1; //add one to distance travelled
                //System.out.println("Queue peek 3 " + queue.peek());
                queue.offer(firstUC); //add child node to queue
                //System.out.println("Queue peek 4 " + queue.peek());
                node = firstUC; //make the child node the parent
                count++;

            }

            if (areAllVisited(vis) | queue.isEmpty()) {
                System.out.println("Node " + search + " cannot be found from start position of " + start + ".");
                System.out.println("Total nodes examined during the search is " + count + ".");
            }


        }
    }

    public void shortPathDistBFS(int start, int search) {
        // prev array stores the previous node of int iterator i and distance array stores distance between i and start
        // LinkedList to store path
        LinkedList<Integer> path = new LinkedList<Integer>();
        int node = search;
        path.add(node);
        while (travelled[node] != -1) {
            path.add(travelled[node]);
            node = travelled[node];
        }
        // Print distance
        System.out.println("Shortest path length is: " + (dist[search]+1));
        // Print path
        System.out.print("Path is : ");
        for (int i = path.size() -1 ; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println(" ");
    }

    public void searchDijkstra(int start, int search) {
        clearVis(); //use as known boolean array
        clearDist(); //use as distances integer array
        clearTrav(); //use as path
        PriorityQueue<Node> queueD = new PriorityQueue<Node>(V,new Node());
        queueD.add(new Node(start, 0));
        int count = 0;
        for (int i = 0; i<dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        //find adjacent nodes, and update distances from start node
        while (known.size() != V) {
            int node = queueD.remove().node;
            //System.out.println("Node is " + node + " and known weight is " + WL[node]);
            known.add(node);

            int adjWeight = -1;
            int ND = -1;
            int ED = -1;
            for (int i = 0; i < NL[node].size(); i++) {
                Node adj = new Node(NL[node].get(i), WL[node].get(i));

                if(!known.contains(adj.node)) {
                    ED = adj.weight;
                    ND = dist[node] + ED;

                    if (ND < dist[adj.node]) {
                        dist[adj.node] = ND;
                    }

                    queueD.add(adj);

                }
            }
        }
        if (dist[search] > 2142483647) {

            System.out.println("There is no path available from node " + start + " to node " + search + ".");
        } else {
            System.out.println("The shortest path from node " + start + " to node " + search + " is " + dist[search] + ".");
        }

    }

    class Node implements Comparator<Node> {
        public int node;
        public int weight;

        public Node()
        {
        }

        public Node(int node, int weight)
        {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compare(Node node1, Node node2)
        {
            if (node1.weight < node2.weight)
                return -1;
            if (node1.weight > node2.weight)
                return 1;
            return 0;
        }
    }
}