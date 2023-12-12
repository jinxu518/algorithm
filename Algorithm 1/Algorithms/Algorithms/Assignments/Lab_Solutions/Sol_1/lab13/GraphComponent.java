package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphComponent {
	/**
	 * Create a Java program to find all components of a graph given the
	 * adjacency matrix through DFS.
	 * 
	 * @author binhtran
	 * @param graphs
	 *            adjacency matrix
	 * @return {@link List} List of components
	 */
	public List<List<Integer>> findComponentsByDFS(int[][] graphs) {
		int size = graphs.length;
		int[] visitedVertices = new int[size];
		Stack<Integer> vertices = new Stack<>();
		int v;
		List<List<Integer>> components = new ArrayList<>();
		for (int i = 0; i < visitedVertices.length; i++) {
			if (visitedVertices[i] != 1) {
				visitedVertices[i] = 1;
				vertices.push(i);
				List<Integer> component = new ArrayList<>();
				component.add(i);

				while (!vertices.isEmpty()) {
					v = vertices.peek();
					int j = 0;
					for (; j < size; j++) {
						if (graphs[v][j] == 1 && visitedVertices[j] != 1) {// j is adjacent with v and is unvisited
							// Make j as visited
							visitedVertices[j] = 1;
							component.add(j);
							// Push j into stack
							vertices.push(j);
							break;
						}
					}
					if (j == size) {// Vertex v has no more unvisited adjacency
									// vertex
						vertices.pop();
					}
				}

				components.add(component);
			}
		}

		return components;
	}
	
	/**
	 * Create a Java program to find all components of a graph given the
	 * adjacency matrix through BFS.
	 * 
	 * @author binhtran
	 * @param graphs
	 *            adjacency matrix
	 * @return {@link List} List of components
	 */
	public List<List<Integer>> findComponentsByBFS(int[][] graphs) {
		int size = graphs.length;
		int[] visitedVertices = new int[size];
		Queue<Integer> vertices = new ArrayDeque<>();
		int v;
		List<List<Integer>> components = new ArrayList<>();
		for (int i = 0; i < visitedVertices.length; i++) {
			if (visitedVertices[i] != 1) {
				visitedVertices[i] = 1;
				vertices.add(i);
				List<Integer> component = new ArrayList<>();
				component.add(i);

				while (!vertices.isEmpty()) {
					v = vertices.poll();
					int j = 0;
					for (; j < size; j++) {
						if (graphs[v][j] == 1 && visitedVertices[j] != 1) {// j is adjacent with v and is unvisited
							// Make j as visited
							visitedVertices[j] = 1;
							component.add(j);
							// Push j into queue
							vertices.add(j);
						}
					}
				}
				components.add(component);
			}			
		}
		return components;
	}

	public static void main(String... strings) {
		char[] labels = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };
		int[][] graphs = new int[][] { { 0, 1, 1, 0, 0, 1, 0, 0, 0 }, /* A */
				{ 1, 0, 0, 0, 0, 1, 0, 0, 0 }, /* B */
				{ 1, 0, 0, 0, 0, 1, 1, 0, 0 }, /* C */
				{ 0, 0, 0, 0, 1, 0, 0, 0, 1 }, /* D */
				{ 0, 0, 0, 1, 0, 0, 0, 0, 1 }, /* E */
				{ 1, 1, 1, 0, 0, 0, 0, 1, 0 }, /* F */
				{ 0, 0, 1, 0, 0, 0, 0, 1, 0 }, /* G */
				{ 0, 0, 0, 0, 0, 1, 1, 0, 0 }, /* F */
				{ 0, 0, 0, 1, 1, 0, 0, 0, 0 },/* I */
		};
		GraphComponent gp = new GraphComponent();
		List<List<Integer>> components = gp.findComponentsByDFS(graphs);
		List<List<Integer>> components2 = gp.findComponentsByBFS(graphs);
		StringBuilder sb = new StringBuilder();
		String arrow = " -> ";
		System.out.println("DFS: ");
		for (List<Integer> component : components) {
			for (Integer i : component) {
				sb.append(labels[i]);
				sb.append(arrow);
			}
			sb.delete(sb.length() - arrow.length(), sb.length());
			System.out.println(sb);
			sb.delete(0, sb.length());
		}
		
		System.out.println("BFS: ");
		for (List<Integer> component : components2) {
			for (Integer i : component) {
				sb.append(labels[i]);
				sb.append(arrow);
			}
			sb.delete(sb.length() - arrow.length(), sb.length());
			System.out.println(sb);
			sb.delete(0, sb.length());
		}
	}
}
