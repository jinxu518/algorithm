import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph {
    static class Graph{
        int vertices;
        LinkedList<Integer>[] adjList;

        public Graph(int vertices){
            this.vertices = vertices;
            adjList = new LinkedList[vertices];

            //initialize the lists
            for (int i = 0; i <vertices ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination){
            //add forward edge
            adjList[source].addFirst(destination);

            //add back edge for undirected graph
            adjList[destination].addFirst(source);

        }

        public void BFS(){

            boolean [] visited = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<>();
            System.out.println("BFS: ");
            for (int i = 0; i <vertices ; i++) {
                if(!visited[i]){
                    queue.add(i);

                    while(!queue.isEmpty()){

                        //get a vertex from queue
                        int vertex = queue.remove();
                        //mark the vertex visited
                        visited[vertex] = true;

                        //print the vertex
                        System.out.print(vertex + " ");

                        //add unvisited adjacent vertices
                        for (int j = 0; j <adjList[vertex].size() ; j++) {
                            int adjVertex = adjList[vertex].get(j);
                            if(!visited[adjVertex]) {
                                visited[adjVertex] = true;
                                queue.add(adjVertex);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 4);
        g.addEdge(3, 8);
        g.addEdge(5, 7);
        g.BFS();
    }
}