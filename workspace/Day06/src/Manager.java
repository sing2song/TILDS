
//데이터 및 기능관리
public class Manager {
	//싱글톤 패턴 코드 -----------------------------------------------
	//생성자 은닉!
	private Manager() {
		arr = new BitArray(InputMax());
	}

	//자신의 static 객체 생성
	private static Manager Singleton = new Manager();

	//내부적으로 생성된 자신의 객체를 외부에 노출 메서드
	public static Manager getInstance() {
		return Singleton;
	}
	//------------------------------------------------------------	

	private BitArray arr;

	//메서드
	public int InputMax() {
		return BitGlobal.InputNumber("저장 개수");
	}

	//기능메서드
	public void SelectAll(){
		//1. 저장개수 출력
		//2. 전체 데이터 정보를 출력[배열 알고리즘]- 전체 순회 
		System.out.println("[저장개수] " + arr.getSize() + "개");
		for(int i=0; i< arr.getSize(); i++)
		{
			Member mem = (Member)arr.getData(i);  //Down Casting...-> instanceof
			mem.Print();
		}
	}


	public void Insert() {
		try {
			//1.변수 선언[IN][OUT]
			//2.초기화 (IN변수는 초기화의 대상, OUT변수는 기본 초기화)
			int number=BitGlobal.InputNumber("회원번호");
			String name=BitGlobal.InputString("이름");
			String phone=BitGlobal.InputString("전화번호");
			char gender = BitGlobal.InputChar("성별");

			//3.연산-저장 (IN:연산에 사용되는 변수, OUT:연산의 결과값)
			Member mem=new Member(number,name,phone,gender);
			arr.Insert(mem);//Insert함수가 예외를 갖고있으므로 여기도 try-catch

			//4.결과출력
			System.out.println("저장 성공!");

		}catch(Exception ex) {
			System.out.println("[저장 실패] "+ex.getMessage());
		}
	}

	//검색 알고리즘(순차 검색)
	//회원번호를 전달 --> 배열의 idx 반환(실패 : -1)
	private int NumberToIdx(int number) {
		for(int i=0;i<arr.getSize();i++) {
			Member mem = (Member)arr.getData(i);
			if(mem.getNumber()==number) {
				//순차검색
				return i;
			}
		}
		return -1;
	}

	public void Select() {
		//1.변수 선언[IN]회원번호 [OUT]
		//2.초기화 (IN변수는 초기화의 대상, OUT변수는 기본 초기화)
		int number=BitGlobal.InputNumber("회원번호");
		//3.연산-저장 (IN:연산에 사용되는 변수, OUT:연산의 결과값)
		//  인덱스 = 검색함수를 호출(회원번호)
		//  if(결과체크)
		//  else
		//4.결과출력
		int idx=NumberToIdx(number);
		if(idx!=-1) {
			Member mem= (Member)arr.getData(idx);
			mem.Println();
		}else
			System.out.println("없는 번호입니다.");
	}

	//회원이름 전달-> 회원을 반환(실패 : 예외 발생
	private Member NameToMember(String name) throws Exception {
		for(int i=0;i<arr.getSize();i++) {
			Member mem = (Member)arr.getData(i);
			if(mem.getName() == name) {//담고있는 string이 같은지 체크
				//순차검색
				return  mem;
			}
		}
		throw new Exception("업는 회원입니다");
	}

	public void Update() {
		//1. 사용자에게 검색할 회원번호를 입력
		//2. 수정할 전화번호를 입력
		//3. 검색
		try {
			String name=BitGlobal.InputString("회원이름");
			String phone=BitGlobal.InputString("수정할 전화 번호");
			Member mem=NameToMember(name);
			//검색하는 과정에서 throw를 발생시키므로 바로 성공패턴을 진행 - try catch로 예외처리하기
			//4. 검색 결과에 따라 전화번호를 수정!
			mem.setPhone(phone);
			System.out.println("수정 성공");
		}catch(Exception ex) {
			System.out.println("[수정오류]"+ex.getMessage());
		}

	}

	public void Delete() {
		//사용자에게 회원번호 입력받아 검색 후 해당 회원을 삭제(BitArray.Delete함수를 활용)
		//전반적인 흐름은 Select와 유사하다.
		try {
			int number=BitGlobal.InputNumber("회원번호");
			int idx=NumberToIdx(number);
			if(idx==-1)
				throw new Exception("없는 회원번호 입니다.");
			
			arr.Delete(idx);
			System.out.println("삭제 되었습니다.");
			
		}catch(Exception ex) {
			System.out.println("[삭제 에러] "+ex.getMessage());
		}
	}
}
