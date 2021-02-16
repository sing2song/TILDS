package game;

public class Room {
	//멤버필드
	private MyDList waitroom = new MyDList();
	
	private MyDList game1 = new MyDList();
	private MyDList game2 = new MyDList();
	private MyDList game3 = new MyDList();
	
	//생성자
	public Room() {
		
	}
	
	//메서드
	public void PrintAll() {
		System.out.println("--------------------------------------------");
		System.out.print("대기방\t");		waitroom.Select_Prevall();
		System.out.print("게임방1\t");	game1.Select_Prevall();
		System.out.print("게임방2\t");	game2.Select_Prevall();
		System.out.print("게임방3\t");	game3.Select_Prevall();
		System.out.println("--------------------------------------------");
	}
	
	public boolean Insert(int number) {
		waitroom.push_back(number);
		return false;
	}
	
	public boolean Delete(int number) {
		MyDList.DNode node = waitroom.Select(number);
		
		if(node==null) return false;
		waitroom.Select(number);
		return false;
	}
	
	public boolean GameIn(int idx,int number) {
		
		MyDList.DNode node = waitroom.Select(number);
		if(node==null)
			return false;
		
		if(idx==1) {
			game1.push_front(number);						
		}else if(idx==2) {
			game2.push_front(number);
		}else if(idx==3) {
			game3.push_front(number);
		}
		waitroom.erase_random(node);
		return false;
	}
	
	public boolean GameOut(int idx,int number) {
		return false;
	}
	
	
}
