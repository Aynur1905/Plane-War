package proje;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Enemy2 implements Enemies {
	
	private Image enemy;
	private int x, y;
	private int direction;

	public static final int height = 70;					
	public static final int width = 70;	
	
	private int heart = 2;
	private int speed;
	
	private Timer shooting;
	
	public Enemy2(int x, int y, int direction) {
		
		this.x = x;
		this.y = y;
		this.direction = direction;
		
		if(SelectScreen.select == 1) {
			speed = 4;
		}else if(SelectScreen.select == 2) {
			speed = 4;
		}
		else if(SelectScreen.select == 3) {
			speed = 6;
		}
		
		try {
			enemy =ImageIO.read(StartScreen.class.getResource("game\\Enemies\\Enemy_05.png"));
		} catch (IOException ýe) {
			ýe.printStackTrace();
		}
		
		if(direction == 2 || direction == 3) {
			shooting = new Timer(1400, new ActionListener() {
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
	/*	Graphics2D g2d = (Graphics2D)g;
		AffineTransform old = g2d.getTransform();
		g2d.rotate(Math.toRadians(45));
		g2d.drawImage(enemy, x, y, width, height, null);
		g2d.setTransform(old);
		*/
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

