package rspgame;

public class Player extends Interface{
	public Player() {
		
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
		case 4:
			output = "exit";
			break;
		}
		return output;
	}
}
