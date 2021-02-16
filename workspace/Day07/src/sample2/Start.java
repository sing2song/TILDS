package sample2;

import java.util.Scanner;

public class Start {

	private Room room = new Room();
	private Scanner sc = new Scanner(System.in);
	
	private void Init() {
		System.out.println("-------------------------------------------");
		System.out.println("프로그램을 시작합니다.");
		System.out.println("-------------------------------------------");
	}
	
	private void Exit() {
		System.out.println("-------------------------------------------");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("-------------------------------------------");
	}
	
	private void Insert(int number) {
		if(room.Insert(number))
			System.out.printf("%d번 회원이 대기방으로 입장하였습니다.\n");
		
	}
	
	private void Delete(int number) {
		if(room.Delete(number))
			System.out.printf("%d번 회원이 대기방에서 퇴장하였습니다.\n",number);
		else
			System.out.printf("%d번 회원은 대기방에 존재하지 않습니다.\n",number);
	}
	
	private void GameRoomIn(int roomNumber,int number) {
		if(room.GameIn(roomNumber, number))
			System.out.printf("%d번 회원이 게임방%d로 이동하였습니다.\n",number,roomNumber);
		else
			System.out.printf("%d번 회원은 대기방에 존재하지 않습니다.\n",number);
		
	}
	
	private void GameRoomOut(int roomNumber,int number) {
		if(room.GameOut(roomNumber, number))
			System.out.printf("%d번 회원이 대기실 이동하였습니다.\n",number);
		else
			System.out.printf("%d번 회원은 %d방에 존재하지 않습니다.\n",number,roomNumber);
	}
	
	
	public void Run() {
		Init();
		
		while(true) {
			room.PrintAll();
			
			System.out.print(">> ");
			String str = sc.nextLine();
			String[] sp = str.split(" ");
			
			if(sp[0].equals("insert")) {//insert 10
				Insert(Integer.parseInt(sp[1]));
			}else if(sp[0].equals("delete")) {//delete 10
				Delete(Integer.parseInt(sp[1]));
			}else if(sp[0].equals("gamein")) {//gamein 1 30
				int roomNumber = Integer.parseInt(sp[1]);
				int val = Integer.parseInt(sp[2]);
				GameRoomIn(roomNumber,val);
				
			}else if(sp[0].equals("gameout")) {
				int roomNumber = Integer.parseInt(sp[1]);
				int val = Integer.parseInt(sp[2]);
				GameRoomOut(roomNumber,val);
			}else if(sp[0].equals("exit"))
				break;
		}
		
		Exit();
	}
		
	public static void main(String[] args) {
		new Start().Run();	//무명객체(생성과 동시에 단 한번만 메서드를 사용할 경우)
	}

}
