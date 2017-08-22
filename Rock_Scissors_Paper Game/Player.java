package rspgame;

public class Player extends Interface{
	public Player() {
		
	}
	@Override
	String getString(int input) {
		switch(input) {
		case 1:
			output = "가위";
			break;
		case 2:
			output = "바위";
			break;
		case 3:
			output = "보";
			break;
		case 4:
			output = "exit";
			break;
		}
		return output;
	}
}
