package sample;
//실행의 흐름을 담당
public class App {

	//싱글톤 패턴 코드 -----------------------------------------------
	//생성자 은닉!
	private App() {
		Init();
	}
	
	//자신의 static 객체 생성
	private static App Singleton = new App();
	
	//내부적으로 생성된 자신의 객체를 외부에 노출 메서드
	public static App getInstance() {
		return Singleton;
	}
	//------------------------------------------------------------	
	
	//초기화 영역
	private void Init() {
		BitGlobal.Logo();
	}
	
	//반복적 실행 - 엔진
	public void Run() {
		while(true) {
			switch(BitGlobal.MenuPrint()) {
			case '0': return;
			case '1': System.out.println("Insert"); break;
			case '2': System.out.println("Select"); break;
			case '3': System.out.println("Update"); break;
			case '4': System.out.println("Delete"); break;			
			}	
			//멈춤
			BitGlobal.Pause();
		}
	}
	
	//종료처리 영역
	public void Exit() {
		BitGlobal.Ending();
	}
}
