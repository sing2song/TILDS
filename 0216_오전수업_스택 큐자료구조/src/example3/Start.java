package example3;

import java.util.Scanner;

public class Start {
	/*
	 *[큐 사용 명령어]
	 *put 10  
	 *get     : 비어있는 상태에서 get했을 때의 문제점 해결 필요!
	 *clear	 
	 *exit 
	 *-> 모든 명령어 처리 후 스택의 상태정보를 출력할 것(printAll)
	 */
	public static void exam1() {
		Scanner scan = new Scanner(System.in);	//import java.util
		MyQueue queue = new MyQueue();		
		
		System.out.println("-------------------------------------------");
		System.out.println(" 명령어 기반 큐(배열) 테스트");
		System.out.println("-------------------------------------------");
		
		while(true) {
			System.out.print(">> ");
			String str = scan.nextLine();
			String[] sp = str.split(" ");
			if( sp[0].equals("put")){   //put 10
				int value = Integer.parseInt(sp[1]);
				queue.Put(value);
			}
			else if(sp[0].equals("get")) { //get	
				try {
					System.out.println("GET의 결과값 : " + (int)queue.Get());
				}
				catch(Exception ex) {
					System.out.println("비어있는 상태");
				}
			}
			else if(sp[0].equals("clear")) {  //clear 
				queue.Clear();
			}
			else if(sp[0].equals("exit")) {
				break;
			}
			queue.PrintAll();
			System.out.println();
		}
		
		System.out.println("-------------------------------------------");
		System.out.println(" 프로그램을 종료합니다.");
		System.out.println("-------------------------------------------");
		
		scan.close();
	}
	
	public static void main(String[] args) {
		exam1();
	}
}
