package proje;

import java.util.Random;

public class RandomEnemyFactory {

	private int height;					
	private int width;	
	private int difficulty;
	
	Random rand = new Random();
	
	public RandomEnemyFactory(int width, int height) {
		this.height = height;
		this.width = width;
		difficulty = SelectScreen.select;
	}
	
	public Enemies create() {
		Enemies enemy = null;
		int random = rand.nextInt(3);
		int direction = 1;
		
		if(difficulty == 1) {
			direction = 1;
		}else if(difficulty == 2) {
			direction = rand.nextInt(3) + 1;
			
		}else if(difficulty == 3) {
			direction = rand.nextInt(5) + 1;
		}
		
		switch (random) {
		case 0:
			if(direction == 1) {
				enemy = new Enemy2(rand.nextInt((width - Enemy2.width)),(-Enemy2.height), direction);
			}
			else if(direction == 2) {
				enemy = new Enemy2((- Enemy2.width), rand.nextInt((height - Enemy2.height)), direction);
			}
			else if(direction == 3) {
				enemy = new Enemy2((width + Enemy2.width), rand.nextInt((height - Enemy2.height)), direction);
			}
			else if(direction == 4) {
				enemy = new Enemy2((- Enemy2.width), rand.nextInt((height - Enemy2.height)), direction);
			}
			else if(direction == 5) {
				enemy = new Enemy2((width + Enemy2.width), rand.nextInt((height - Enemy2.height)), direction);
			}
			break;
		case 1:
		case 2:
			if(direction == 1) {
				enemy = new Enemy(rand.nextInt((width - Enemy.width)),(-Enemy.height), direction);
			}
			else if(direction == 2) {
				enemy = new Enemy((- Enemy.width), rand.nextInt((height - Enemy.height)), direction);
			}
			else if(direction == 3) {
				enemy = new Enemy((width + Enemy.width), rand.nextInt((height - Enemy.height)), direction);
			}
			else if(direction == 4) {
				enemy = new Enemy((- Enemy.width), rand.nextInt((height - Enemy.height)), direction);
			}
			else if(direction == 5) {
				enemy = new Enemy((width + Enemy.width), rand.nextInt((height - Enemy.height)), direction);
			}
			break;
		}
		
		return enemy;
	}
}
