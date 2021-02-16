package example1;

import java.util.Scanner;

public class Start {

	/*
	 *	[스택 사용 명령어]
	 *	push 10
	 *	pop
	 *	gettop
	 *	clear
	 *	exit
	 *	->모든 명령어 처리 후 스택의 상태 정보를 출력할 것(printAll 
	 * */
	public static void exam1(){
		Scanner scan = new Scanner(System.in);
		MyStack stack = new MyStack();
		
		System.out.println("=================================");
		System.out.println(" 명령어 기반 단일 stack(배열) 테스트 ");
		System.out.println("=================================");
		
		while(true) {
			System.out.print(">> ");
			String str = scan.nextLine();
			String[] sp=str.split(" ");//공백을 기반으로 자른다.
			
			if(sp[0].equals("push")) {
				int val = Integer.parseInt(sp[1]);
				stack.Push(val);
			}
			else if(sp[0].equals("pop")) {
				try {
				System.out.println("POP의 결과 값 : "+(int)stack.Pop());
				}catch(Exception ex) {
					System.out.println("비어있는 상태");
				}
			}
			else if(sp[0].equals("gettop")) {
				try {
					System.out.println("TOP에 저장된 값 : "+stack.GetTop());
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
				
			}
			else if(sp[0].equals("clear")) {
				stack.Clear();				
			}
			else if(sp[0].equals("exit")) {
				break;
			}
			
			stack.PrintAll();//insert나 delete 결과값확인
			System.out.println();
		}
		
		System.out.println("=================================");
		System.out.println(" 프로그램을 종료합니다. ");
		System.out.println("=================================");

		scan.close();
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		exam1();
	}

}
