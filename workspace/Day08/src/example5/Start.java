package example5;

public class Start {

	public static String ReverseString(String str) {
		MyStack stack = new MyStack(str.length());
		String rstr = "";

		for (int i = 0; i < str.length(); i++) {
			stack.Push(str.charAt(i));
		}

		//System.out.println("============== 스택에 쌓은 문자 전체 출력 ==============");
		//stack.PrintAll();

		while (true) {
			Object item = stack.Pop();
			if (item == null)
				break;
			rstr += (char) item;
		}
		return rstr;
	}

	public static String dectobinary(int data) {
		MyStack stack = new MyStack();
		String result = "";

		while(data >= 2) {
			stack.Push(data%2);	//나머지값을 스택에 쌓아나가는 과정!
			data = data/2;
		}
		stack.Push(data);
		//==============================================

		while(!stack.IsEmpty()) {
			try {
				
				result += stack.Pop();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	
	
	public static void exam1() {
        String str = "abcdefg";
        String rstr = ReverseString(str);
        System.out.println("원본 :"+ str);		//abcdefg
        System.out.println("변경 :"+ rstr);	    //gfedcba
	}
	
	public static void exam2() {
		System.out.println(dectobinary(245));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		exam1();
		exam2();
	}

}
