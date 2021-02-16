package example2;

import java.util.Scanner;

public class Start {
	/*
	 *[���� ��� ��ɾ�]
	 *push 10  
	 *pop     : ����ִ� ���¿��� pop���� ���� ������ �ذ� �ʿ�!
	 *gettop
	 *clear	 
	 *exit 
	 *-> ��� ��ɾ� ó�� �� ������ ���������� ����� ��(printAll)
	 */
	public static void exam1() {
		Scanner scan = new Scanner(System.in);	//import java.util
		MyLinkedStack stack = new MyLinkedStack();		
		
		System.out.println("-------------------------------------------");
		System.out.println(" ��ɾ� ��� ����(���Ḯ��Ʈ) �׽�Ʈ");
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
					System.out.println("POP�� ����� : " + (int)stack.Pop());
				}
				catch(Exception ex) {
					System.out.println("����ִ� ����");
				}
			}
			else if(sp[0].equals("gettop")) {  //gettop 
				try {
					System.out.println("TOP�� ����� �� : " + (int)stack.GetTop());
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
		System.out.println(" ���α׷��� �����մϴ�.");
		System.out.println("-------------------------------------------");
		
		scan.close();
	}
	
	public static void main(String[] args) {
		exam1();
	}
}
