package common;

public class MyLinkedStack {
	
	private MyDList list = new MyDList();
	
	//기본적으로 제공되어질 메소드
	public boolean Push(Object data) {
		return list.push_front(data);
	}
	
	public boolean IsEmpty() {
		MyDList.DNode node = list.getHead();
		if(node == null)
			return true;
		else
			return false;
	}
	
	public Object Pop() {
		//비어있는 상태체크(비어있다면 null)
		if(IsEmpty())
			return null;

		//삭제하기 전에 head가 갖고있는 값을 획득해야한다
		//MyDList.DNode node = list.getHead();
		//Object data = node.data;
		Object data = list.getHead().data;
		list.erase_front();
		return data;
	}
	
	public void PrintAll() {
		list.Select_Prevall();
	}
	
	public Object GetTop() throws Exception{
		MyDList.DNode node = list.getHead();
		if(node == null)
			throw new Exception("비어있다.");
		return node.data;

	}
	
	public void Clear() {
		list.Clear();
	}
	
}
