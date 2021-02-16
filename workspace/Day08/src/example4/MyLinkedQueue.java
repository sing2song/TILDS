package example4;


public class MyLinkedQueue {
	private MyDList list = new MyDList();
	

	public boolean Put(Object data)  {
		return list.push_back(data);
	}


	public boolean IsEmpty() {
		MyDList.DNode node = list.getHead();
		if(node == null)
			return true;
		else
			return false;
		//return front==rear;
	}

	public Object Get() {
		if(IsEmpty())
			return null;
		
		Object data = list.getHead().data;
		list.erase_front();
		return data;
	}


	//전체출력
	public void PrintAll() {
		System.out.println("[front]");
		list.Select_Nextall();
		System.out.println("\n[rear]");
	}


	//초기화
	public void Clear() {
		list.Clear();
	}
	
}
