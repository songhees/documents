package dataStructure;
/**
 * 단방향 class Node 구현하기
 * header가 list의 첫번째 값이며 대표이다.
 * header가 삭제되면 다른 node가 header을 pointer로 가지고 있으므로 문제가 생긴다.
 * 
 * 포인터(pointer)
 * 프로그래밍 언어에서 다른 변수, 혹은 그 변수의 메모리 공간주소를 가리키는 변수를 말한다.
 * 포인터가 가리키는 값을 가져오는 것을 역참조라고 한다.
 * java에서 포인트 개념이 별로 없다. 변수는 Call By Value 이나 클래스에서는 Call By Reference이기 때문이다.
 * 하나의 메소드에서 정의된 변수는 그 메소드 안에서만 값이 변경이 된다.
 * 하지만 클래스의 참조변수를 가지고 그 클래스 안에 있는 변수값을 바꾸면 값이 변경된다.
 * java와 달리 다른 언어(C, C++)는 오직 Call By Value이다.
 * @author song
 *
 */
public class Linked_List {
	
	public static void main(String[] args) {
		
		Node head = new Node(1);
		head.append(2).append(3).append(4);
		head.retrieve();
		// append에서 n은 head가 되고 2를 가진 end node가 생긴다.  
		// head의 next 노드의 값은 null 이기 때문에 next는 end node가 되게 된다.
		// Node 클래스의 Node next는 다음 노드를 연결하는 잭과 같은 것이다! ★★★
		// 이 변수라는 값에 객체를 줄로 연결하는 것으로 생각하자
//		head.append(3); // 이미 next값에 값이 있으므로 그 다음 node의 next값에 해당 노드가 들어가게 된다.
		head.delete(3);
		head.delete(2);
		head.retrieve();
		head.delete(1); // header값을 삭제할 수 없다.
	}
}

class Node {
	int data;
	Node next = null;	// 해당 노드의 그 다음 node 객체(주소)
	
	Node(int d) {	// 생성자
		this.data = d;
	}
	
	Node append(int d) {
		Node end = new Node(d);		// 넣을 노드
		Node n = this;				// pointer 첫번째 노드
		while (n.next != null) {	// null이면 마지막 노드라는 뜻
			n = n.next;				// 주소값 교체 (다음 노드로 교체)
		}
		
		n.next = end; // 마지막 노드의 next에 새로 생성한 노드를 넣어준다.
		return n.next;	// 마지막 노드 값을 return하게 되면 바로 마지막 노드에서 다음 노드 값을 넣기 편할 것이다.
	}
	
	void delete(int d) {			// 삭제할 값
		Node n = this;				// 임의의 pointer 처음 node 
		while (n.next != null) {	// 노드 처음부터 끝까지 도는 중 // 마지막 n의 next는 null 이기때문에 안에는 마지막 node가 갈 수 없다.
			if (n.next.data == d) {	// 노드에 지울  찾는 중	// n의 다음 node의 값을 판단함, 마지막 node가 갈 수 있으나 첫번재 node를 확인할 수 없다.
				n.next = n.next.next;	// 앞의 노드가 다음 node의 data를 지울지 말지 판단한다. 
				// n의 노드에서 다음 노드가 삭제할 대상이면 n의 다음 노드를 n.next.next로 바꾼다. 즉 n의 다음 node 주소 값을 n.next.next로 바꾼다.
				// n.next노드는 사라짐
			} else {
				n = n.next;		// 다음 node로 이동
			}
		}
	}
	
	void retrieve() {
		Node n = this;
		while (n.next != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println(n.data);
	}
}
