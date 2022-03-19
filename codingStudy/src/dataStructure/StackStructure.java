package dataStructure;

import java.util.EmptyStackException;

/**
 * stack 자료구조 구현하기
 * @author song
 *
 */
public class StackStructure {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.peak());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
	}
}

class Stack<T> {
	int position;

	class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	// 맨위에 있는 주소만 알면 된다.
	private Node<T> top;
	
	public T pop() {
		if (top==null) {
			throw new EmptyStackException();
		}
		
		// 삭제후
		T item = top.data;
		top = top.next;
		// 데이터 반환
		return item;
	}
	
	public void push(T data) {
		Node<T> t = new Node<>(data);
		t.next = top;
		top = t;
	}
	
	public T peak() {
		if (top == null) {
			throw new EmptyStackException();
		}
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}
