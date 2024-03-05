package linkedListItertor;

import exerciseFeb29.Node;

import java.util.Iterator;

/** A class representing a linked list. */
public class LinkedList {
	private Node head, tail;

	/** Constructor */
	public LinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * Creates a new node with the given element and adds it to the back of the
	 * list
	 */
	public void append(int elem) {
		Node newNode = new Node(elem);
		if (tail != null) {
			tail.setNext(newNode);
			tail = newNode;
		} else {
			head = tail = newNode;
		}
	}

	/** Prints all the nodes in the link list */
	public void printNodes() {
		Node current = head;
		while (current != null) {
			System.out.print(current.getElem() + " ");
			current = current.next();
		}
		System.out.println();
	}

	/**
	 * Find the value at the k-th node from the end
	 * @param k index of the node from the end of the list
	 * @return value of the node
	 */
	public int findKthFromEnd(int k) {
		// FILL IN CODE
		// Using two pointers, find the value in the k-th node from the end of the linked list
		if (head == null)
			throw new IllegalArgumentException();
		Node p1 = head;
		Node p2 = head;
		// FILL IN CODE

		return 0;
	}


	class MyIterator  {

		// FILL IN CODE to implement an iterator for the linked list
	}

	public static void main(String[] args) {
		LinkedList list2 = new LinkedList();
		list2.append(1);
		list2.append(7);
		list2.append(25);
		list2.append(50);
		list2.append(55);
		list2.append(80);
		list2.append(100);
		list2.append(155);

		list2.printNodes();
		// int elemAtIndexKFromTail = list2.findKthFromEnd(20);
		// System.out.println("element at index 2 from the end: " + elemAtIndexKFromTail);


	}
}
