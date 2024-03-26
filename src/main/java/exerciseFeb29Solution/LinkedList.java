package exerciseFeb29Solution;

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


	/** Remove the node after prev
	 *
	 * @param prev reference to the previous node
	 */
	public void removeNode(Node prev) {
		// Remove the node after node prev; this method can not be used to remove the head
		if (prev == null)
			throw new IllegalArgumentException();
		if (prev.next() == null)
			return;
		prev.setNext(prev.next().next());
		if (prev.next() == null)
			tail = prev;
	}

	/**
	 * Return the element in the middle of the linked list
	 * @return value of the middle element
	 */
	public int findMiddleElement() {
		Node slow = head;
		Node fast = head;
		if (head == null)
			throw new IllegalArgumentException();
		// Use fast and slow pointers to find the middle node
		while (fast.next() != tail && fast != tail) {
			slow = slow.next();
			fast = fast.next().next();
		}
		return slow.getElem();
	}

	/**
	 * Find the value at the k-th node from the end
	 * @param k index of the node from the end of the list
	 * @return value of the node
	 */
	public int findKthFromEnd(int k) {
		// Using two pointers, find the value in the k-th node from the end of the linked list
		Node curr1 = head;
		Node curr2 = head;
		for (int i = 0; curr1 != null && i < k; i++) {
			curr1 = curr1.next();
		}
		if (curr1 == null)
			throw new IllegalArgumentException();

		while (curr1 != tail) {
			curr1 = curr1.next();
			curr2 = curr2.next();
		}
		return curr2.getElem();
	}

	/**
	 * Merge this sorted linked list with a given sorted linked list into a single sorted linked list.
	 *
	 * @param list2
	 * Your method should not destroy the original list and its nodes should *not* reference
	 * the nodes in the input list (you need to create new nodes instead).
	 */
	public LinkedList mergeSortedLists(LinkedList list2) {
		LinkedList res = new LinkedList();
		Node curr1 = this.head;
		Node curr2 = list2.head;
		while (curr1 != null && curr2 != null) {
			if (curr1.getElem() <= curr2.getElem()) {
				res.append(curr1.getElem());
				curr1 = curr1.next();
			}
			else {
				res.append(curr2.getElem());
				curr2 = curr2.next();
			}
		}
		if (curr1 == null) {
			while (curr2 != null) {
				res.append(curr2.getElem());
				curr2 = curr2.next();
			}
		} else {
			while (curr1 != null) {
				res.append(curr1.getElem());
				curr1 = curr1.next();
			}
		}

		return res;
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.append(3);
		list1.append(4);
		list1.append(5);
		list1.removeNode(list1.head); // remove node after the head
		list1.printNodes(); // should print 3, 5
		System.out.println();

		LinkedList list2 = new LinkedList();
		list2.append(1);
		list2.append(7);
		list2.append(25);
		list2.append(50);
		list2.append(55);
		list2.append(80);
		list2.append(100);
		list2.printNodes();

		int midElement = list2.findMiddleElement();
		System.out.println("middle = " + midElement); // should print 50
		int elemAtIndexKFromTail = list2.findKthFromEnd(2);
		System.out.println("element at index 2 from the end: " + elemAtIndexKFromTail);

		System.out.println("Merging two sorted lists: ");
		LinkedList res = list1.mergeSortedLists(list2);
		res.printNodes(); // 1 3 5 7 25 50 55 80 100
	}
}
