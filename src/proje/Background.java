package proje;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background implements Component{
	int x;					
	double y1, y2;
	double speed;
	
	private int height;					
	private int width;	
	
	Image background1;
	Image background2;
	
	Image starBig;
	
	Image starMedium;
	
	double starBigY1, starBigY2;
	double starBigSpeed;

	double starMediumY1, starMediumY2;
	double starMediumSpeed;
	
    public Background(int width, int height) {
    	
    	this.height = height;
		this.width = width;
		
		speed = 0.3;
		
		x = 0;
		y1 = 0;
		y2 = y1 - height;
		
		starBigY1 = 0;
		starBigY2 = -height;
		
		starBigSpeed = 0.5;
		
		starMediumY1 = 0;
		starMediumY2 = -height;
		
		starMediumSpeed = 0.7;
		
		try {
			background1 =ImageIO.read(StartScreen.class.getResource("game\\Background\\Bottom.png"));
			background2 =ImageIO.read(StartScreen.class.getResource("game\\Background\\Top.png"));
		} catch (IOException ýe) {
			ýe.printStackTrace();
		}
		
		try {
			starBig =ImageIO.read(StartScreen.class.getResource("game\\Background\\StarsBig.png"));
			starMedium =ImageIO.read(StartScreen.class.getResource("game\\Background\\StarsMedium.png"));
		} catch (IOException ýe) {
			ýe.printStackTrace();
		}
		
		
	}

	@Override
	public void update() {
		y1 += speed;
		y2 += speed;
		
		if((y1 - speed) > height)
			y1 = -height;
		if((y2 - speed) > height)
			y2 = -height;
	
		if(starBigY1  > height)
			starBigY1 = -height;
		if(starBigY2 > height)
			starBigY2 = -height;
		
		if(starMediumY1  > height)
			starMediumY1 = -height;
		if(starMediumY2 > height)
			starMediumY2 = -height;
		
		starBigY1 += starBigSpeed;
		starBigY2 += starBigSpeed;
		
		starMediumY1 += starMediumSpeed;
		starMediumY2 += starMediumSpeed;
	}

	@Override
	public void drawComponent(Graphics g) {
		g.drawImage(background1, x, (int)y1, width, height, null);
		g.drawImage(background2, x, (int)y2, width, height, null);
	
		g.drawImage(starBig, x, (int)starBigY1, width, height, null);
		g.drawImage(starBig, x, (int)starBigY2, width, height, null);
		
		g.drawImage(starMedium, x, (int)starMediumY1, width, height, null);
		g.drawImage(starMedium, x, (int)starMediumY2, width, height, null);
	}


}
