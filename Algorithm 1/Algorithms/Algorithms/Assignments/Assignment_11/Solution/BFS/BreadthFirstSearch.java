
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Saving neighbours in a Node.
public class BreadthFirstSearch {

    private Queue<Node> queue;
    static ArrayList<Node> nodes = new ArrayList<Node>();

    static class Node {
        int data;
        String name;
        boolean visited;
        List<Node> neighbours;

        Node(int data) {
            this.data = data;
            this.neighbours = new ArrayList<>();
        }

        Node(String name) {
            this.name = name;
            this.neighbours = new ArrayList<>();
        }

        public void setNeighbours(Node neighbourNode) {
            this.neighbours.add(neighbourNode);
        }

        public List<Node> getNeighbours() {
            return neighbours;
        }
    }

    public BreadthFirstSearch() {
        queue = new LinkedList<Node>();
    }

    public void bfs(Node node) {
        queue.add(node);
        node.visited = true;
        while (!queue.isEmpty()) {

            Node element = queue.remove();
            System.out.print(element.name + "\t");
            List<Node> neighbours = element.getNeighbours();
            for (int i = 0; i < neighbours.size(); i++) {
                Node n = neighbours.get(i);
                if (n != null && !n.visited) {
                    queue.add(n);
                    n.visited = true;

                }
            }

        }
    }

    public static void main(String arg[]) {

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeI = new Node("I");

        // Graph1
        nodeA.setNeighbours(nodeB);
        nodeA.setNeighbours(nodeC);
        nodeA.setNeighbours(nodeC);

        nodeB.setNeighbours(nodeA);
        nodeB.setNeighbours(nodeF);

        nodeC.setNeighbours(nodeF);
        nodeC.setNeighbours(nodeA);
        nodeC.setNeighbours(nodeG);

        nodeG.setNeighbours(nodeC);
        nodeG.setNeighbours(nodeH);

        nodeF.setNeighbours(nodeC);
        nodeF.setNeighbours(nodeA);
        nodeF.setNeighbours(nodeB);
        nodeF.setNeighbours(nodeH);

        // Graph2
        nodeD.setNeighbours(nodeE);
        nodeD.setNeighbours(nodeI);

        nodeE.setNeighbours(nodeD);
        nodeE.setNeighbours(nodeI);

        nodeI.setNeighbours(nodeE);
        nodeI.setNeighbours(nodeD);

        System.out.println("Component Graph1: ");
        BreadthFirstSearch bfsExample = new BreadthFirstSearch();
        bfsExample.bfs(nodeB);
        System.out.println("\nComponent Graph2: ");
        bfsExample.bfs(nodeD);

    }
}