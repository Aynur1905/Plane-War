package proje;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.SoftBevelBorder;

public class PlaneSelect extends JFrame {

	private GameMain gm;
	static byte secilenUcak = 0;
	
	public PlaneSelect() {
		Color c = new Color(30, 2, 72);
		
		Container container = getContentPane();
		container.setLayout(null);
		container.setBackground(c);
		
		JLabel text = new JLabel("AIRCRAFT CHOOSE");
		text.setForeground(Color.white);
		text.setFont(new Font ("MV Boli",Font.BOLD,15));
		text.setBounds(280, 10, 300, 40);
		container.add(text);
		
		JPanel p1 = new JPanel();
		p1.setBounds(10, 50, 220, 220);
		p1.setBackground(c);
		JRadioButton ucak1 = new JRadioButton();
		ucak1.setBackground(c);
		
	    JPanel p2 = new JPanel();
		p2.setBounds(240, 50, 220, 220);
		p2.setBackground(c);
		JRadioButton ucak2 = new JRadioButton();
		ucak2.setBackground(c);
		
		JPanel p3 = new JPanel();
		p3.setBounds(470, 50, 220, 220);
		p3.setBackground(c);
		JRadioButton ucak3 = new JRadioButton();
		ucak3.setBackground(c);
		
		JPanel p4 = new JPanel();
		p4.setBounds(10, 290, 220, 220);
		p4.setBackground(c);
		JRadioButton ucak4 = new JRadioButton();
		ucak4.setBackground(c);
		
		JPanel p5 = new JPanel();
		p5.setBounds(240, 290, 220, 220);
		p5.setBackground(c);
		JRadioButton ucak5 = new JRadioButton();
		ucak5.setBackground(c);
		
		JPanel p6 = new JPanel();
		p6.setBounds(470, 290, 220, 220);
		p6.setBackground(c);
		JRadioButton ucak6 = new JRadioButton();
		ucak6.setBackground(c);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(e->exitButtonClick());
		exitButton.setForeground(c);
		exitButton.setBackground(Color.WHITE);
		exitButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		exitButton.setBounds(10, 530, 120, 35);
		container.add(exitButton);
		    
		JButton startButton = new JButton("Start");
		startButton.addActionListener(e->StartButtonClick());
		startButton.setForeground(c);
		startButton.setBackground(Color.WHITE);
		startButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		startButton.setBounds(560, 530, 120, 35);
		container.add(startButton);
		
	    try {
	    	Image img1 = ImageIO.read(PlaneSelect.class.getResource("game\\Player\\LazerShip.png"));
		    img1 = img1.getScaledInstance(200, 200,  Image.SCALE_DEFAULT); 
		    ucak1.setIcon(new ImageIcon(img1));
		    
		    Image img2 = ImageIO.read(PlaneSelect.class.getResource("game\\Player\\1.png"));
		    img2 = img2.getScaledInstance(200, 200,  Image.SCALE_DEFAULT); 
		    ucak2.setIcon(new ImageIcon(img2));

		    Image img3 = ImageIO.read(PlaneSelect.class.getResource("game\\Player\\2.png"));
		    img3 = img3.getScaledInstance(200, 200,  Image.SCALE_DEFAULT); 
		    ucak3.setIcon(new ImageIcon(img3));
		    
		    Image img4 = ImageIO.read(PlaneSelect.class.getResource("game\\Player\\3.png"));
		    img4 = img4.getScaledInstance(200, 200,  Image.SCALE_DEFAULT); 
		    ucak4.setIcon(new ImageIcon(img4));
		    
		    Image img5 = ImageIO.read(PlaneSelect.class.getResource("game\\Player\\4.png"));
		    img5 = img5.getScaledInstance(200, 200,  Image.SCALE_DEFAULT); 
		    ucak5.setIcon(new ImageIcon(img5));
		    
		    Image img6 = ImageIO.read(PlaneSelect.class.getResource("game\\Player\\5.png"));
		    img6 = img6.getScaledInstance(200, 200,  Image.SCALE_DEFAULT); 
		    ucak6.setIcon(new ImageIcon(img6));
		    
		 } catch (Exception ex) {
		    System.out.println(ex);
		 }
		
		
		p1.add(ucak1);
		p2.add(ucak2);
		p3.add(ucak3);
		p4.add(ucak4);
		p5.add(ucak5);
		p6.add(ucak6);
		
		container.add(p1);
		container.add(p2);
		container.add(p3);
		container.add(p4);
		container.add(p5);
		container.add(p6);
		
		ucak1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				p1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
				p2.setBorder(null);	
				p3.setBorder(null);	
				p4.setBorder(null);	
				p5.setBorder(null);	
				p6.setBorder(null);	
				secilenUcak = 1;
			}
			
		});
		ucak2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				p2.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
				p1.setBorder(null);
				p3.setBorder(null);	
				p4.setBorder(null);	
				p5.setBorder(null);	
				p6.setBorder(null);	
				secilenUcak = 2;
			}
			
		});
		ucak3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				p3.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
				p1.setBorder(null);
				p2.setBorder(null);
				p4.setBorder(null);	
				p5.setBorder(null);	
				p6.setBorder(null);	
				secilenUcak = 3;
			}
			
		});
		ucak4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				p4.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
				p1.setBorder(null);
				p2.setBorder(null);
				p3.setBorder(null);	
				p5.setBorder(null);	
				p6.setBorder(null);	
				secilenUcak = 4;
			}
			
		});
		ucak5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				p5.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
				p1.setBorder(null);
				p2.setBorder(null);
				p3.setBorder(null);	
				p4.setBorder(null);	
				p6.setBorder(null);	
				secilenUcak = 5;
			}
			
		});
		ucak6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				p6.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
				p1.setBorder(null);
				p2.setBorder(null);
				p3.setBorder(null);	
				p4.setBorder(null);	
				p5.setBorder(null);	
				secilenUcak = 6;
			}
			
		});
		
		setUndecorated(true);
		setVisible(true);
		setSize(690, 580);
        setLocationRelativeTo(null);
	}
	
	public void exitButtonClick(){
		System.exit(0);		
	 }

	public void StartButtonClick(){
			gm = new GameMain();
		    setVisible(false);	
	 }
}
