package rspgame;

public class Computer extends Interface {
	
	public Computer() {
		
	}
	int getNum() {
		int num;
		num = (int)(Math.random()*3 + 1);
		return num;
	}
	@Override
	String getString(int input) {
		switch(input) {
		case 1:
			output = "����";
			break;
		case 2:
			output = "����";
			break;
		case 3:
			output = "��";
			break;
		}
		return output;
	}
}
	
