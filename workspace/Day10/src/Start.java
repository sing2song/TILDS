import java.sql.Connection;
import java.sql.DriverManager;

public class Start {


	public static void exam1() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception ex) {
			System.out.println("오류 : " + ex.getMessage());
		}
	}

	public static void exam2() {
		Connection conn;
		try {
			//드라이버클래스://호스트주소:포트/데이터베이스명""아이디""패스워드"
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampleDB","root","ssong");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","root","ssong");
			System.out.println("데이터 베이스 연결 성공");
		}catch(Exception ex) {
			System.out.println("에러 : "+ ex.getMessage());
		}
	}
	public static void main(String[] args) {
		exam2();
	}


}
