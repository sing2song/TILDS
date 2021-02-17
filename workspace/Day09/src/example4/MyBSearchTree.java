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
	//insert 알고리즘---------------------------------------
	//재귀
	public void Insert(int key) {
		if(root==null)
			root=new Node(key);
		else
			InnerInsert(root,key);		
	}

	public void InnerInsert(Node cur, int key) {
		//0. 노드 생성
		//1. 조건(root가 null인 상태)
		/*	1.1 노드를 root에 저장
		 *2. 조건2(cur의 키 > 전달된 키)
		 *	2.1 재귀호출(cur.left,key);
		 *3. 조건3(cur의 키 < 전달된 키)
		 *	3.1 재귀호출(cur.right,key);
		 *4. 조건4(cur의 키 == 전달된 키)
		 *	4.1 return;
		 */

		if(cur.key>key) {
			if(cur.left!=null)
				InnerInsert(cur.left,key);
			else {
				cur.left=new Node(key);
				count++;
			}
		}			
		else if(cur.key<key) {
			if(cur.right!=null)
				InnerInsert(cur.right,key);	
			else {
				cur.right=new Node(key);
				count++;
			}
		}				
		else if(cur.key==key)
			return;
	}

	//비재귀
	public void Insert_NonRe(int key) {
		if( root == null) {
			root = new Node(key);  count++;
			return;
		}
		Node cur = root;
		while(true) {
			if(cur.key < key) {
				if(cur.right == null) {
					cur.right = new Node(key);  count++;
					break;
				}
				else
					cur = cur.right;
			}
			else if(cur.key > key){
				if(cur.left == null) {
					cur.left = new Node(key);  count++;
					break;
				}
				else
					cur = cur.left;
			}
			else if(cur.key == key)
				return;
		}
	}

	//search 알고리즘---------------------------------------
	//재귀
	public Node Search(int key) {
		return InnserSelect(root, key);	
	}

	private Node InnserSelect(Node cur, int key) {
		if(cur == null || cur.key == key)  //없을경우 or 찾았을 경우
			return cur;

		if( cur.key > key) 
			return InnserSelect(cur.left, key);
		else
			return InnserSelect(cur.right, key);		
	}

	//비재귀
	public Node Search_NonR(int key) {
		Node cur = root;

		while(cur!=null) {//단말노드의 left or right까지 이동
			if(cur.key==key)
				return cur;
			else if(cur.key<key)
				cur=cur.right;
			else if(cur.key>key)
				cur=cur.left;
		}
		return null;
	}

	//delete 알고리즘----------------------------------------
	//비재귀
	public boolean Delete(int key) {
		//초기화
		Node parent=null;
		Node del=root;
		//검색!
		//[반복문 종료조건] 
		//1) 현재노드가 null => 검색실패
		//2) 값을 찾은 경우
		while((del!=null)&& del.key!=key) {
			parent = del;
			if(key<del.key)
				del=del.left;
			else
				del=del.right;
		}
		
		if(del ==null)//못찾은 경우
			return false;
		
		//삭제 알고리즘
		if(del.left==null && del.right==null) {//자식이 없는 경우
			//1. 부모가 없는 경우
			//2. 부모가 있는 경우
			if(parent ==null) {
				root=null;//노드가 하나! root가 삭제노드인 경우!
			}
			else {
				if(parent.left==del)//삭제할 노드가 부모의 어느부분에 존재하는가?
					parent.left=null;
				else
					parent.right=null;
			}
			
		}else if(del.left==null || del.right==null) {//자식이 하나인 경우
			//삭제할 노드의 어느부분에 자식이 존재하는가?
			Node child;
			if(del.left!=null)
				child=del.left;
			else 
				child=del.right;
			
			//부모에 메다는 작업
			//1. 부모가 없는 경우[root를 삭제할 경우]
			//2. 부모가 있는경우
			if(parent==null)
				root=child;
			else {
				if(parent.left==del)
					parent.left=child;
				else
					parent.right=child;
			}
			
		}else {//자식이 2개인 경우
			//선택 : 삭제 노드의 왼쪽 자식 중 가장 큰 값
			//		삭제 노드의 오른쪽 자식 중 가장 작은 값(0)
			
			//삭제노드의 가장 작은 노드와 그 부모노드를 찾음.
			Node succ_parent=del;
			Node succ = del.right;
			while(succ.left!=null) {
				succ_parent=succ;
				succ=succ.left;
			}
			
			if(succ_parent.left==succ)
				succ_parent.left=succ.right;	//right는 null일수도있고 node의 주소일 수도 있다.
			else
				succ_parent.right=succ.right;
			
			del.key=succ.key;	//찾은 값을 삭제할 노드의 값에 저장
			
		}
		count--;
		return true;
	}


	//검증용!
	public void InOrder() {
		System.out.println("저장개수 : " + count);
		InnerInOrder(root);
		System.out.println();
	}

	private void InnerInOrder(Node root) {		
		if(root.left != null)
			InnerInOrder(root.left);
		System.out.print((int)root.key + " ");
		if(root.right != null)
			InnerInOrder(root.right);
	}

}
