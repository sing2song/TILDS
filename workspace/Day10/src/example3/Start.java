package example3;

public class Start {
	public static void exam1() {
		MyHash hs = new MyHash(10);
		int value = 0;
		for(int i=0; i<1000; i++) {
			value = (int)(Math.random()*100) + 1;
			hs.Insert(value);
			//hs.PrintAll();
		}
		
		hs.PrintAll();
		
		//검색
		Object obj = hs.Select(value);
		if(obj == null) {
			System.out.println("없다.");
		}
		else
			System.out.println("검색결과 : " + (int)obj);
	}
	
	public static void main(String[] args) {
		exam1();
	}
}
