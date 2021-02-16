package test;

import java.util.Scanner;

public class Start {
	/*
	 *[ť ��� ��ɾ�]
	 *put 10  
	 *get     : ����ִ� ���¿��� get���� ���� ������ �ذ� �ʿ�!
	 *clear	 
	 *exit 
	 *-> ��� ��ɾ� ó�� �� ������ ���������� ����� ��(printAll)
	 */
	public static void exam1() {
		Scanner scan = new Scanner(System.in);	//import java.util
		MyLinkedQueue queue = new MyLinkedQueue();		
		
		System.out.println("-------------------------------------------");
		System.out.println(" ��ɾ� ��� ť(���Ḯ��Ʈ) �׽�Ʈ");
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
					System.out.println("GET�� ����� : " + (int)queue.Get());
				}
				catch(Exception ex) {
					System.out.println("����ִ� ����");
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
		System.out.println(" ���α׷��� �����մϴ�.");
		System.out.println("-------------------------------------------");
		
		scan.close();
	}
	
	public static void main(String[] args) {
		exam1();
	}
}
