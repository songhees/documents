package question.stack;

import java.io.*;

public class Q10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int count = Integer.parseInt(bf.readLine());
		
		Stack<Integer> s = new Stack<>();
		while (count != 0) {
			String command = bf.readLine();
			if (command.contains("push")) {
				s.push(Integer.parseInt(command.substring(5)));
			} else if ("pop".equals(command)) {
				sb.append(s.pop()).append("\n");
			} else if ("size".equals(command)) {
				sb.append(s.size()).append("\n");
			} else if ("empty".equals(command)) {
				sb.append(s.empty()).append("\n");
			} else if ("top".equals(command)) {
				sb.append(s.top()).append("\n");
			}
			count--;
		}
		System.out.println(sb.toString());
	}
}

class Stack<Integer> {
	class Node<Integer> {
		private int data;
		private Node<Integer> next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	private Node<Integer> top;
	
	public void push(int data) {
		Node<Integer> n = new Node<>(data);
		
		n.next = top;
		top = n;
	}
	
	public int pop() {
		if (top == null) {
			return -1;
		}
		
		int data = top.data;
		top = top.next;
		return data;
	}
	
	public int size() {
		int count = 0;
		if (top == null) {
			return count;
		}
		Node<Integer> n = top;
		while (n.next != null) {
			n = n.next;
			count++;
		}
		return ++count;
	}
	
	public int empty() {
		return top == null? 1 : 0;
	}
	
	public int top() {
		if (top == null) {
			return -1;
		}
		return top.data;
	}
}
