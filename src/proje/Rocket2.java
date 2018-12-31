package proje;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rocket2  implements Bullet{

	private Image rocket;
	
	private double speed;
	public int x, y;

	public static final int height = 60;					
	public static final int width = 23;	
	
	public Rocket2(int x, int y) {
		if(SelectScreen.select == 1) {
			speed = 4;
		}else if(SelectScreen.select == 2) {
			speed = 6;
		}
		else if(SelectScreen.select == 3) {
			speed = 5;
		}
		
		this.x = x;
		this.y = y;

		try {
			rocket = ImageIO.read(StartScreen.class.getResource("game\\Bullets\\2.png"));
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
		g.drawImage(rocket, x, y, width, height, null);
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

}