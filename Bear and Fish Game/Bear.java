import java.util.*;

public class Bear extends GameObject {
	Scanner input = new Scanner(System.in);
	public Bear () {
		super(0,0,1);
	}
	@Override
	public void move() {
		switch(input.next()) {
		case "a":
		this.x -= distance;
		break;
		case "s":
		this.y += distance;
		break;
		case "d":
		this.y -= distance;
		break;
		case "f":
		this.x += distance;
		break;
		default:
			System.out.println("Àß¸øµÈ ÀÔ·ÂÀÔ´Ï´Ù.");
		}
	}
	
	public char getShape() {
		return 'B';
	}
}
