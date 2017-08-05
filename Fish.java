import java.util.Random;

public class Fish extends GameObject {
	
	public Fish() {
		super(5, 5, 1);
	}
	Random random = new Random();
	
	@Override
    public void move() {
		switch(random.nextInt(4)+1) {
		case 1:
		this.x -= distance;
		break;
		case 2:
		this.y += distance;
		break;
		case 3:
		this.y -= distance;
		break;
		case 4:
		this.x += distance;
		break;
		}
	}

	public char getShape() {
		return '@';
	}

}
