package proje;

import java.util.Random;

public class RandomRocketFactory {
	
	private int height;					
	private int width;	
		
	Random rand = new Random();
		
	public RandomRocketFactory(int width, int height) {
		this.height = height;
		this.width = width;
	}
		
	public Bullet create() {
		Bullet rocket = null;
		int random = rand.nextInt(2);
			
    	switch (random) {
	    	case 0:
	    		rocket = new Rocket(rand.nextInt((width - Rocket.width)),(-Rocket.height));
		     break;
		    case 1:
		    	rocket = new Rocket2(rand.nextInt((width - Rocket2.width)),(-Rocket2.height));
			 break;
		}
			
		return rocket;
	}
}

