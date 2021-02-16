package example3;

public class MyQueue {
	//멤버필드
	private int max;
	private Object[] arr;
	private int rear;
	private int front;

	public MyQueue() {
		this(10);
	}

	public MyQueue(int max) {
		this.max=max;
		arr = new Object[max];
		this.rear = 0;
		this.front = 0;
	}


	//메서드	
	private boolean IsOverflow() {
		/*
		if(front == (rear +1)%max)
			return true;
		else
			return false;
		 */
		
		return front==(rear+1)%max;
	}


	public boolean Put(Object data)  {
		if (IsOverflow())
			return false;

		arr[rear]=data;//먼저 저장
		rear = (rear+1)%max;
		return true;
	}


	public boolean IsEmpty() {
		return front==rear;
	}

	public Object Get() {
		if (IsEmpty())
			return null;

		Object data = arr[front];  //데이터를 임시 저장
		front = (front+1)%max;
		return data;
	}


	//전체출력
	public void PrintAll() {
		System.out.println("[front]");
		for(int i=front; i !=rear; i = (i+1)%max)
			System.out.print(arr[i]+" ");
		System.out.println("\n[rear]");
	}


	//초기화
	public void Clear() {
		rear=front=0;
	}
}
