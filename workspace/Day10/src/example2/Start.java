package example2;

import java.util.Scanner;

public class Start {

	private MyHashMap hmap = new MyHashMap(10);
	private Scanner sc = new Scanner(System.in);
	
	private void Insert(int number,String name,String phone, char gender) {
		if(hmap.Insert(number, new Member(number,name,phone,gender))) {
			System.out.println("성공");
		}else System.out.println("실패");
	}
	
	private void Select(int number) {
		Member mem = (Member)hmap.KeyToValue(number);
		if(mem==null) System.out.println("없다");
		else mem.Println();
	}
	
	private void Delete(int number) {
		if(hmap.Delete(number))
			System.out.println("삭제성공");
		else System.out.println("삭제실패");
	}
	
	public void Run() {
		while(true) {
			hmap.PrintAll();
			
			System.out.print(">> ");
			String str = sc.nextLine();
			String[] sp = str.split(" ");
			
			if(sp[0].equals("insert")) {//insert 회원번호 이름 전화번호 성별
				Insert(Integer.parseInt(sp[1]),
						sp[2],sp[3],sp[4].charAt(0));
			}else if(sp[0].equals("select")){//select 회원번호
				Select(Integer.parseInt(sp[1]));
			}
			else if(sp[0].equals("delete")) {//delete 회원번호
				Delete(Integer.parseInt(sp[1]));
			}
			else if(sp[0].equals("exit"))
				break;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Start().Run();
	}

}
