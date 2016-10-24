package trabalhohash;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
	
	public T data;
	private Node<T> next;
	private Node<T> prev;
	private String calc;
	
	public Node(){	
		setData(null);
		setNext(null);
	}
	
	public Node(T data){
		this.setData(data);
		this.setNext(null);
	}

	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public Node<T> getPrev() {
		return prev;
	}
	
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	public String getCalc() {
		return calc;
	}
	
	public void setCalc(String calc) {
		this.calc = calc;
	}

	public String toString(){
		StringBuilder tmp = new StringBuilder();
		tmp.append(this.data);
		return tmp.toString();
	}
	
	@Override
	public int compareTo(Node<T> nodo) {
		return data.compareTo(nodo.getData());
	}

}