
public class Game {
	public static void main(String[] args) {
		System.out.println("** Bear의 Fish 먹기 게임을 시작합니다.**");
		
		Bear b = new Bear(); //bear 객체 생성
		Fish f = new Fish(); //Fish 객체 생성
		int count = -1;
		
		while(true) {
			if(count != -1) {
				System.out.println("count: " + count);
				System.out.print("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >>");
				b.move();
				
				int num = count%5;          //5로 나눈 나머지는 (0,1,2,3,4)(0,1,2,3,4).....반복
				if (num > 2) {
					f.move();               //5번 중 3번만 움직임
					}
				} //첫 턴만 실행 안함
			
			for(int i=0; i<10; i++) {                     //열                  
				
				System.out.println();                     //다음열
				
				for(int j=0; j<20; j++) {                 //행
					
					if(b.getY() == i && b.getX() == j) {
						System.out.print(b.getShape());
						continue;
						}
					if(f.getY() == i && f.getX() == j) {
						System.out.print(f.getShape());
						}
					else
						System.out.print("-");
					}
				}
			System.out.println();
			if(b.collide(f)) {
				break;
			}
			else {
				count ++;
			}
			
   		}          //while문
		System.out.print("Bear Wins!!");
	}
}
