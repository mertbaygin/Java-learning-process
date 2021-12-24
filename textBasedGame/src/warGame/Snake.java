package warGame;

import java.util.Random;
public class Snake extends Obstacle {

	public Snake() {
		super(4,"Snake",randomDamage(), 12, 0);
		
	}
	
	public static int randomDamage() {
		Random r = new Random();
		return r.nextInt(4)+3; //3 or 6 
	}
	
	
}
