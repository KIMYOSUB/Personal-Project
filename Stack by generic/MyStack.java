package practice;
import java.util.Scanner;

public class MyStack {
	public static void main(String[] args) {
		int input;
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in, "euc-kr");
		
		AStack<String> stc = new AStack<String>();       //객체 생성
		
		while(true) {
			
			System.out.println("[Stack statement : "+stc.tos+"/"+stc.stack.length+"]");
			System.out.print("1.push, 2.pop, 3.show, 4.exit :");
			input = sc.nextInt();
			
			if(input == 1) {
				System.out.print("------------------\n");
				System.out.print("push a element : ");
				String p = sc1.next();
				stc.push(p);
				System.out.print("------------------\n");
			}
			else if(input == 2) {
				stc.pop();                        //pop은 그냥 화면에 출력이 아닌 실제 배열에서 빠져나가도록 설정
			}
			else if(input == 3) {
				stc.show();
				System.out.print("\n");
			}
			else
				break;
		
		} // while 문

	}
}
