package example2;

import java.util.Scanner;

public class Start {

	public static void exam1(){
		Scanner scan = new Scanner(System.in);
		MyDList list1 = new MyDList();
		MyDList list2 = new MyDList();
		
		System.out.println("랜덤 정수 구성중...");
		for(int i=0;i<10;i++) {
			int num= (int)(Math.random()*30)+1;
			int num2= (int)(Math.random()*30)+1;
			
			list1.push_back(num);
			list2.push_back(num2);
		}
		
		System.out.println("[첫번째 리스트]");
		list1.Select_Nextall();
		System.out.println("[두번째 리스트]");
		list2.Select_Nextall();
		MyDList list3 = new MyDList(list1,list2);
		
		System.out.println("[연결한 리스트]");
		list3.Select_Nextall();
		
		scan.close();
	}
	
	public static void main(String[] args) {
		exam1();
	}

}
