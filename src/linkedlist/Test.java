package linkedlist;

import java.util.Stack;

/**
 * 
 * @author sumitmalpure1089
 * 
 *         Singly Linked List Implementation in Java
 *
 */
public class Test {

	public static void main(String[] args) {

		Node head = new Node(10);
		Node node2 = new Node(20);
		Node node3 = new Node(30);
		head.next = node2;
		node2.next = node3;
		System.out.println("Iterative List Print:");
		printList(head);
		System.out.println("\nRecursive Linked List Print:");
		printListRecursive(head);
		Node reverseListByK = reverse(head, 2);
		System.out.println("\nReverse List by 2:");
		printList(reverseListByK);
	}

	/**
	 * Iterative approach Time Complexity of O(N) No auxiliary space required
	 * 
	 * @param head
	 */
	public static void printList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}

	/**
	 * O(N) time complexity O(N) auxiliary space
	 * 
	 * @param head
	 */
	public static void printListRecursive(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.data + " ");
		printListRecursive(head.next);

	}

	/**
	 * Iterative approach reverse first k nodes and then merge two lists
	 * 
	 * @param node
	 * @param k
	 * @return
	 */
	public static Node reverse(Node node, int k) {
		Stack<Node> stk = new Stack<Node>();
		Node res = null;
		while (node != null) {
			for (int i = 0; i < k; i++) {
				if (node != null) {
					stk.push(node);
					node = node.next;
				}
			}
			if(res==null) {
				res = stk.pop();	
			}
			//This logic needs to be changed
			while (!stk.isEmpty()) {
				Node temp = stk.pop();
				res.next = temp;
			}

		}
		return res;
	}
}

class Node {

	int data;
	Node next;

	Node(int data) {
		this.data = data;
		next = null;
	}
}