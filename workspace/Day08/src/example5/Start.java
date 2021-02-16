package example5;

public class Start {

	public static String ReverseString(String str) {
		MyStack stack = new MyStack(str.length());
		String rstr = "";

		for (int i = 0; i < str.length(); i++) {
			stack.Push(str.charAt(i));//한글자식 push
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
	//-----------------------------------------------

	//중위 -> 후위(공백처리)
	public static void postfix(String str) {
		MyStack stack =new MyStack();

		char[] temp = str.toCharArray();//문자열 정보를 배열로 빼오기
		for(char t: temp) {
			if(t>='A' && t<='Z') {//피연산자
				System.out.print(t+" ");
			}else if(t=='+' || t=='-'|| t=='*' || t=='/') {
				stack.Push(t);
			}else if(t==')') {
				char pop = (char)stack.Pop();
				System.out.print(pop+" ");
			}
		}//for
	}

	//1. 중위 표기법 문자열을 후위 표기법 문자열로 변환해서 반환처리
	//2. 피연산자 : 문자를 숫자형 문자 변환('0' ~ '9')
	public static String postfix1(String str) {
		MyStack stack =new MyStack();
		String result ="";
		
		char[] temp = str.toCharArray();//문자열 정보를 배열로 빼오기
		for(char t: temp) {
			if(t>='0' && t<='9') {//피연산자
				result +=t+" ";	//System.out.print(t+" ");
			}else if(t=='+' || t=='-'|| t=='*' || t=='/') {
				stack.Push(t);
			}else if(t==')') {
				char pop = (char)stack.Pop();
				result +=pop+" ";//System.out.print(pop+" ");
			}
		}//for
		
		return result;
	}

	//십의 자리 이상 문자열 형태 적용가능한 알고리즘
	public static String postfix2(String str) {
		MyStack stack = new MyStack();
		String result = "";
		char[] temp = str.toCharArray();
		
		for (char t :temp) {
			if(t>='0' && t<='9') {//피연산자
				result +=t;	//System.out.print(t+" ");//<----------(1)
			}else if(t=='+' || t=='-'|| t=='*' || t=='/') {
				result+=" ";
				stack.Push(t);
			}else if( t==')' ) {
				result+=" ";//<-----------------------------------(2)
				char pop = (char)stack.Pop();
				result +=pop+" ";//System.out.print(pop+" ");
			}
		}
		//스택에 남은 마지막 연산자를 pop<-----------------------------(3)
		char pop = (char)stack.Pop();
		result +=pop+" ";//System.out.print(pop+" ");
	
		return result;
	}

	//십의 자리 이상 문자열 형태 적용가능한 알고리즘
	public static String postfix2_1(String str) {
		MyStack stack = new MyStack();
		char[] temp = str.toCharArray();
		String result = "";

		for (int i=0;i<temp.length;i++) {
			if (temp[i] >= '0' && (int) temp[i] <= '9') {
				do{
					result += temp[i];
					i++;   //<=======================================
				}while(temp[i] >= '0' && (int) temp[i] <= '9');
				
				result+= " ";  //공백처리 <----------------------------------
				
			} else if (temp[i] == '+' || temp[i] == '*' || temp[i] == '/' || temp[i] == '-') {
				stack.Push(temp[i]);
			} else if (temp[i] == ')') {
				result += (stack.Pop() + " ");
			}
		}
		return result;
	}

	
	public static void exam3() {
		postfix("(A + (B * C))");
		System.out.println();
		System.out.println(postfix1("(1 + (3 * 4))"));
		System.out.println(postfix2("23 + (4 * 235)"));
		System.out.println(postfix2_1("23 + (4 * 235)"));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		exam1();
		exam2();
		exam3();
	}

}
