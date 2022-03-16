package question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1158 {
	// https://dalconbox.tistory.com/140 
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int count = Integer.parseInt(st.nextToken());
		CircleList ci = new CircleList(1);
		for (int i=1; i<count; i++) {
			ci.insert(i+1);
		}
		int index = Integer.parseInt(st.nextToken());
		String result = "";
		if (index != 1) {
			result = ci.delete(index);
		} else {
			result = ci.print();
		}
		System.out.println(result);
	}
	
}

class Node {
	int data;
	Node next;
	
	public Node() {
		
	}
	
	public Node(int data) {
		this.data = data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
}

class CircleList {
	Node node;
	
	public CircleList () {
		this.node = new Node();
		this.node.next = node;
	}
	public CircleList (int data) {
		this.node = new Node(data);
		this.node.next = node;
	}
	
	public void insert(int data) {
		Node end = new Node(data);
		Node n = node;
		while (n.next != node) {
			n = n.next;
		}
		n.next = end;
		n.next.next = node;
	}
	
	public String delete(int index) {
		Node n = node;
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		int count = 1;

		while (isExist(n)) {
			count++;
			if (count%index == 0) {
				count++;
				sb.append(n.next.data).append(", ");
				n.next = n.next.next;
			}
			n = n.next;
		}
		sb.append(n.data).append(">");
		return sb.toString();
	}
	
	public boolean isExist(Node n) {
		if (n.next == n) {
			return false;
		}
		return true;
	}
	
	public String print() {
		StringBuffer sb = new StringBuffer();
		Node n = node;
		sb.append("<");
		while(n.next != node) {
			sb.append(n.data).append(", ");
			n = n.next;
		}
		sb.append(n.data).append(">");
		return sb.toString();
	}
}