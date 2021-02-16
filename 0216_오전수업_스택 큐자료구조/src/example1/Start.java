//Start.java

package example1;

import java.util.Scanner;

public class Start {
	
	/*
	 *[스택 사용 명령어]
	 *push 10  
	 *pop     : 비어있는 상태에서 pop했을 때의 문제점 해결 필요!
	 *gettop
	 *clear	 
	 *exit 
	 *-> 모든 명령어 처리 후 스택의 상태정보를 출력할 것(printAll)
	 */
	public static void exam1() {
		Scanner scan = new Scanner(System.in);	//import java.util
		MyStack stack = new MyStack();		
		
		System.out.println("-------------------------------------------");
		System.out.println(" 명령어 기반 스택(배열) 테스트");
		System.out.println("-------------------------------------------");
		
		while(true) {
			System.out.print(">> ");
			String str = scan.nextLine();
			String[] sp = str.split(" ");
			if( sp[0].equals("push")){   //push 10
				int value = Integer.parseInt(sp[1]);
				stack.Push(value);
			}
			else if(sp[0].equals("pop")) { //pop	
				try {
					System.out.println("POP의 결과값 : " + (int)stack.Pop());
				}
				catch(Exception ex) {
					System.out.println("비어있는 상태");
				}
			}
			else if(sp[0].equals("gettop")) {  //gettop 
				try {
					System.out.println("TOP에 저장된 값 : " + (int)stack.GetTop());
				}
				catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
			else if(sp[0].equals("clear")) {   //clear
				stack.Clear();
			}
			else if(sp[0].equals("exit")) {
				break;
			}
			stack.PrintAll();
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
