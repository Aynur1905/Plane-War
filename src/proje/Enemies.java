package proje;

import java.awt.Graphics;

public interface Enemies {
	public void shoot();

	public void update();

	public void draw(Graphics g);
	
	public void timerStop();

	public int getY();
	
	public int getX();
	
	public int getHeight();

	public  int getWidth();
	
	public  int getHeart();
	
	public  void setHeart(int heart);
}
