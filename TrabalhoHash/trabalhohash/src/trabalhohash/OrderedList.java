package trabalhohash;

public class OrderedList<T extends Comparable<T>> extends LinkedList<T> {
	/*
	 *  Traverses all values of the list and compare your values with newNode
	 * */
	private Node<T> findBefore(Node<T> newNode) {
		Node<T> cur = getHead();
		Node<T> prev = null;

		while (cur != null) {
			int comp = cur.compareTo(newNode);
			if (comp < 0) {
				prev = cur;
				cur = cur.getNext();
			}
			if (comp == 0)
				return cur;
			if (comp > 0)
				return prev;
		}

		return prev;
	}

	public void add(T data) {
	 Node<T> newNode = new Node<>(data);
	 Node<T> anterior = findBefore(newNode);
	  if (anterior == null) {
			super.add(data);
	  } else {
			super.add(newNode, anterior);
	  }
	}

}