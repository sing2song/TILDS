package example1;

public class BitArray {
	//1. 맴버 필드
	private Object[] base; //레퍼런스 형태
	private int max;
	private int size;
	
	//2. 생성자
	public BitArray() {
		this(10);     //인자를 1개 받는 생성자를 명시적으로 호출!
	}
	
	public BitArray(int _max) {
		setMax(_max);  //max = _max;
		setSize(0);
		base = new Object[max];
	}
	
	//3. get & set
	public int getSize() {
		return size;
	}

	private void setSize(int size) {
		this.size = size;
	}

	public int getMax() {
		return max;
	}

	private void setMax(int max) {
		this.max = max;
	}
	
	private boolean IsOverflow() {
		if( max <= size)
			return true;
		else
			return false;
	}
	
	private boolean IsUseIdx(int idx) {
		if(idx >=0 && idx <= size-1)	//비어있는 상황 체크? (size == 0)
			return true;
		else
			return false;
	}
	
	//4. 기능 메서드	
	public Object getData(int idx) {
		if( IsUseIdx(idx) == false)
			return null;		
		return base[idx];
	}
	
	public void Insert(Object obj) throws Exception {
		if( IsOverflow() == true)
			throw new Exception("저장 공간이 부족합니다.");
		
		base[size] = obj;
		size++;
	}
	
	public void Delete(int idx) throws Exception {
		if(IsUseIdx(idx) == false)
			throw new Exception("유효하지 않은 인덱스 접근입니다.");
		
		for(int i=idx; i< size-1; i++)
		{
			base[i] = base[i+1];
		}
		size--;
	}
}

















