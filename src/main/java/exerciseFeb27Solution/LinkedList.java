package exerciseFeb27Solution;

/** A class representing a linked list. */
public class LinkedList {
	private Node head, tail;

	/** Constructor */
	public LinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * Insert a new node with the given element in front of the linked list
	 * @param elem value of the new node
	 */
	public void insertAtFront(int elem) {
		if (head == null) {
			head = tail = new Node(elem);
		}
		else {
			Node node = new Node(elem);
			node.setNext(head);
			head = node;
		}
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

	public boolean find(int elem) {
		Node curr = head;
		while (curr != null) {
			if (curr.getElem() == elem)
				return true;
			curr = curr.next();
		}
		return false;
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
	 * Insert a new node with the given element at the given index
	 * @param elem element in the new node we are inserting
	 * @param index index where we want to insert the new node
	 */
	public void insertAtIndex(int elem, int index) {
		// Create a new node
		Node newNode = new Node(elem);
		// Create a variable current that starts at the head
		Node current = head;
		if (index == 0 && head != null) {
			// insert before the head
			newNode.setNext(head);
			head = newNode;
			return;
		}
		int count = 0;
		while (current != null && (count < index  - 1)) {
			current  = current.next();
			count++;
		}
		// current is null
		if (current == null) {
			if (index == 0) {
				head = newNode;
				tail = newNode;
			}
			else
				throw new IllegalArgumentException();
		}
		else {
			// We reached a node at index i - 1
			newNode.setNext(current.next());
			current.setNext(newNode);
			if (newNode.next() == null) {
				tail = newNode;
			}
		}
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.append(5);
		list1.append(6);
		list1.append(8);
		list1.append(13);
		list1.insertAtFront(1);
		list1.insertAtIndex(7, 2);
		list1.printNodes();
		System.out.println(list1.find(8));
	}

}
