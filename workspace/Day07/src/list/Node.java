package list;

public class Node {

	 Object data;// 저장타입
	 Node next; //다음 노드(논리적 선형구조)
	
	//생성자를 이용한 노드 초기화
	public Node(Object data) {
		this.data=data;
		this.next=null;
	}
}
