package example3;

public class MyQueue {
	//맴버필드
	private int max;
	private Object[] arr;
	private int rear;
	private int front;
	
	//생성자
	public MyQueue() {
		this(10);
	}
	
	public MyQueue(int max) {
		this.max = max;
		arr = new Object[max];
		rear = 0;
		front = 0;
	}

	//메서드
	public boolean Put(Object data) {
		if( IsOverflow())
			return false;
		
		arr[rear] = data;	//먼저 저장
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
		
		Object data = arr[front];  //데이터를 임시 저장
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










