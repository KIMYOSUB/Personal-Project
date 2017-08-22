package rspgame;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		Computer c = new Computer();       						//Computer ��ü ����
		Player p = new Player();           						//Player   ��ü ����
		Main m = new Main();                                    //�����̶� ��������
		
		Scanner sc = new Scanner(System.in);                    //Scanner  ��ü ����
		
		while(true) {
		System.out.print("����(1), ����(2), ��(3), ������(4)>>");
		int input = sc.nextInt();                                  //input�� ���� ���� ����
		int r = c.getNum();                                        //1~3���� �������� ���� ���ڸ� �����´�.
		String result = m.match(input, r, p);                      //�º� ����� String ������ �����´�.
		
		if(result.equals("win")) {
			m.info(p, c, input, r);
			System.out.println("�̰���ϴ�.");
		}
		else if(result.equals("lose")) {
			m.info(p, c, input, r);
			System.out.println("�����ϴ�.");
		}
		else if(result.equals("draw")) {
			m.info(p, c, input, r);
			System.out.println("�����ϴ�.");
		}
	}
}
	String match(int p, int c, Player a) {             			   //�÷��̾�, ��ǻ�Ͱ� ���� ���ڸ� ���� �¸�,�й�,��� ���� return
		if(p == 4) { 											   //�÷��̾ 4�� �Է��ϸ� ���α׷� ����
			System.out.println(a.getString(p));
			System.exit(0);
		}
		int value = p - c;										   //������ 1, ���� 2, �� �� 3�̶� ���� �غ��� �¸� ���θ� �� �� �ִ�.
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
		System.out.println("����� " + p.getString(input) + " : ��ǻ�� " + c.getString(r));
	}
}
