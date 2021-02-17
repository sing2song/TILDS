package example2;

import common.MyLinkedStack;

//수식나무[연결리스트기반, 알고리즘은 스택을 활용]
public class ParseTree {
	public class Node{
		int key;			//정수 저장!
		Node left;
		Node right;
		
		public Node(int key) {
			this.key = key;
			left = right = null;
		}
	}


	//멤버 필드
	Node root;		//루트 노드의 주소를 저장할 레퍼런스 변수
	int count; 		//노드 갯수

	//생성자
	public ParseTree(){
		root=null;
		count=0;
	}

	//get 메서드
	public int getCount() {
		return count;
	}

	public int getRootNodeValue() {
		return root.key;
	}

	//메서드
	//1. 수식나무 구성
	void MakeParseTree(String str) {

		//1. 스택자료 구조 생성 [HAS A]
		MyLinkedStack stack = new MyLinkedStack();

		//2. 반복문(문장의 끝까지)
		//	2.1 연산자라면!
		//		2.1.1 노드 생성 ,count증가
		//		2.1.2 스택에서 팝한 노드를 오른쪽 자식으로 할당
		//		2.1.4 다음 스택에서 POP노드를 왼쪽 자식으로 할당
		//		2.1.5 2.1.1에서 만든 노드를 스택에 PUSH
		//	2.2 연산자가 아니라면!
		//		2.2.1 노드 생성, count증가
		//		2.2.2 스택에 PUSH
		//	3. 스택에서 POP해서 멤버필드 대입

		/* 
		 * 피연산자를 만나면 노드를 생성하여 스택에 푸시
		 * 연산자를 만나면 노드를 생성하여
		 * 스택에서 팝한 노드를 오른쪽 자식으로 할당
		 * 다음 팝한 노드를 왼쪽 자식으로 할당
		 * 연산자 노드를 다시 스택에 푸시
		 * 스택에서 마지막 남은 노드가 뿌리 노드
		 */
		for(char ch : str.toCharArray()) {
			if( IsOperator(ch)) {
				Node node = new Node(ch);
				count++;
				node.right = (Node)stack.Pop();
				node.left  = (Node)stack.Pop();
				stack.Push(node);
			}
			else if(Character.isDigit(ch)) {//ch가 숫자인지
				Node node = new Node(ch);
				count++;
				stack.Push(node);
			}			
		}
		this.root = (Node)stack.Pop();

	}

	//1.1 연산자 식별하는 함수
	private boolean IsOperator(int value) {
		if( value == '+' || value == '-' || value == '*' || value == '*')
			return true;
		else
			return false;
	}


	//2. 순회코드(재귀/비재귀-스택)
		//전위
		public void PreOrder() {
			InnerPreOrder(root);
			System.out.println();
		}
		
		private void InnerPreOrder(Node root) {
			System.out.print((char)root.key + " ");
			if(root.left != null)
				InnerPreOrder(root.left);
			if(root.right != null)
				InnerPreOrder(root.right);
		}
		//중위
		public void InOrder() {
			InnerInOrder(root);
			System.out.println();
		}
		
		private void InnerInOrder(Node root) {		
			if(root.left != null)
				InnerInOrder(root.left);
			System.out.print((char)root.key + " ");
			if(root.right != null)
				InnerInOrder(root.right);
		}
		//후위
		public void PostOrder() {
			InnerPostOrder(root);
			System.out.println();
		}
		
		private void InnerPostOrder(Node root) {		
			if(root.left != null)
				InnerPostOrder(root.left);		
			if(root.right != null)
				InnerPostOrder(root.right);
			System.out.print((char)root.key + " ");
		}


		//3. 순회코드(반복문 - 스택)
		public void PreOrder_NonRe() {
			//1. 루트 노드를 스택에 Push
			MyLinkedStack stack = new MyLinkedStack();
			stack.Push(root);
			//2. 반복문(스택이 비어있지 않다면)
			/*	2.1 스택에서 POP해서 방문
			 *  2.2 POP한 노드가 널이 아닐 때
			 *  	2.2.1 스택에서 POP한 노드를 방문
			 * 		2.2.2 스택에서 POP한 오른쪽 자식을 PUSH
			 *  	2.2.3 스택에서 POP한 왼쪽 자식을 PUSH			 *  
			 */			
			while(stack.IsEmpty()==false) {
				//스택에 null은 저장되지 않으므로 pop후 조건검사 없이 방문
				Node node = (Node)stack.Pop();
				System.out.print((char)node.key+" ");
				if(node.right!=null)
					stack.Push(node.right);
				if(node.left!=null)
					stack.Push(node.left);
			}
			System.out.println();
		}
		
		public void InOrder_NonRe() {
			//Node cur = root;
			//무한반복
				/*1. 반복(NULL이 아닐때까지)
				 *	1.1 cur 노드를 PUSH
				 * 	1.2 cur 노드를 LEFT자식노드로 이동
				 *2. 조건(스택이 비어있지 않다면)
				 *	2.1 POP
				 *	2.2 방문!
				 *	2.3 cur노드를 RIGHT 자식으로 이동
				 *3. 스택이 비어있다면
				 *	무한 반복을 종료!
				 */
			
			MyLinkedStack stack = new MyLinkedStack();
			Node cur = root;
			while(true) {
				while(cur!=null) {
					stack.Push(cur);
					cur=cur.left;
				}
				if(stack.IsEmpty()==false) {
					
					cur=(Node)stack.Pop();
					System.out.print((char)cur.key+" ");
					cur=cur.right;
					
				}else 
					break;
				
			}
			System.out.println();
		}
		
		
		
}
