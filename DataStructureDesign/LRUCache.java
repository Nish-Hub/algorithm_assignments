

class Node {
	int key;
	int value;
	Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}

}

/* You are required to complete below class */
class LRUCache {
	int size;
	Node head;
	int listSize;

	/* Inititalize an LRU cache with size N */
	public LRUCache(int N) {
		// Your code here
		this.size = N;
		this.head = null;
	}

	// print the list
	void printList() {
		Node tmp = this.head;
		while (tmp != null) {
			System.out.print(tmp.key + " : " + tmp.value + " , ");
			tmp = tmp.next;
		}
		System.out.println();
	}

	/*
	 * Returns the value of the key x if present else returns -1
	 */
	public int get(int x) {

		Node tmp = this.head;
		while (tmp != null) {
			if (tmp.key == x) {
				// shuffle this node also
				this.head=shuffle(tmp.key, this.listSize, this.head);
				return tmp.value;
			}
			tmp = tmp.next;
		}
		return -1;
	}

	static Node shuffle(int key, int listSize, Node head) {
		Node tmp = head;

		if (head.key == key && listSize == 1)
			return head;

		if (head.key != key)
			while (tmp.next != null) {

				if (tmp.next.key == key)
					break;

				tmp = tmp.next;
			}
		// tmp is pointing to the node just before the node to be deleted in case tmp is not head

		// Node to remove
		Node appendAtEnd = null;
		
		if (tmp == head && tmp.key==key)
		{
			appendAtEnd=head;
			head=head.next;
			appendAtEnd.next=null;
			Node temp=head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=appendAtEnd;
			return head;
		}

		if (tmp.next == null)// this means tmp is just before the last node
			return head;



		// shuffle the nodes now
		appendAtEnd = tmp.next;
		tmp.next = appendAtEnd.next;
		appendAtEnd.next=null;

		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = appendAtEnd;
		return head;
	}

	/* Sets the key x with value y in the LRU cache */
	public void set(int x, int y) {
		// Your code here
		// if list is empty,simply set the value and update size
		if (this.head == null) {
			this.head = new Node(x, y);
			this.listSize++;
			return;
		}

		// if list has elements
		// check if the key exists in the list
		Node tmp = this.head;
		while (tmp.next != null) {
			if (tmp.key == x) {
				tmp.value = y;
				// shuffle this node also
				this.head=shuffle(tmp.key, this.listSize, this.head);
				return;
			}
			tmp = tmp.next;
		}

		if (tmp.key == x) {
			tmp.value = y;
			// shuffle this node also
			this.head=shuffle(tmp.key, this.listSize, this.head);
			return;
		}

		// Node has to be added so just make the new node
		Node newNode = new Node(x, y);

		// if list doesnt have the element ,
		// check if list if not full
		if (this.listSize < this.size) {
			tmp.next = newNode; // appends the new node at the end.
			this.listSize++;
		} else {
			// shift the head one step, append the new node to the end of the
			// list.
			tmp.next = newNode;
			this.head = this.head.next;
		}

	}
}
