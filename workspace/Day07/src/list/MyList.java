package list;

public class MyList {
	private Node head;	//첫번째 노드를 저장
	private int size;	//저장개수

	//생성자
	public MyList() {
		//java는 초기화를 해주지만 다른 언어에서는 안되므로 해주는 습관을 들이는 것이 좋음.
		head=null;
		size=0;
	}
	
	//연결------------------------------------------------------------
	//1. 노드 생성(초기화), 2. 연결 알고리즘
	public boolean front_Insert(Object data) {//마지막에 넣은것이 앞에
		Node newnode = new Node(data);
		
		if(head==null) {
			head=newnode;//head가 곧 새 노드가 된다.
		}else {
			//새로운 노드의 next영역에 연결해준다.
			newnode.next=head;
			head=newnode;
		}
		size++;
		return true;		
	}
	
	public boolean back_Insert(Object data) {//저장한 순서대로 
		Node newnode = new Node(data);
		
		if(head==null) {
			head=newnode;//head가 곧 새 노드가 된다.
		}else {
			//꼬리를 찾는 과정 필요(순회!)
			Node cur = head;
			
			while(cur.next!=null) {				
				cur=cur.next;
			}
			
			cur.next=newnode;//cur는 꼬리를 이게 됨으로 null. 해당 위치에 새로운 노드를 넣어준다.
		}
		size++;
		return true;	
	}
	
	//cur의 다음 노드에 연결!
	public boolean random_Insert(Node cur,Object data) {
		Node newnode = new Node(data);
		
		if(cur.next==null) {//cur가 마지막 노드일때
			cur.next=newnode;
		}else {//cur가 여러개일때
			newnode.next=cur.next;	
			cur.next=newnode;
		}		
		
		size++;
		return true;
	}
	
	//삭제--------------------------------------------------------------
	//1. 삭제할 노드를 찾는다. 2. 삭제 알고리즘
	public boolean front_delete() {
		//젤 앞에있는 노드 삭제
		Node del = head;
		
		if(del==null)//노드가 없는 상태
			return false;
		
		head=del.next;//null
		size--;
		return true;
	}
	
	//삭제할 노드와 이전 노드를 찾는다. 2. 삭제 알고리즘
	public boolean back_delete() {
		Node del = head;
		Node prev= head;
		
		if(del==null)//노드가 없는 상태
			return false;
		
		if(del.next==null){//노드가 하나인 상황
			head=null;
		}else {
			while(del.next!=null) {
				prev=del;//prev가 del의 뒤를 쫓아간다.
				del=del.next;//위치이동
			}
			prev.next=null;//prev.next=del.next=>null
		}
		
		size--;
		return true;
	}
	
	//cur의 다음 노드를 삭제!
	public boolean random_delete(Node prev) {
		Node del = prev;
		del=prev.next;
		
		if(del==null) {//노드가 없다
			return false;
		}else {
			prev.next=del.next;//다음노드 연결하기
		}
		size--;
		return true;
	}
	
	
	//순회--------------------------------------------------------------
	public void selectall() {
		System.out.println("[ "+size+" ]");
		Node cur = head;
		
		while(cur!=null) {
			//----------------------
			int data = (int)cur.data;//정수라고 가정	언박싱!(자동으로 일어남) : 기본형타입 = 레퍼런스타입일때 자동적으로 일어남
			System.out.print(data+" -> ");
			//----------------------
			cur=cur.next;//이동시키기
		}
		System.out.println();
	}

	//검색(껌색데이터 --> Node반환 (실패:null))
	public Node Select(Object key) {
		Node cur = head;
		
		while(cur!=null) {
			//----------------------
			int data = (int)cur.data;//정수라고 가정	언박싱!(자동으로 일어남) : 기본형타입 = 레퍼런스타입일때 자동적으로 일어남
			if(data==(int)key) {//key값을 비교해서 문제 확인
				return cur;
			}
			//----------------------
			cur=cur.next;//이동시키기
		}
		//while문이 끝날때까지 못찾음
		return null;
	}
	
}
