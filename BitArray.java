package example1;

public class BitArray {
	//1. �ɹ� �ʵ�
	private Object[] base; //���۷��� ����
	private int max;
	private int size;
	
	//2. ������
	public BitArray() {
		this(10);     //���ڸ� 1�� �޴� �����ڸ� ��������� ȣ��!
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
		if(idx >=0 && idx <= size-1)	//����ִ� ��Ȳ üũ? (size == 0)
			return true;
		else
			return false;
	}
	
	//4. ��� �޼���	
	public Object getData(int idx) {
		if( IsUseIdx(idx) == false)
			return null;		
		return base[idx];
	}
	
	public void Insert(Object obj) throws Exception {
		if( IsOverflow() == true)
			throw new Exception("���� ������ �����մϴ�.");
		
		base[size] = obj;
		size++;
	}
	
	public void Delete(int idx) throws Exception {
		if(IsUseIdx(idx) == false)
			throw new Exception("��ȿ���� ���� �ε��� �����Դϴ�.");
		
		for(int i=idx; i< size-1; i++)
		{
			base[i] = base[i+1];
		}
		size--;
	}
}

















