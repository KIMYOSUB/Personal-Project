package rspgame;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		Computer c = new Computer();       						//Computer 객체 생성
		Player p = new Player();           						//Player   객체 생성
		Main m = new Main();                                    //심판이라 생각하자
		
		Scanner sc = new Scanner(System.in);                    //Scanner  객체 생성
		
		while(true) {
		System.out.print("가위(1), 바위(2), 보(3), 끝내기(4)>>");
		int input = sc.nextInt();                                  //input에 내가 낼거 저장
		int r = c.getNum();                                        //1~3까지 랜덤으로 뽑은 숫자를 가져온다.
		String result = m.match(input, r, p);                      //승부 결과를 String 값으로 가져온다.
		
		if(result.equals("win")) {
			m.info(p, c, input, r);
			System.out.println("이겼습니다.");
		}
		else if(result.equals("lose")) {
			m.info(p, c, input, r);
			System.out.println("졌습니다.");
		}
		else if(result.equals("draw")) {
			m.info(p, c, input, r);
			System.out.println("비겼습니다.");
		}
	}
}
	String match(int p, int c, Player a) {             			   //플레이어, 컴퓨터가 정한 숫자를 통해 승리,패배,비김 여부 return
		if(p == 4) { 											   //플레이어가 4를 입력하면 프로그램 종료
			System.out.println(a.getString(p));
			System.exit(0);
		}
		int value = p - c;										   //가위는 1, 바위 2, 보 는 3이라 가정 해보면 승리 여부를 알 수 있다.
		if((value == 1) || (value == -2)) {                         
			return "win";
		}
		else if(value == 0) {
			return "draw";
		}
		else
			return "lose";
	}
	void info(Player p, Computer c, int input, int r) {
		System.out.println("사용자 " + p.getString(input) + " : 컴퓨터 " + c.getString(r));
	}
}
