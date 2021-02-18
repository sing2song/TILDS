package example1;

public class Start {

	public static void exam1() {
		MyHash hs = new MyHash(10);
		int val=-0;
		for(int i=0;i<20;i++) {
			val = (int)(Math.random()*100)+1;
			hs.Insert(val);
		}
		
		hs.PrintAll();
		System.out.println("val : "+val);
		//검색
		int idx = hs.Select(val);
		if(idx==-1) System.out.println("없다.");
		else		System.out.println("검색결과 : "+hs.getData(idx));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		exam1();
	}

}
