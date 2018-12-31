package proje;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class GameMain extends JFrame {
	
	public int width;	
	public int height;
	
	private int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public GameMain() {
		width = (int)(screenWidth/2.5);
		height = screenHeight - 35;
		setTitle("Plane Wars");
		setBounds((screenWidth/4) + 30, 0, width, height);
		GameMainPanel gmp = new GameMainPanel(width, height);
		add(gmp);
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
/*	public static void main(String[] args) {
		GameMain gm = new GameMain();
	}
	
*/
}
