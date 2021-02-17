package example2;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParseTree ptree = new ParseTree();
		String str="3 2 + 4 * 2 -";
		ptree.MakeParseTree(str);
		
		//체크
		//1. 갯수 : 7개
		System.out.println("노드의 수 : "+ptree.getCount());
		//2. 루트 노드의 연산자 : -
		System.out.println("Root Node : "+(char)ptree.getRootNodeValue());
		//3. 순회
		System.out.print("전위(재 귀) : ");	ptree.PreOrder();
		System.out.print("전위(반복문) : "); ptree.PreOrder_NonRe();
		
		System.out.print("중위(재 귀) : ");	ptree.InOrder();
		System.out.print("중위(반복문) : "); 	ptree.InOrder_NonRe();
		
		System.out.print("후위(재 귀) : ");	ptree.PostOrder();
		
	}

}
