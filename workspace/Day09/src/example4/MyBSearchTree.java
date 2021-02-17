package example4;

public class MyBSearchTree {
	public class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int key) {
			this.key=key;
			left=right=null;
		}
	}
	
	//멤버필드
	private Node root;
	private int count;
	
	//생성자
	public MyBSearchTree() {
		root=null;
		count=0;
	}
	
	//메서드
	//insert 알고리즘
	public void Insert(int key) {
		InnerInsert(root,key);		
	}
	
	public void InnerInsert(Node cur, int key) {
		//0. 노드 생성
		Node node = new Node(key);
		//1. 조건(root가 null인 상태)
		/*	1.1 노드를 root에 저장
		 *2. 조건2(cur의 키 > 전달된 키)
		 *	2.1
		 */
		
		if(root==null) {
			root=node;
		}
	}
	
}
