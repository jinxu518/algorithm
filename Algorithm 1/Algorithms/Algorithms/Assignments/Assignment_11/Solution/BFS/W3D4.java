import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class W3D4 {
    private static Queue<Node> queue = new LinkedList<Node>();
    private static Stack<Node> stack = new Stack<Node>();
    static ArrayList<Node> nodes = new ArrayList<Node>();

    static class Node {
        String name;
        boolean visited;

        Node(String name) {
            this.name = name;
        }
    }

    // find neighbors of node using adjacency matrix
    // if adjacency_matrix[i][j]==1, then nodes at index i and index j are connected
    public static ArrayList<Node> findNeighbours(int adjacency_matrix[][], Node x) {
        int nodeIndex = -1;

        ArrayList<Node> neighbours = new ArrayList<Node>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).equals(x)) {
                nodeIndex = i;
                break;
            }
        }

        if (nodeIndex != -1) {
            for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++) {
                if (adjacency_matrix[nodeIndex][j] == 1) {
                    neighbours.add(nodes.get(j));
                }
            }
        }
        return neighbours;
    }

    public static void bfs(int adjacency_matrix[][], Node node) {

        queue.add(node);
        while (!queue.isEmpty()) {

            Node element = queue.remove();
            System.out.print(element.name + "\t");
            ArrayList<Node> neighbours = findNeighbours(adjacency_matrix, element);
            for (int i = 0; i < neighbours.size(); i++) {
                Node n = neighbours.get(i);
                if (n != null && !n.visited) {
                    queue.add(n);
                    n.visited = true;

                }
            }

        }
    }

    public static void dfs(int adjacency_matrix[][], Node node) {
        stack.add(node);
        while (!stack.isEmpty()) {
            Node element = stack.pop();
            System.out.print(element.name + "\t");

            ArrayList<Node> neighbours = findNeighbours(adjacency_matrix, element);
            for (int i = 0; i < neighbours.size(); i++) {
                Node n = neighbours.get(i);
                if (n != null && !n.visited) {
                    stack.add(n);
                    n.visited = true;

                }
            }
        }
    }

    public static int connectedComponnentsBfs(int adjacency_matrix[][]) {
        int componentNumber = 0;
        for (Node n : nodes) {
            componentNumber += 1;
            if (n.visited == false) {
                n.visited = true;

                bfs(adjacency_matrix, n);
                // System.out.print(n.name + " ");
                System.out.println();
            }
        }
        return componentNumber;
    }

    public static int connectedComponnentsDfs(int adjacency_matrix[][]) {
        int componentNumber = 0;
        for (Node n : nodes) {
            if (n.visited == false) {
                n.visited = true;
                componentNumber += 1;
                dfs(adjacency_matrix, n);
                // System.out.print(n.name + " ");
                System.out.println();
            }
        }
        return componentNumber;
    }

    public static void data() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeI = new Node("I");

        nodes.add(nodeA);
        nodes.add(nodeB);
        nodes.add(nodeC);
        nodes.add(nodeD);
        nodes.add(nodeE);
        nodes.add(nodeF);
        nodes.add(nodeG);
        nodes.add(nodeH);
        nodes.add(nodeI);
    }

    public static void main(String arg[]) {
        data();
        int adjacency_matrix[][] = {
                // A B C D E F G H I
                { 0, 1, 1, 0, 0, 1, 0, 0, 0 }, // A
                { 1, 0, 0, 0, 0, 1, 0, 0, 0 }, // B
                { 1, 0, 0, 0, 0, 1, 1, 0, 0 }, // C
                { 0, 0, 0, 0, 1, 0, 0, 0, 1 }, // D
                { 0, 0, 0, 1, 0, 0, 0, 0, 1 }, // E
                { 1, 1, 1, 0, 0, 0, 0, 1, 0 }, // F
                { 0, 0, 1, 0, 0, 0, 0, 1, 0 }, // G
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 }, // H
                { 0, 0, 0, 1, 1, 0, 0, 0, 0 }, // I
        };
        System.out.println("Connected Components Using DFS");
        System.out.print("Total Components: " + connectedComponnentsBfs(adjacency_matrix));

        for (Node n : nodes) {
            n.visited = false;
        }

        System.out.println("\nConnected Components Using BFS");
        System.out.print("Total Components: " + connectedComponnentsDfs(adjacency_matrix));
    }
}
