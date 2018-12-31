package proje;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EnemyBullet implements Bullet{

	private Image bullet;
	
	private Enemies enemy;
	
	private double speed;
	public int x, y;

	public static final int height = 20;					
	public static final int width = 20;	
	
	public EnemyBullet(Enemies enemy) {
		this.enemy = enemy;
		if(SelectScreen.select == 1) {
			speed = 3;
		}else if(SelectScreen.select == 2) {
			speed = 5;
		}
		else if(SelectScreen.select == 3) {
			speed = 7;
		}
		
		x = enemy.getX() + ((enemy.getWidth() + width)/2);
		y = enemy.getY()  + height;

		try {
			bullet = ImageIO.read(StartScreen.class.getResource("game\\Weapons\\Ball.png"));
		} catch (IOException ýe) {
			ýe.printStackTrace();
		}
	}

	@Override
	public void update() {
		y += speed;
	}

	@Override
	public void drawComponent(Graphics g) {
		g.drawImage(bullet, x, y, width, height, null);
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

}

