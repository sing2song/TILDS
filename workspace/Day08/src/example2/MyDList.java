package example2;

//DNode가 MyDList에서만 사용되는 전용 클래스!
public class MyDList {
	public class DNode{
		Object data;	//저장
		DNode next;		//다음노드
		DNode prev;		//이전노드

		public DNode(Object data) {
			this.data=data;
			next=null;
			prev=null;
		}

	}
	//멤버필드
	private DNode head;
	private DNode tail;
	private int size;

	//생성자
	public MyDList() {
		head=null;
		tail=null;
		size=0;
	}

	public void Clear() {
		head=tail=null;
		size=0;
	}
	
	public DNode getHead() {return head;}
	//insert-----------------------------------------
	public boolean push_front(Object data) {
		DNode newnode = new DNode(data);
		if(head==null) {//head==null && tail==null
			head=newnode;
			tail=newnode;
		}else {
			newnode.next=head;
			head.prev=newnode;
			head=newnode;
		}
		size++;
		return true;
	}

	public boolean push_back(Object data) {
		DNode newnode = new DNode(data);
		if(head==null) {//head==null && tail==null
			head=newnode;
			tail=newnode;
		}else {
			newnode.prev=tail;
			tail.next=newnode;
			tail=newnode;
		}
		size++;
		return true;
	}

	public boolean push_random(DNode cur, Object data) {		
		//cur가 마지막 노드일때(구현을 한 상태이므로 활용)
		if(cur.next==null) {
			return push_back(data);//중복++일어나지 않기위해 return 한다
		}
		
		//노드와 노드 중간에 연결하는 상황
		DNode newnode = new DNode(data);
		//cur가 n번째 노드일때==중간 노드일때
		//새로운 노드연결부터!
		newnode.prev=cur;			
		newnode.next=cur.next;
		
		cur.next=newnode;
		newnode.next.prev=newnode;
		
		
		size++;
		return true;
	}

	//select-------------------------------------------------
	//전체순회
	public void Select_Nextall() {
		System.out.println("[ "+size+" ]");
		DNode cur = head;	//핵심코드1

		while(cur!=null) {
			//----------------------
			int data = (int)cur.data;//정수라고 가정	언박싱!(자동으로 일어남) : 기본형타입 = 레퍼런스타입일때 자동적으로 일어남
			System.out.print(data+" -> ");
			//----------------------
			cur=cur.next;//이동시키기 //핵심코드2
		}
		System.out.println();

	}

	public void Select_Prevall() {
		System.out.println("[ "+size+" ]");
		DNode cur = tail;

		while(cur!=null) {
			//----------------------
			//int data = (int)cur.data;//정수라고 가정	언박싱!(자동으로 일어남) : 기본형타입 = 레퍼런스타입일때 자동적으로 일어남
			System.out.print(cur.data+" -> ");//cur.data가 갖는 값은 이미 언박싱된것! 이전에는 레퍼런스값만이 나왔을거다
			//----------------------
			cur=cur.prev;//이동시키기
		}
		System.out.println();

	}

	//검색(검색데이터 --> Node반환(실패 : null))
	public DNode Select(Object key) {
		DNode cur=  head;
		while(cur!=null) {
			int data = (int)cur.data;
			if(data==(int)key)
				return cur;
		
			cur=cur.next;
		}
		
		return null;
	}
	
	//delete----------------------------------------
	public boolean erase_front() {
		
		if(head==null){//노드가 없는 상태
			return false;
		}
		else if(head.next==null && tail.prev==null){//노드가 하나일 때
			head=null;
			tail=null;
		}else {//노드가 2개인 상황
			DNode del = head;
			
			head=del.next;
			head.prev=null;
			//또는
			//del.next.prev=null;
			//head=del.next;
		}
		size--;
		return true;
		
	}

	public boolean erase_back() {
		//노드가 없을 때
		if(tail==null)
			return false;
		else if(head.next==null) {//노드가 하나일때
			head=tail=null;			
		}else{//노드가 두개 이상일때
			DNode delprev = tail.prev;
			delprev.next=null;
			tail=delprev;
			
		}
		size--;
		return true;
	}
	
	//해당 노드 삭제
	public boolean erase_random(DNode del) {
		if(del==null)//del이 null인가
			return false;
		
		//삭제연산
		if(del.prev==null)//del이 첫번째 노드일때
			return erase_front();
		else if(del.next==null)//del이 마지막 노드일때
			return erase_back();
		else{//del이 중간노드일때
			del.prev.next=del.next;
			del.next.prev=del.prev;			
		}
		size--;
		return true;
		
	}

}
