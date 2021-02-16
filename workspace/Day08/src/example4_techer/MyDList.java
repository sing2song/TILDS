package example4_techer;

//DNode �� MyDList������ ���Ǵ� ���� Ŭ����!
public class MyDList {
	public class DNode {
		Object data;	//����
		DNode next;		//�������
		DNode prev;		//�������
		
		public DNode(Object data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}
	
	//�ɹ� �ʵ�
	private DNode head;
	private DNode tail;
	private int   size;
	
	//������
	public MyDList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void Clear() {
		head = tail = null;
		size = 0;
	}

	//get �޼���
	public DNode getHead() {
		return head;
	}
	
	//insert --------------------------------------------------------------
	public boolean push_front(Object data) {
		DNode newnode = new DNode(data);
		
		if(head == null) {  // head == null && tail == null 
			head = newnode;
			tail = newnode;
		}
		else {
			newnode.next = head;
			head.prev = newnode;
			head = newnode;
		}
		size++;
		return true;
	}

	public boolean push_back(Object data) {
		DNode newnode = new DNode(data);
		
		if(head == null) {  // head == null && tail == null 
			head = newnode;
			tail = newnode;
		}
		else {
			newnode.prev = tail;
			tail.next = newnode;
			tail = newnode;
		}
		size++;
		return true;
	}
	
	public boolean push_random(DNode cur, Object data) {		
		
		if(cur.next == null) {
			//������ ��� �������...
			return push_back(data);
		}
		
		//���� ��� �߰��� �����ϴ� ��Ȳ
		DNode newnode = new DNode(data);
		
		newnode.prev = cur;
		newnode.next = cur.next;
		cur.next = newnode;
		newnode.next.prev = newnode;
		
		size++;
		return true;		
	}
	
	//��ü ��ȸ -----------------------------------------------------------
	public void Select_NextAll() {
		System.out.print("[" + size + "] ");
		
		DNode cur = head;	 //<---------------	1)
		while(cur != null) {
			//------------------------------
			int data = (int)cur.data;			//��ڽ�!(�ڵ�) : �⺻��Ÿ�� = ���۷���Ÿ��
			System.out.print(data + " -> ");
			//------------------------------
			cur = cur.next;  //<-----------------2)
		}
		
		System.out.println();
	}
	
	public void Select_PrevAll() {
		System.out.print("[" + size + "] ");
		
		DNode cur = tail;	 //<---------------	1)
		while(cur != null) {
			//------------------------------
			//int data = (int)cur.data;			
			System.out.print(cur.data + " -> "); //��ڽ�!(�ڵ�) : �⺻��Ÿ�� = ���۷���Ÿ��
			//------------------------------
			cur = cur.prev;  //<-----------------2)
		}
		
		System.out.println();
	}

	//�˻�(�˻������� --> Node��ȯ(����: null)
	public DNode Select(Object key) {
		DNode cur = head;		
		while(cur != null) {
			//------------------------------
			int data = (int)cur.data;			//��ڽ�!(�ڵ�) : �⺻��Ÿ�� = ���۷���Ÿ��
			if(data == (int)key){
				return cur;
			}
			//------------------------------
			cur = cur.next;
		}
		return null;
	}

	//delete -------------------------------------------------------------
	public boolean erase_front() {
		if( head == null) {		//������� ��
			return false;
		}
		else if(head.next == null) { //��尡 �ϳ��λ�Ȳ  tail.prev == null
			head = tail = null;
		}
		else {  //��尡 2�� �̻��� ��Ȳ
			DNode del = head;
			
			head = del.next;
			head.prev = null;		
			
			//del.next.prev = null;
			//head = del.next;
		}
		size--;
		return true;
	}

	public boolean erase_back() {
		if( head == null) {		//������� ��
			return false;
		}
		else if(head.next == null) { //��尡 �ϳ��λ�Ȳ  tail.prev == null
			head = tail = null;
		}
		else {  //��尡 2�� �̻��� ��Ȳ
			DNode delprev = tail.prev;
			delprev.next =null;
			tail = delprev;			
		}
		size--;
		return true;
	}

	//�ش� ��� ����!
	public boolean erase_random(DNode del) {
		if( del == null)
			return false;
		
		//���� ����
		if(del.prev == null) {		//ù��° ���
			return erase_front();
		}
		else if( del.next == null) { //�ι�° ���
			return erase_back();
		}
		else {
			del.prev.next = del.next;
			del.next.prev = del.prev;
		}
		size--;
		return true;		
	}
}









