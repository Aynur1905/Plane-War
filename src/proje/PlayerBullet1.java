package proje;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerBullet1  implements Bullet{

	private Image bullet;
	
	private Player player;
	
	private double speed;
	public int x, y;

	public static final int height = 15;					
	public static final int width = 5;	
	
	public PlayerBullet1(Player player) {
		this.player = player;
		if(SelectScreen.select == 1) {
			speed = 5;
		}else if(SelectScreen.select == 2) {
			speed = 6;
		}
		else if(SelectScreen.select == 3) {
			speed = 8;
		}
		x = Player.x + ((71 + width)/2);//75 player'ýn geniþliði
		y = Player.y + height;
 
		try {
			bullet = ImageIO.read(StartScreen.class.getResource("game\\Weapons\\Bullet.png"));
		} catch (IOException ýe) {
			ýe.printStackTrace();
		}
	}

	@Override
	public void update() {
		y -= speed;
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
