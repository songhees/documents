package dataStructure;

import dataStructure.LinkedList.Node;

public class LinkedListExam {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		
		list.retrieve();
		
		Referece r = new Referece();
		Node kth = kthToLast(list.header, 3, r);
		System.out.println(kth.data);
	}
	
	static class Referece {
		public int count = 0;
	}
	
	private static Node kthToLast1(Node n, int k) {
		int total = 1;
		// next가 몇번째 인가?? 전체 노드 개수는?
		while(n.next != null) {
			++total;
			n = n.next;
		}
		int target = total-k+1;
		for (int i = 1; i<target; i++) {
			n = n.next;
		}
		return n;
	}
	

	// 재귀호출
	// O(N), O(N)
	private static Node kthToLast(Node n, int k, Referece r) {
		if (n == null) {
			return null;
		}
		
		Node found = kthToLast(n.next, k, r);
		r.count++;
		if (r.count == k) {
			return n;
		}
		return found;
	}
}


