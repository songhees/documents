package dataStructure;

public class LinkedListNode {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		ll.delete(1);		// 첫번째 값이 잘 지워진다.
		ll.retrieve();
		LinkedList.Node ne = ll.header; // node의 주소가 들어 있는 ne 값
	}
}

/**
 * 첫번째 node가 data이자 대표 값이 되면
 * 대표 값으로 pointer를 가지고 사용하던 다른 object의 문제가 생긴다.
 * 따라서 Node 클래스를 Linked 클래스에 감싸서 header를 데이터가 아닌 LinkedList의 시작을 알리는 용도로 사용한다.
 * 그 안에 node 클래스를 만든다.
 * 
 * @author song
 *
 */
class LinkedList {
	Node header;			// 첫번째 값은 값이 들어 있는 node가 아닌 관리용도로만 쓰인다.
	
	static class Node {
		int data;
		Node next = null;
	}
	
	LinkedList() {
		header = new Node();
	}

	void append(int d) {
		Node end = new Node();
		end.data = d;
		Node n = header;
		
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	void delete(int d) {
		Node n = header;
		
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}
	
	void retrieve() {
		Node n = header.next;
		
		while (n.next != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println(n.data);
	}
}

