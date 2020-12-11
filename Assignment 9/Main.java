import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {


    /*Assignment 9
    Hunter Browning-Smith
    ITC 2660
    Write a Java Program that does the following:

    Generate a graph with 1,000 nodes, where each node randomly has between 1 and 5 connections to other nodes.
    Each node should contain within it a random value such that generally (not precisely) 50% of searches will yield a query match.
    Allow the user to enter a number to search for, and implement each of the following three types of searching algorithms.
            Breadth-First. (30 points)
    Depth-First. (30 points)
    Dijkstra's Algorithm. (40 points)
            *Do not allow back-tracking in your searches. (Mark nodes that you already searched as complete, and do not re-visit them in the same search)

    Each search should return the following:

    The Success/Failure of your search.
    The length of the shortest path to the found node.
    The total number of nodes examined during the search.
    Optionally you may return the exhaustive display of the shortest path, for testing and verification.
    Also remember since your graph is created with random values, try re-creating it for different results.
    Note: Dijkstra's Algorithm will require augmentation of the graph to include connection weights, which can also be completely random.

    Grading will be calculated by:

    The correctness of query results.
    The adherence to the algorithm definitions.
    And by code quality.*/

    public static void main(String args[]) {
        int V = 10;
        boolean op1 = true;
        Scanner input = new Scanner(System.in);
        Graph g = new Graph(V, 0);
        int rand, rand2, rand3, sel, search, start;
        sel = 0;

        for (int i = 0; i < V; i++) {
            rand2 = (int) (Math.random() * 5) + 1; //edges
            rand3 = (int) (Math.random() * 5) + 1; //weights

            for (int m = 0; m < rand2; m++) {
                rand = (int) (Math.random() * V);
                g.addEdgesAndWeights(i, rand, rand2, rand3);
            }
        }


        while (op1) {

            System.out.println("" +
                    "    1 to search for a number between 0 and 999 using a Breadth-First searching algorithm.\n" +
                    "    2 to search for a number between 0 and 999 using a Depth-First searching algorithm.\n" +
                    "    3 to search for a number between 0 and 999 using Dijkstra's searching algorithm.\n" +
                    "    4 to exit the program.");
            sel = input.nextInt();

            switch (sel) {
                case 1:
                    System.out.println("Enter start node from which to begin the BF search:");
                    start = input.nextInt();
                    System.out.println("Enter the final node from which to end the BF search:");
                    search = input.nextInt();

                    if (g.basicSearch(search)) {
                        System.out.println("searching");
                        g.printVE();
                        g.BFS(start, search);
                        g.shortPathDistBFS(start, search);
                    }
                    break;

                case 2:
                    System.out.println("Enter start node from which to begin the DF search:");
                    start = input.nextInt();
                    System.out.println("Enter the final node from which to end the DF search:");
                    search = input.nextInt();

                    if (g.basicSearch(search)) {
                        System.out.println("searching");
                        g.printVE();
                        g.DFS(start, search);
                    }

                    break;

                case 3:
                    System.out.println("Enter start node from which to begin Dijkstra search:");
                    start = input.nextInt();
                    System.out.println("Enter the final node from which to end Dijkstra search:");
                    search = input.nextInt();

                    if (g.basicSearch(search)) {
                        System.out.println("searching");
                        g.printVE();
                        g.searchDijkstra(start, search);

                    }

                    break;

                case 4:
                    System.exit(0);
                    op1 = false;

                default:
                    System.out.println("Please choose from one of the following options:");
            }
        }


        g.printVE();
    }
}
