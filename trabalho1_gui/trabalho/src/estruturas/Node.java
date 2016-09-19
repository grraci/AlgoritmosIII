package estruturas;

import java.util.Scanner;
import java.util.regex.Pattern;

import algoritmos.AvaliadorRPN;
import algoritmos.InfixPosFixConverter;
import algoritmos.InvalidOperator;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
	
	public T data;
	private Node<T> next;
	private Node<T> prev;
	public OrderedList<String> ol;
	public ExpressionEvaluator expression;
	private String calc;
	public String expressionUsed;
	
	public Node(){	
		setData(null);
		setNext(null);
	}
	
	public Node(T data){
		ol = new OrderedList<>();
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
		this.expressionUsed = calc;
		InfixPosFixConverter converter = new InfixPosFixConverter();
		System.out.println(calc+"  --> "+Pattern.matches("[0-9()+\\-*. ]{0,40}", calc));
		try {
			if(Pattern.matches("[0-9()+\\-*. ]{0,50}", calc))
			 this.calc = String.valueOf(AvaliadorRPN.avalia(converter.toPeek(calc)));
			else 
			  this.calc = String.valueOf(AvaliadorRPN.avalia(converter.toPeek("0")));
		} catch (PilhaCheia | PilhaVazia | InvalidOperator e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

	public String toString(){
		StringBuilder tmp = new StringBuilder();
		tmp.append(this.calc);
		return tmp.toString();
	}
	
	@Override
	public int compareTo(Node<T> nodo) {
		return data.compareTo(nodo.getData());
	}

}