package sample;
import java.util.Scanner;

public class BitGlobal {
	static Scanner sc = new Scanner(System.in);
	//메서드
	public static void Logo() {
		System.out.println("*****************************************");
		System.out.println(" Java 전문가 과정");
		System.out.println(" 2021.02.09");
		System.out.println(" 배열자료구조를 활용한 회원 관리 프로그램");
		System.out.println(" 최창민");
		System.out.println("*****************************************");
		Pause();
	}
	
	public static void Ending() {
		System.out.println("*****************************************");
		System.out.println(" 프로그램을 종료합니다.");
		System.out.println("*****************************************");
	}
	
	//메뉴
	public static char MenuPrint() {
		System.out.println("*****************************************");
		System.out.println(" [0] 프로그램 종료");
		System.out.println(" [1] 저장");
		System.out.println(" [2] 검색");
		System.out.println(" [3] 수정");
		System.out.println(" [4] 삭제");
		System.out.println("*****************************************");
		System.out.print(" >> ");
		return sc.nextLine().charAt(0);
	}

	//Pause 멈추는 기능
	public static void Pause() {
		System.out.println("Enter키를 누르세요.....");
		sc.nextLine();
	}
}
