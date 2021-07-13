/* For problem statement, please refer :  https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1 */
class Node {
	int value;
	Node next;

	Node(int value) {
		this.value = value;
		this.next = null;
	}
}

class GFG {
	void linksort(Node head) {
		int length = 0;
		// Corner cases : if list is empty or list has a single element , then
		// do nothing
		if (head == null)
			return;

		if (head.next == null)
			return;

		// finding the length of the list
		length = findLengthList(head);

		// sorting algo : bubble sort technique
		boolean swap = false;
		for (int k = 0; k < length; k++) { // repeat the iterations on the list
			Node temp = head; // initialise with head every time
			 swap = false;
			for (int i = 0; i < (length - k - 1); i++) {// last element at end
														// of each iteration is
														// already smallest
				if (temp.value > temp.next.value) {
					swapNodeData(temp, temp.next);
					swap = true;
				}
				temp = temp.next;
			}
			if (!swap) // break out of the loop if there was no swap in the
						// iteration
				break;
		}
	}

	void swapNodeData(Node a, Node b) {
		a.value ^= b.value;
		b.value ^= a.value;
		a.value ^= b.value;
	}

	int findLengthList(Node head) {
		Node tmp = head;
		int count = 0;
		while (tmp != null) {
			count++;
			tmp = tmp.next;
		}
		return count;
	}
}
