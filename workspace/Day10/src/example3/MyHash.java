package example3;

public class MyHash {
	//맴버 필드
	private MyDList[] arr;	//
	private int max;		//저장의 최대 크기[Overflow 조건 검사]
	private int size;		//현재 저장된 갯수
	
	//생성자
	public MyHash(int max) {
		this.max = max;
		this.size = 0;
				
		arr = new MyDList[max];				//배열 생성
		for(int i=0; i< arr.length; i++)
			arr[i] = new MyDList();			//각 배열의 저장공간에 연결리스트를 생성
	}
	
	//get & set 메서드
	public Object getData(int idx) {
		
		return null;
		//return arr[idx];
	}
	
	private boolean IsOverflow() {
		return false;
	}
	
	private boolean IsUniq(Object key) {
		for(int i=0; i<arr.length; i++) {
			MyDList list = arr[i];
			MyDList.DNode node = list.Select(key);
			if(node != null)
				return false;				
		}
		return true;
	}
	
	public boolean Insert(Object key) {
		if(IsUniq(key) == false)
			return false;
		
		if(IsOverflow() == true)
			return false;
		
		int hvalue = HashFunction(key);		
		
		MyDList list = arr[hvalue];
		list.push_front(key);
		size++;
		
		return true;
	}
	
	public Object Select(Object key) {
		int hvalue = HashFunction(key);
		MyDList list = arr[hvalue];
		MyDList.DNode node = list.Select(key);
		if(node != null)
			return node.data;			
		return null;
	}
	
	
	public boolean Delete(Object key) {
		int hvalue = HashFunction(key);
		MyDList list = arr[hvalue];
		MyDList.DNode node = list.Select(key);
		if(node != null) {
			list.erase_random(node);
			return true;
		}
		else
			return false;
	}
	
	public void Clear() {
		this.size = 0;
		
		for(int i=0; i< arr.length; i++) {
			MyDList list = arr[i];
			list.Clear();
		}		
	}
	
	public void PrintAll() {
		System.out.println("저장개수 : " + size);
		System.out.println("\n--------------------------------------------------------------------------------------");
		for(int i=0; i< arr.length; i++) {
			System.out.print("[" + i + "]" );
			MyDList list = arr[i];
			list.Select_PrevAll();
			System.out.println();
		}
		System.out.println("\n--------------------------------------------------------------------------------------");
	}
	
	//해쉬 함수
	private int HashFunction(Object key) {	
		return ((int)key % max);
	}	
}
