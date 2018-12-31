package proje;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GameMainPanel extends JPanel {
	
	private Timer timer;
	private Timer createEnemy;
	private Timer createBullet;
	private Timer game_Over;
	private Timer heart;
	private Timer createRocket;
	
	private RandomEnemyFactory ref;
	private RandomRocketFactory rrf;
	
	public ArrayList<Component> components;
	public ArrayList<Enemies> enemies;
	public ArrayList<Bullet> bullets;
	public static ArrayList<Bullet> enemyBullets;
	public ArrayList<Bullet> rockets;
	
	private Player player;
	
	public int width;
	public int height;	
	
	private Image explosion1, explosion2;
	
	private int skor;
	
	public static boolean gameover;
	private Image gameOver;
	
	private byte boom;
	private Image boom1, boom2, boom3;
	
	private boolean patlama;
	private byte patlama1;
	
	private boolean olme;
	
	public GameMainPanel(int width, int height) {
		this.height = height;
		this.width = width;
		
		gameover = false;
		olme = false;
		patlama = false;
		
		boom = 3;
		patlama1 = 15;
		
		try {
			explosion1 = ImageIO.read(StartScreen.class.getResource("game\\VFX\\Enemy Hit Effect\\Enemy Hit Effect_01.png"));
			explosion2 = ImageIO.read(StartScreen.class.getResource("game\\VFX\\Enemy Hit Effect\\Enemy Hit Effect_01.png"));
			gameOver = ImageIO.read(StartScreen.class.getResource("game\\gameOver.png"));
			boom1 = ImageIO.read(StartScreen.class.getResource("game\\VFX\\Explosions\\1.png"));
			boom2 = ImageIO.read(StartScreen.class.getResource("game\\VFX\\Explosions\\2.png"));
			boom3 = ImageIO.read(StartScreen.class.getResource("game\\VFX\\Explosions\\3.png"));
		} catch (IOException ýe) {
			ýe.printStackTrace();
		}
		
		ref = new RandomEnemyFactory(width, height);
		rrf = new RandomRocketFactory(width, height);
		
		components = new ArrayList<Component>();
		enemies = new ArrayList<Enemies>();
		bullets = new ArrayList<Bullet>();
		enemyBullets = new ArrayList<Bullet>();
		rockets = new ArrayList<Bullet>();
		
		components.add(new Background(width, height));
		player = new Player(this);
		components.add(player);

		
		timer = new Timer(10, new ActionListener() {//(1000/60)saniyede 60 kez ekranýn deðiþmesi için
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		timer.start();
		
		game_Over = new Timer(200, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		heart = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				olme = false;
				heart.stop();
			}
		});
		
		if(SelectScreen.select == 3) {
			createEnemy = new Timer(900, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					createRandomEnemies();
				}
				
			});
			createEnemy.start();
			
			createBullet = new Timer(300, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					createBullet();
				}
				
			});
			createBullet.start();
		}else {
			createEnemy = new Timer(1100, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					createRandomEnemies();
				}
			});
			createEnemy.start();
			
			createBullet = new Timer(500, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					createBullet();
				}
				
			});
			createBullet.start();
		}
		
		createRocket = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				createRandomRockets();
			}
		});
		createRocket.start();
		
	
		
	}

	public void update() {
		for(Component com : components) {
			com.update();
		}
		if(enemies.size() > 0) {
			for(int i=0; i<enemies.size(); i++) {
				enemies.get(i).update();
				// y ekseninde ekranýn dýþýna çýktýðýnda silimesi
				if((enemies.get(i).getY() > height) ||  ((enemies.get(i).getY() + enemies.get(i).getHeight()) < -50)) {
					enemies.get(i).timerStop();
					enemies.remove(i);
				}//x ekseninde ekranýn dýþýna çýktý mý
				else if((enemies.get(i).getX() > width +50) ||  ((enemies.get(i).getX() + enemies.get(i).getWidth()) < -50)) {
					enemies.get(i).timerStop();
					enemies.remove(i);
				}
			}
		}
		for(int i=0; i<bullets.size(); i++) {
			bullets.get(i).update();
			if((bullets.get(i).getY() + 15) < 0) {//merminin boyutu 15
				bullets.remove(i);
			}
		}
		
		for(int i=0; i<enemyBullets.size(); i++) {
			enemyBullets.get(i).update();
			if((enemyBullets.get(i).getY() + 20) > height) {
				enemyBullets.remove(i);
			}
		}
		
		for(int i=0; i<rockets.size(); i++) {
			rockets.get(i).update();
			if((rockets.get(i).getY() + Rocket.height) > height) {
				rockets.remove(i);
			}
		}
		
		repaint();
	}
	
	public void paintComponent(Graphics g) {
	//	super.paintComponent(g);
		
		components.get(0).drawComponent(g);//background ilk çizilmeli
	
		if(enemies.size() > 0) {
			for(Enemies e : enemies) {
				e.draw(g);
			}
		}
		for(Bullet bul : bullets) {
			bul.drawComponent(g);
		}
		for(Bullet bul : enemyBullets) {
			bul.drawComponent(g);
		}
		for(Bullet bul : rockets) {
			bul.drawComponent(g);
		}
		
		components.get(1).drawComponent(g);//oyuncu en son çizilmeli
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("MV Boli", Font.BOLD, 30));
		g.drawString("Skor " + skor, 10, 33);
		
		collision(g);
		
		if(gameover) {
			if(boom == 3) {
				boom--;
				g.drawImage(boom1, player.x + 5, player.y + 5, player.playerW - 10, player.playerH - 10, null);
			}else if(boom == 2) {
				boom--;
				g.drawImage(boom2, player.x + 5, player.y + 5, player.playerW - 10, player.playerH - 10, null);
			}else if(boom == 1) {
				boom--;
				g.drawImage(boom3, player.x + 5, player.y + 5, player.playerW - 10, player.playerH - 10, null);
			}else {
				g.drawImage(gameOver, 0, 0, width, height, null);
				
			}	
		}
		
		if(patlama) {
			if(patlama1 >= 15) {
				patlama1--;
				g.drawImage(boom1, player.x + 5, player.y + 5, player.playerW - 10, player.playerH - 10, null);
			}else if(boom >= 10) {
				patlama1--;
				g.drawImage(boom2, player.x + 5, player.y + 5, player.playerW - 10, player.playerH - 10, null);
			}else if(boom >= 5) {
				patlama1--;
				g.drawImage(boom3, player.x + 5, player.y + 5, player.playerW - 10, player.playerH - 10, null);
			}else {
				patlama = false;
				patlama1 = 15;	
			}	
		}
	}
	
	public void createRandomEnemies() {
		enemies.add(ref.create());
	}
	
	public void createRandomRockets() {
		rockets.add(rrf.create());
	}
	
	public void createBullet() {
		bullets.add(new PlayerBullet1(player));
	}
	
	public void collision(Graphics g) {
		Rectangle oyuncu = new Rectangle(player.x + 5, player.y + 5, player.playerW - 10, player.playerH - 10);
		for(int j=0; j < enemies.size(); j++) {
			for(int i=0; i < bullets.size(); i++) {
				if((enemies.get(j).getX() < (bullets.get(i).getX() + PlayerBullet1.width )) && ((enemies.get(j).getX() + enemies.get(j).getWidth()) > (bullets.get(i).getX() + PlayerBullet1.width )) && (enemies.get(j).getY() < bullets.get(i).getY()) && ((enemies.get(j).getY() + enemies.get(j).getHeight()) > (bullets.get(i).getY() + PlayerBullet1.height ))) {
					if(enemies.get(j).getHeart() > 0) {
						g.drawImage(explosion1, enemies.get(j).getX(), enemies.get(j).getY(), enemies.get(j).getWidth(), enemies.get(j).getHeight(), null);
						enemies.get(j).setHeart(enemies.get(j).getHeart() - 1);
						if(enemies.get(j) instanceof Enemy) skor += 25;
						else if(enemies.get(j) instanceof Enemy2) skor += 30;
					}else {
						g.drawImage(explosion2, enemies.get(j).getX(), enemies.get(j).getY(), enemies.get(j).getWidth(), enemies.get(j).getHeight(), null);
						if(enemies.get(j) instanceof Enemy) skor += 50;
						else if(enemies.get(j) instanceof Enemy2) skor += 60;
						enemies.get(j).timerStop();
						enemies.remove(j);
					}
					 bullets.remove(i);
				}
			}
			Rectangle dusman = new Rectangle(enemies.get(j).getX()+5, enemies.get(j).getY()+5, enemies.get(j).getWidth()-10, enemies.get(j).getHeight()-10);
			if(oyuncu.intersects(dusman) && olme == false) {
				enemies.remove(j);
				olme = true;
				heart.start();
				if(player.heart > 0) {
					player.heart--;
					patlama = true;
				}else {
					 gameover = true;
					 timer.stop();
					 createEnemy.stop();
					 createBullet.stop();
					 game_Over.start();
				}
	           
			}
		}
		
		for(int k = 0; k < enemyBullets.size(); k++) {
			Rectangle mermi = new Rectangle(enemyBullets.get(k).getX() + 5, enemyBullets.get(k).getY() + 5, 10, 10);
			if(oyuncu.intersects(mermi) && olme == false) {
				enemyBullets.remove(k);
				olme = true;
				heart.start();
				if(player.heart > 0) {
					player.heart--;
					patlama = true;
				}else {
					 gameover = true;
					 timer.stop();
					 createEnemy.stop();
					 createBullet.stop();
					 game_Over.start();
				}
			}
		}
		for(int k = 0; k < rockets.size(); k++) {
			Rectangle mermi = new Rectangle(rockets.get(k).getX() + 5, rockets.get(k).getY() + 5, Rocket.width - 10, Rocket.height - 10);
			if(oyuncu.intersects(mermi) && olme == false) {
				rockets.remove(k);
				olme = true;
				heart.start();
				if(player.heart > 0) {
					player.heart--;
					patlama = true;
				}else {
					 gameover = true;
					 timer.stop();
					 createEnemy.stop();
					 createBullet.stop();
					 game_Over.start();
				}
			}
		}
	}

}
