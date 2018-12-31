package proje;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Enemy implements Enemies {
	
	private Image enemy;
	private int x, y;
	private int direction;

	public static final int height = 40;					
	public static final int width = 40;	
	
	private int heart = 1;
	
	private int speed;
	
	private Timer shooting;
	
	public Enemy(int x, int y, int direction) {
		
		this.x = x;
		this.y = y;
		this.direction = direction;
		
		if(SelectScreen.select == 1) {
			speed = 3;
		}else if(SelectScreen.select == 2) {
			speed = 3;
		}
		else if(SelectScreen.select == 3) {
			speed = 5;
		}
		
		try {
			enemy =ImageIO.read(StartScreen.class.getResource("game\\Enemies\\Enemy_01.png"));
		} catch (IOException ýe) {
			ýe.printStackTrace();
		}
		if(direction == 2 || direction == 3) {
			shooting = new Timer(1500, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					shoot();
				}
				
			});
			shooting.start();
		}
		
	}

	@Override
	public void update() {
		if(direction == 1) {
			y += speed;
		}else if(direction == 2) {
			y -= speed;
			x += speed;
		}else if(direction == 3) {
			y -= speed;
			x -= speed;
		}else if(direction == 4) {
			y += speed;
			x += speed;
		}else if(direction == 5) {
			y += speed;
			x -= speed;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(enemy, x, y, width, height, null);
		
	}
	
	@Override
	public void timerStop() {
		if(direction == 2 || direction == 3) shooting.stop();
		
	}

	@Override
	public void shoot() {
		Bullet bullet = new EnemyBullet(this);
		GameMainPanel.enemyBullets.add(bullet);
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getX() {
		return x;
	}
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	@Override
	public int getHeart() {
		return heart;
	}

	@Override
	public void setHeart(int heart) {
		this.heart = heart;	
	}
}
