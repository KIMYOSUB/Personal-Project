
public class Game {
	public static void main(String[] args) {
		System.out.println("** Bear�� Fish �Ա� ������ �����մϴ�.**");
		
		Bear b = new Bear(); //bear ��ü ����
		Fish f = new Fish(); //Fish ��ü ����
		int count = -1;
		
		while(true) {
			if(count != -1) {
				System.out.println("count: " + count);
				System.out.print("����(a), �Ʒ�(s), ��(d), ������(f) >>");
				b.move();
				
				int num = count%5;          //5�� ���� �������� (0,1,2,3,4)(0,1,2,3,4).....�ݺ�
				if (num > 2) {
					f.move();               //5�� �� 3���� ������
					}
				} //ù �ϸ� ���� ����
			
			for(int i=0; i<10; i++) {                     //��                  
				
				System.out.println();                     //������
				
				for(int j=0; j<20; j++) {                 //��
					
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
			
   		}          //while��
		System.out.print("Bear Wins!!");
	}
}