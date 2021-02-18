package example2;

//Pair형태로 관리할 데이터 타입!
class PairData{
	int key;	//회원번호
	Member mem;	//저장값
	
	public PairData(Member mem) {
		this.key=mem.getNumber();
		this.mem=mem;
	}
}

/*
 * 저장 공간의 일관성
 * 자바 Collection 클래스
 * 1. Object 저장(다양한 타입을 저장하도록 만듬)
 * 		하나의 저장소에 정수, 객체 섞어서 저장해도 저장이 가능! => 문제점!
 * 2. 템플릿 기반 저장(JDK 1.2?) => 해결법
 * 
 * ==>전체 객체를 Object로 저장하는 형태로 수정하자! 비어있을때는 null
 * 
 */

//PairData를 종속적으로 관리하는 클래스
public class MyHashMap {
	//멤버필드
	private Object[] arr;	//배열 생성시 max값보다 120%크기로 생성
	private int bucket_max;	//배열의 실제크기(배열을 생성할 때, 원형이동)
	private int max;		//저장의 최대크기(Overflow 조건검사용)
	private int size;		//현재 저장된 갯수
	
	//생성자
	public MyHashMap(int max) {
		this.max=max;
		this.size=0;
		this.bucket_max = (int)(max*1.2);
		
		//배열 생성 및 초기화
		arr = new Object[bucket_max];
		for(int i=0;i<arr.length;i++) {
			arr[i]=null;
		}
	}

	//get & set 메서드
	public Object getData(int idx) {return arr[idx];}

	
	//기증 메서드
	/*
	 *	1. 오버플로우 조건 검사(정적 구조)
	 *	2. 해쉬 값 획득(해쉬 함수를 활용)
	 *	3. 저장 알고리즘
	 *		빈공간이나 or 삭제된 공간을 찾아서 저장(반복문, 시작점 : 해쉬값 위치부터)
	 *		- 이동시 원형 이동 필요!
	 *		찾은 공간의 위치에 저장
	 *		size 증가 
	 */
	private boolean IsOverflow() {
		if(max<=size)
			return true;
		else 
			return false;
	}
	
	private boolean IsUniq(Object key) {
		//선형검색
		for(int i=0; i<arr.length; i++) {
			Member mem = (Member)arr[i];	
			if( mem!=null && mem.getNumber() == (int)key)
				return false;			
		}
		return true;		
	}

	
	public boolean Insert(int key,Object value) {
		if(IsUniq(key)==false)
			return false;
		
		if(IsOverflow()==true)//오버플로우검사
			return false;
		
		int val = HashFunction(key);
		
		//while((int)arr[val]!=-1 && (int)arr[val]!=-2) 
		while(arr[val]!=null && ((Member)arr[val]).getNumber()!=-2)
			val=(val+1)%bucket_max;
				
		arr[val]=value;
		size++;		
		
		return true;
	}
	
	/*1. 해쉬값을 얻는다(해쉬테이블
	*2. 해쉬값획득([해쉬값, 비어있을때(-1)]) 반복구간의 시작점과 끝점. 굳이 다할 필요없음 
	*	원형이동!
	*	if(저장된 값과 키값을 비교)
	*[결과값] 버킷의 인덱스 반환(실패시 -1
	*/
	public int Select(Object key) {
		int hvalue = HashFunction(key);
		for(int i = hvalue; arr[i] != null; i = (i+1)%bucket_max) {
			Member mem = (Member)arr[i];	
			if( mem!= null && mem.getNumber() == (int)key)  //<========= 4)����
				return i;
		}			
		return -1;
	}

	
	public Object KeyToValue(int key) {
		int idx = Select(key);
		if(idx==-1) return null;
		return arr[idx];//Member가 저장되어있다
	}
	
	/*
	 * 저장된 값을 -2로 변경 Select 함수를 활용할 수 있다
	 * 1. key값이 저장된 버킷의 인덱스 값을 획득하는 과정 필요(Select활용)
	 * 2.1 없는 경우(Select의 반환값이 -1) return false
	 * 2.2 찾은 경우 
	 * 		해당 버켓의 값을 -2로 저장
	 * 		size 감소
	 * 		return true
	 */
	public boolean Delete(Object key) {
		
		int idx = Select(key);
		if(idx==-1) 
			return false;
		
		((Member)arr[idx]).setNumber(-2);
		size--;
		return true;
						
	}
	
	public void Clear() {
		this.size=0;
		
		for(int i=0;i<arr.length;i++)
			arr[i]=null;		
	}
	
	public void PrintAll() {
		System.out.println("\n--------------------------------------------------------------------------------------");
		for(int i=0; i< arr.length; i++) {
			System.out.print(i + "\t");
		}
		System.out.println("\n--------------------------------------------------------------------------------------");
		for(int i=0; i< arr.length; i++) {
			if( arr[i] == null)
				System.out.print("-1" + "\t");
			else
				System.out.print(((Member)arr[i]).getNumber()+ "\t");
		}
		System.out.println("\n--------------------------------------------------------------------------------------");
	}


	
	//해쉬 함수
	private int HashFunction(Object key) {
		return (int) key % bucket_max;
	}
	
}
