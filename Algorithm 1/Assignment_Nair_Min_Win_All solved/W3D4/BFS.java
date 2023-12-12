import java.util.HashMap;
import java.util.LinkedList;

public class BFS {
    private static int[][] adjacencyMatrix =  {
            {0, 1, 1, 0, 0, 1, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 1, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0, 0}
    };
    private static String[] letters = {"A","B","C","D","E","F","G","H","I"};
    private static int componentCount = 0;
    private static LinkedList[] components = new LinkedList[letters.length];
    private static HashMap<String, Integer> nodes= new HashMap<>();
    private static int[] visitedNodes = new int[adjacencyMatrix.length];

    public static void initializeNodes(){
        nodes.put("A", 0);
        nodes.put("B", 1);
        nodes.put("C", 2);
        nodes.put("D", 3);
        nodes.put("E", 4);
        nodes.put("F", 5);
        nodes.put("G", 6);
        nodes.put("H", 7);
        nodes.put("I", 8);
    }

    public static void main (String[] args){
        System.out.println("Computing Breadth First Search ... ");
        // Initialize all the nodes
        initializeNodes();
        bfs();
        for (int i=0; i<prepareComponents().length; i++){
            System.out.println("Component ---- "+prepareComponents()[i]);
        }
        System.out.println();
        System.out.println("The given graph has "+(componentCount+1)+" components!");
    }

    public static LinkedList[] prepareComponents(){
        LinkedList[] comps = new LinkedList[componentCount+1];
        for(int i=0; i< comps.length; i++){
            comps[i] = components[i];
        }
        return comps;
    }
    public static boolean areAllNodesVisited(){
        boolean allVisited = true;
        for(int i = 0; i< visitedNodes.length; i++){
            if(visitedNodes[i] == 0){
                allVisited = false;
                break;
            }
        }
        return allVisited;
    }

    public static void addVisitedNode(String nodeLetter){
        Integer index = nodes.get(nodeLetter);
        visitedNodes[index] = 1;
    }

    public static LinkedList<String> getAllAdjacentNodes(String node){
        LinkedList<String> adjacentNodes = new LinkedList<>();
        int index = nodes.get(node);

        for(int i= 0; i<adjacencyMatrix[index].length; i++){
            if(adjacencyMatrix[index][i] == 1 && visitedNodes[i] != 1){
                adjacentNodes.add(letters[i]);
            }
        }
        return adjacentNodes;
    }

    public static String voteANode(){
        String node = null;
        for (int i = 0; i< visitedNodes.length; i++){
            if(visitedNodes[i] == 0){
                node = letters[i];
                break;
            }
        }
        return node;
    }

    public static void bfs(){
        String startNode = "B";
        String l="";
        LinkedList<String> queue = new LinkedList();
        // Mart the starting node as visited
        LinkedList<String> component = new LinkedList<>();
        queue.add(startNode);
        addVisitedNode(startNode);
        // Add the starting node to the queue
        while(!queue.isEmpty() || !areAllNodesVisited()){
            if(queue.isEmpty()){
                String newNode = voteANode();
                queue.add(newNode);
                addVisitedNode(newNode);
                components[componentCount] = component;
                componentCount++;
                component = new LinkedList<>();
            }
            l = queue.remove();
            LinkedList<String> nodes = getAllAdjacentNodes(l);

            component.add(l);
            if(nodes != null){
                for(int i=0; i< nodes.size(); i++){
                    queue.add(nodes.get(i));
                    addVisitedNode(nodes.get(i));
                }
            }else{
                queue.pop();
            }
        }
        if(queue.isEmpty() && areAllNodesVisited()){
            components[componentCount] = component;
        }

    }
}
