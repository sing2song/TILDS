package team;

import java.util.Scanner;

public class Start {

	public static void run() {
		Scanner scan = new Scanner(System.in);
		ReservationSystem rs = new ReservationSystem();
		
		while(true) {
			System.out.println("[버스 예약 시스템]");
			System.out.println("1. 버스\t 2.사람\t 3.예약\t");
			System.out.print(">>");
			int menu=scan.nextInt();
			
			switch(menu) {
			case 1: break;
			case 2: break;
			case 3: break;
			}
			
		}
	}
	public static void main(String[] args) {
		
		run();	
		
	}

}
