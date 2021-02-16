package test;

public class MyLinkedQueue {
	private MyDList list = new MyDList();
	
	//�޼���
	public boolean Put(Object data) {
		return list.push_back(data);
	}		
	
	public Object Get() {
		//����ִ� ���� üũ(����ִٸ� null)
		if(IsEmpty())
			return null;
		//�����ϱ� ���� head�� ���� �ִ� ���� ȹ��!
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
