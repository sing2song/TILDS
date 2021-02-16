package example4;

public class MyLinkedQueue {
	private MyDList list = new MyDList();
	
	//메서드
	public boolean Put(Object data) {
		return list.push_back(data);
	}		
	
	public Object Get() {
		//비어있는 상태 체크(비어있다면 null)
		if(IsEmpty())
			return null;
		//삭제하기 전에 head가 갖고 있는 값을 획득!
		//MyDList.DNode node = list.getHead();
		//Object data = node.data;
		Object data = list.getHead().data;
		list.erase_front();
		return data;
	}
		
	public boolean IsEmpty() {
		MyDList.DNode node = list.getHead();
		if(node == null)
			return true;
		else
			return false;
	}

	public void PrintAll() {
		System.out.print("[front] ");  
			
		list.Select_NextAll();
			
		System.out.print(" [rear]");
	}
		
	public void Clear() {
		list.Clear();
	}
}
