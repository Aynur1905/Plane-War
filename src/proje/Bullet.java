package proje;

import java.awt.Graphics;

public interface Bullet {

	public void update();

	public void drawComponent(Graphics g);

	public int getY();
	
	public int getX();
}
