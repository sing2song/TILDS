package example2;
//Member.java

//Member 객체 저장(number값을 key로 사용!)	[회원번호, 회원정보]
public class Member {
	private int number;//회원번호
	private String name;//이름
	private String phone;
	private char gender;
	
	//생성자
	public Member(int number,String name,String phone,char gender) {
		this.number=number;
		this.name=name;
		this.phone=phone;
		this.gender=gender;
	}
	
	public Member(int number,String name) {
		this(number,name,"",' ');
	}

	//getter & setter
	public int getNumber() {
		return number;
	}

	void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	//기능 메서드
	public void Println() {		
		System.out.println("[회원번호]"+number);		
		System.out.println("[이름]"+name);
		System.out.println("[전화번호]"+phone);
		System.out.println("[성별]"+gender);
	}
	
	public void Print() {
		System.out.println("["+number+"] "+name+" "+phone+" "+gender);
	}
}
