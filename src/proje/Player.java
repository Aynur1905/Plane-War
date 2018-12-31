package proje;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player implements Component{

	GameMainPanel gmp;
	private Image player;
	static int playerW, playerH;
	static int x , y;
	
	private byte burnout;
	private Image engine1, engine2, engine3;
	
	public static byte heart = 2;
	
	public Player(GameMainPanel gmp) {
		burnout = 3;
		
		try {
			switch(PlaneSelect.secilenUcak) {
			case 0:
			case 1:
				playerW = 75;
				playerH = 75;
				player = ImageIO.read(StartScreen.class.getResource("game\\Player\\LazerShip.png"));
				break;
			case 2:
				playerW = 90;
				playerH = 90;
				player = ImageIO.read(StartScreen.class.getResource("game\\Player\\1.png"));
				break;
			case 3:
				playerW = 90;
				playerH = 90;
				player = ImageIO.read(StartScreen.class.getResource("game\\Player\\2.png"));
				break;
			case 4:
				playerW = 90;
				playerH = 90;
				player = ImageIO.read(StartScreen.class.getResource("game\\Player\\3.png"));
				break;
			case 5:
				playerW = 90;
				playerH = 90;
				player = ImageIO.read(StartScreen.class.getResource("game\\Player\\4.png"));
				break;
			case 6:
				playerW = 90;
				playerH = 90;
				player = ImageIO.read(StartScreen.class.getResource("game\\Player\\5.png"));
				break;
			}
			
			engine1 =  ImageIO.read(StartScreen.class.getResource("game\\VFX\\Engines\\1.png"));
			engine2 =  ImageIO.read(StartScreen.class.getResource("game\\VFX\\Engines\\2.png"));
			engine3 =  ImageIO.read(StartScreen.class.getResource("game\\VFX\\Engines\\3.png"));
		} catch (IOException ýe) {
			ýe.printStackTrace();
		}
		
		x = (gmp.width - playerW)/2;
		y = gmp.height - playerH - 20;
		
		this.gmp = gmp;
		
	   gmp.addMouseMotionListener(new MouseMotionListener() {

		@Override
		public void mouseDragged(MouseEvent e) {
			if(!GameMainPanel.gameover) {
				if((e.getX() - playerW / 2) > 0 && ((e.getX() - playerW / 2) + playerW )< gmp.width)
					x = e.getX() - playerW / 2;
				if((e.getY() - playerH / 2) > 0 && (e.getY() - playerH / 2) < gmp.height)
					y = e.getY() - playerH / 2;	
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
		} 
		});
	   
	   gmp.addMouseListener(new MouseListener() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(!GameMainPanel.gameover) {
				x = e.getX() - playerW / 2;
			    y = e.getY() - playerH / 2;	
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		   
	   });
	   

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawComponent(Graphics g) {
		if(!GameMainPanel.gameover) {
			if(burnout == 3) {
				burnout--;
				g.drawImage(engine1, ((x - 7) + (playerW)/2 ) , y + playerH - 5, 15, 15, null);
			}else if(burnout == 2) {
				burnout--;
				g.drawImage(engine2, ((x - 7) + (playerW)/2) , y + playerH - 5, 15, 15, null);
			}else if(burnout == 1) {
				burnout = 3;
				g.drawImage(engine3, ((x - 5) + (playerW)/2) , y + playerH - 5, 10, 10, null);
			}
		}
		
		g.drawImage(player, x, y, playerW, playerH, null);
		
		switch(heart){
		    case 3:
		      g.drawImage(player, gmp.width - 150 ,10, 40, 40, null);
			case 2:
			   g.drawImage(player, gmp.width - 100 ,10, 40, 40, null);
			case 1:
			   g.drawImage(player, gmp.width - 50 ,10, 40, 40, null);
			   
		}
		
	}

}
