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
		
		ll = new LinkedList();
		ll.append(2);
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.append(4);
		ll.append(2);
		ll.retrieve();
		ll.removeDups();
		ll.retrieve();
	}
}

/**
 * node클래스를 감싸는 클래스
 * 첫번째 node가 data이자 대표 값이 되면
 * 대표 값으로 pointer를 가지고 사용하던 다른 object의 문제가 생긴다.
 * 따라서 Node 클래스를 Linked 클래스에 감싸서 header를 데이터가 아닌 LinkedList의 시작을 알리는 용도로 사용한다.
 * 그 안에 node 클래스를 만든다.
 * 첫번째 node인 header에 값을 넣는게 아닌 포인터의 역할로만 만들기
 * 즉 포인터와 데이터를 담는 node를 따로 만들기
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
	
	// 중복값 제거하는 함수 시간복잡도 O(n^2) 공간은 O(1) 아래의 방법과 비교햇을때 시간은 더 많이 들지만 공간의 효율성이 있는 알고리즘이다.
	// hashset을 만들어서(버퍼) 하면 시간복잡도가 상당히 줄어들지만 O(n) 공간은 최악의 경우(중복이 없을 경우) O(n)[만들어진hashset크기] 만큼 사용 
	void removeDups() {
		Node n = header;
		// 마지막 노드가 중복값이여서 지워질 경우 r.next : 마지막 노드 
		// n은 n.next로 null 값이 되어 버린다. 따라서 반복문이 종료되어야 하므로 n != null을 추가한다.
		while(n != null && n.next != null) {	
			// runner추가 항상 n에 위치
			Node r = n; 
			while (r.next != null) {			// 마지막 노드에는 가지 않는다.
				if (n.data == r.next.data) {	// 마지막 노드까지 비교하기 위해 r이 아닌 r.next를 비교한다.
					r.next = r.next.next;
				} else {
					r = r.next;
				}
			}
			
			n= n.next;
		}
	}
}

