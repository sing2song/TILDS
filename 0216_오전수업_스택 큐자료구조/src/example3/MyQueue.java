package example3;

public class MyQueue {
	//�ɹ��ʵ�
	private int max;
	private Object[] arr;
	private int rear;
	private int front;
	
	//������
	public MyQueue() {
		this(10);
	}
	
	public MyQueue(int max) {
		this.max = max;
		arr = new Object[max];
		rear = 0;
		front = 0;
	}

	//�޼���
	public boolean Put(Object data) {
		if( IsOverflow())
			return false;
		
		arr[rear] = data;	//���� ����
		rear = (rear+1)%max;
		return true;
	}
	
	private boolean IsOverflow() {
		if(front == (rear +1)%max)
			return true;
		else
			return false;
	}

	public Object Get() {
		if( IsEmpty())
			return null;
		
		Object data = arr[front];  //�����͸� �ӽ� ����
		front = (front+1)%max;
		return data;
	}
	
	public boolean IsEmpty() {
		return front == rear;
	}

	public void PrintAll() {
		System.out.print("[front] ");  
		
		for(int i = front; i !=rear; i = (i+1)%max) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.print(" [rear]");
	}
	
	public void Clear() {
		rear = front = 0;
	}
}










