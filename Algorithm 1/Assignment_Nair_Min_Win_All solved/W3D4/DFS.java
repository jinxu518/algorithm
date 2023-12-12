import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {
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
        System.out.println("Computing Depth First Search ... ");
        // Initialize all the nodes
        initializeNodes();
        dfs();
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

    public static String getOneAdjacentNode(String node){
        String adjacentNode = null;
        int index = nodes.get(node);

        for(int i= 0; i<adjacencyMatrix[index].length; i++){
            if(adjacencyMatrix[index][i] == 1 && visitedNodes[i] != 1){
                adjacentNode = letters[i];
                break;
            }
        }
        return adjacentNode;
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

    public static void dfs(){
        String startNode = "A";
        String l="";
        Stack stack = new Stack();
        // Mart the starting node as visited
        LinkedList<String> component = new LinkedList<>();
        component.add(startNode);
        addVisitedNode(startNode);
        // Add the starting node to the stack
        stack.push(startNode);
        while(!stack.empty() || !areAllNodesVisited()){
            if(stack.empty()){
                String newNode = voteANode();
                stack.push(newNode);
                addVisitedNode(newNode);
               components[componentCount] = component;
               componentCount++;
               component = new LinkedList<>();
               component.add(newNode);
            }
            l = stack.peek().toString();
            String node = getOneAdjacentNode(l);
            if(node != null){
                addVisitedNode(node);
                stack.push(node);
                component.add(node);
            }else{
                stack.pop();
            }
        }
        if(stack.empty() && areAllNodesVisited()){
            components[componentCount] = component;
        }

    }
}
