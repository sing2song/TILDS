package sample1;

public class Start {

	public static void exam1() {
		MyDList list = new MyDList();
		for(int i=10;i<=50;i=i+10) {
			list.push_front(i);
			//list.push_back(i);
		}
		
		list.Select_Nextall();	//머리부터 출력했으므로 50 40 30 20 10 
		list.Select_Prevall();	//꼬리부터 출력했으므로 10 20 30 40 50
		
		
		//검색확인
		//DNode fullname : sample1.MyDList.DNode
		MyDList.DNode cur = list.Select(40);
		if(cur!=null)
			System.out.println("검색결과 : "+(int)cur.data);
		else 
			System.out.println("없다");
	}
	
	//random insert
	public static void exam2() {
		MyDList list = new MyDList();
		for(int i=10;i<=50;i=i+10) {
			//list.push_front(i);
			list.push_back(i);
		}
		list.Select_Nextall();
		list.Select_Prevall();
		
		MyDList.DNode node = list.getHead();
		node=node.next.next;//30을 저장하고있는 노드
		list.push_random(node, 35);
		list.Select_Nextall();
		list.Select_Prevall();
	}
	
	//delete
	public static void exam3() {
		MyDList list = new MyDList();
		for(int i=10;i<=50;i=i+10) {
			//list.push_front(i);
			list.push_back(i);
		}
		list.Select_Nextall();
		list.Select_Prevall();
		
		for(int i=0;i<6;i++) {
		list.erase_back();
		list.Select_Nextall();
		list.Select_Prevall();
		}
	}
	
	//random delete
	public static void exam4() {
		MyDList list = new MyDList();
		for(int i=10;i<=50;i=i+10) {
			//list.push_front(i);
			list.push_back(i);
		}
		list.Select_Nextall();
		list.Select_Prevall();
		
		MyDList.DNode node = list.getHead();
		node=node.next.next;	//30을 저장하고있음
		
		list.erase_random(node);
		
		list.Select_Nextall();
		list.Select_Prevall();
	}
	
	public static void exam5() {
		// c언어 : malloc <--> free : 힙 메모리를 사용
		// c++언어 : new <--> delete : 힙 메모리를 사용
		// 만약에 힙 메모리를 사용한 후 소멸처리를 안했다 --> 메모리 릭!(메모리 손실)
		
		// Java & C#: 성질이 비슷하다.
		// 힙메모리를 마음대로 써라. 소멸은 알아서 처리해준다!(delete가 없다 대신 가비지 컬렉터가 해준다!)
		// delete처리를 해주는 가비지 컬렉터
		// 자기가 원할 때만 소멸처리를 한다.
		// 소멸처리하는 대상은 가비지이다.
		
		MyDList list = new MyDList();	//힙에 MyDList가 생성
		list = null;					//힙에 생성된 MyDList가 가비지가 된다. 주소를 잃어버렸기때문...
		
		
		
	}
		
	public static void main(String[] args) {
		exam5();
	}

}
