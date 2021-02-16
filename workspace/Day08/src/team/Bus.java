package team;

public class Bus {
	private int id;//버스번호
	private int[][] seat;//좌석상태
	
	private MyQueue waitingList = new MyQueue();
	
	public Bus() {
		this(5,2);
	}
	public Bus(int w,int h) {
		seat = new int[w][h];//초기화
	}
	
	public void printSeat() {
		for(int i=0;i<seat.length;i++) {
			for(int j=0;j<seat[i].length;j++) {
				System.out.print(seat[i][j]+" ");
			}
				System.out.println();
		}
	}
	
	
}
