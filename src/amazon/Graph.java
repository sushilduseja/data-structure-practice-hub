package amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// A Java Program to check whether a graph is tree or not
/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 *  write a function to check whether these edges make up a valid tree.
 */
class Graph
{
	public boolean isValidTree(int n, int[][] edges) {
		// Check if the number of edges is n-1
		if (edges.length != n - 1) {
			return false;
		}

		// Create an adjacency list for the graph
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		}

		// Use a depth-first search to check for cycles
		Set<Integer> visited = new HashSet<>();
		if (!dfs(0, -1, adjList, visited)) {
			return false;
		}

		// If all nodes have been visited, the tree is valid
		return visited.size() == n;
	}

	public boolean dfs(int node, int parent, List<List<Integer>> adjList, Set<Integer> visited) {
		// Mark the current node as visited
		visited.add(node);

		// Visit all of the neighbors of the current node
		for (int neighbor : adjList.get(node)) {
			if (neighbor == parent) {
				// Skip the parent to avoid cycles
				continue;
			}
			if (visited.contains(neighbor)) {
				// If the neighbor has been visited, there is a cycle
				return false;
			}
			if (!dfs(neighbor, node, adjList, visited)) {
				return false;
			}
		}

		// If all neighbors have been visited without finding a cycle, the tree is valid
		return true;
	}

	// Driver method
	public static void main(String args[])
	{
		Graph graph = new Graph();

		// Create a graph given in the above diagram

		int n = 5;
		int[][] edges = new int[][]{
				{1,0},
				{0,2},
				{0,3},
				{3,4}
		};
		System.out.println(graph.isValidTree(n, edges));

		n = 5;
		edges = new int[][]{
				{1, 0},
				{0, 2},
				{2, 1},
				{0, 3},
				{3, 4}
		};
		System.out.println(graph.isValidTree(n, edges));

	}
}
