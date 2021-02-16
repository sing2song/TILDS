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
		Scanner scan = new Scanner(System.in);
		MyQueue queue = new MyQueue();
		
		System.out.println("=================================");
		System.out.println(" 명령어 기반 개선된 원형 Queue(배열) 테스트 ");
		System.out.println("=================================");
		
		while(true) {
			System.out.print(">> ");
			String str = scan.nextLine();
			String[] sp=str.split(" ");//공백을 기반으로 자른다.
			
			if(sp[0].equals("put")) {
				int val = Integer.parseInt(sp[1]);
				queue.Put(val);
			}
			else if(sp[0].equals("get")) {
				try {
				System.out.println("Get의 결과 값 : "+(int)queue.Get());
				}catch(Exception ex) {
					System.out.println("비어있는 상태");
				}
			}
			else if(sp[0].equals("clear")) {
				queue.Clear();				
			}
			else if(sp[0].equals("exit")) {
				break;
			}
			
			queue.PrintAll();//insert나 delete 결과값확인
			System.out.println();
		}
		
		System.out.println("=================================");
		System.out.println(" 프로그램을 종료합니다. ");
		System.out.println("=================================");

		scan.close();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		exam1();
	}

}
