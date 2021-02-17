package example4;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBSearchTree btree = new MyBSearchTree();
		System.out.print("저장 값 :");
		int num=-1;

		for(int i=0;i<10;i++) {
			num=(int)(Math.random()*100)+1;//1~100
			System.out.print(num+" ");
			//btree.Insert_NonRe(num);
			btree.Insert(num);
		}

		//결과 확인.....
		System.out.println("\n[순회 결과값]");
		btree.InOrder();

		//검색 테스트....
		//MyBSearchTree.Node node = bst.Search(value);
		MyBSearchTree.Node node = btree.Search_NonR(num);

		if(node == null)
			System.out.println("없다");
		else
			System.out.println("찾은값 : " + node.key);

		//-----------삭제-----------
		System.out.println(num+" 삭제");
		btree.Delete(num);

		//검색 테스트....
		//MyBSearchTree.Node node = bst.Search(value);
		node = btree.Search_NonR(num);

		if(node == null)
			System.out.println("없다");
		else
			System.out.println("찾은값 : " + node.key);
	}

}
