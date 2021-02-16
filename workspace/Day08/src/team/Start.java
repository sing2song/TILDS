package team;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Bus bus = new Bus();
				
		while(true) {
			System.out.print(">> ");
			String str = scan.nextLine();
			String[] sp=str.split(" ");//공백을 기반으로 자른다.
			
			if(sp[0].equals("reserve")) {//reserve 사람아이디 버스좌석
				int id = Integer.parseInt(sp[1]);
				int id = Integer.parseInt(sp[2]);
				
				stack.Push(val);
			}
			else if(sp[0].equals(" ")) {
				try {
				System.out.println("POP의 결과 값 : "+(int)stack.Pop());
				}catch(Exception ex) {
					System.out.println("비어있는 상태");
				}
			}
			else if(sp[0].equals("exit")) {
				break;
			}
			
			bus.printSeat();
			System.out.println();
		}
		
		
	}

}
