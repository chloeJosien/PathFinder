package assignment09;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * I pledge that the work done here was my own and that I have learned how to
 * write this program, such that I could throw it out and restart and finish it
 * in a timely manner. I am not turning in any work that I cannot understand,
 * describe, or recreate. I further acknowledge that I contributed substantially
 * to all code handed in and vouch for it's authenticity. Haisley Brooking, Chloe Josien
 * 
 * @author Haisley Brooking
 * @author Chloe Josien
 *
 */
public class Graph {
	/**
	 * arrNode is a 2D array of our nodes.
	 * start is our starting node and goal is our ending node.
	 * shortestPath keeps track of how many steps our shortest path took.
	 * queue is our ArrayDeque.
	 * count keeps track of how many time the nodes were looked at.
	 */
	public Node[][] arrNode;
	public Node start;
	public Node goal;
	public static int shortestPath;
	public Queue<Node> queue = new ArrayDeque<Node>();
	static int count;

	/**
	 * Gets a 2D character array and makes it into an array of nodes
	 * then finds the neighbors for each node to make an agency list.
	 * @param arr
	 */
	public Graph(char[][] arr) {
		// converts the array to an array of nodes
		arrNode = new Node[arr.length][arr[0].length];
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				if (arr[row][col] == ' ') {
					arrNode[row][col] = new Node(row, col);
				} else if (arr[row][col] == 'S') {
					arrNode[row][col] = new Node(row, col);
					start = arrNode[row][col];
				} else if (arr[row][col] == 'G') {
					arrNode[row][col] = new Node(row, col);
					goal = arrNode[row][col];
				} else if (arr[row][col] == 'X') {
					arrNode[row][col] = null;
				}
			}
		}
		//finds the neighbors for each node.
		for (int row = 0; row < arrNode.length; row++) {
			for (int col = 0; col < arrNode[0].length; col++) {
				if (arrNode[row][col] != null) {
					if (arrNode[row - 1][col] != null) {
						arrNode[row][col].north = arrNode[row - 1][col];
					}
					if (arrNode[row + 1][col] != null) {
						arrNode[row][col].south = arrNode[row + 1][col];
					}
					if (arrNode[row][col + 1] != null) {
						arrNode[row][col].east = arrNode[row][col + 1];
					}
					if (arrNode[row][col - 1] != null) {
						arrNode[row][col].west = arrNode[row][col - 1];
					}
				}
			}
		}
	}

	/**
	 * Uses breath first search to find the shortest path
	 * from start to end
	 */
	public void BFS() {
		Node node = null;
		queue.offer(this.start);

		while (!queue.isEmpty()) {
			node = queue.poll();
			node.visited();
			if (node == this.goal) {
				traceBack(node);
			}
			count++;
			if (node.north != null && node.north.seen != true) {
				queue.offer(node.north);
				node.north.visited();
				node.north.previous = node;
			}
			count++;
			if (node.south != null && node.south.seen != true) {
				queue.offer(node.south);
				node.south.visited();
				node.south.previous = node;
			}
			count++;
			if (node.east != null && node.east.seen != true) {
				queue.offer(node.east);
				node.east.visited();
				node.east.previous = node;
			}
			count++;
			if (node.west != null && node.west.seen != true) {
				queue.offer(node.west);
				node.west.visited();
				node.west.previous = node;
			}

		}

	}

	/**
	 * when given an end node it traces back 
	 * to the start and changes all the positions corresponding 
	 * to the correct node in the 2D array to a .
	 * 
	 * @param end
	 */
	public void traceBack(Node end) {
		while (end.previous != start) {
			end = end.previous;	
			PathFinder.arr2D[end.row][end.col] = '.';
			shortestPath++;
		}
	}
}
