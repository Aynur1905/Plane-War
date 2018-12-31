package proje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;


public class SelectScreen extends JFrame {

	private PlaneSelect ps;
	private JTextField userName;
	public static int select = 3;
	public static String username;
	
	public SelectScreen() {
		String[] difficulties = {"Hard","Normal","Easy"};
		Color c = new Color(18, 10, 143);
		
		Container container = getContentPane();
        container.setLayout(null);   
        container.setBackground(c);
        
        JLabel user =new JLabel("Kullanýcý Adý:");
        user.setForeground(Color.white);
        user.setFont(new Font ("MV Boli",Font.BOLD,20));
        user.setBounds(70, 65, 180, 40);
        container.add(user);
        
		userName = new JTextField(8);
		userName.setForeground(c);
		userName.setFont(new Font ("MV Boli",Font.BOLD,20));
		userName.setBounds(230, 67, 180, 30);
	    container.add(userName);
		
	    JLabel zorluk =new JLabel("Zorluk:");
	    zorluk.setForeground(Color.white);
	    zorluk.setFont(new Font ("MV Boli",Font.BOLD,20));
	    zorluk.setBounds(80, 110, 180, 40);
        container.add(zorluk);
        
        JComboBox difficulty = new JComboBox(difficulties);
        difficulty.setForeground(c);
        difficulty.setBackground(Color.white);
        difficulty.setBounds(230, 115, 180, 30);
        difficulty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox selectBox =(JComboBox) e.getSource();
				
				if(selectBox.getSelectedItem().equals("Hard")) {
					select = 3;
				}else if(selectBox.getSelectedItem().equals("Normal")) {
					select = 2;
				}else if(selectBox.getSelectedItem().equals("Easy")) {
					select = 1;
				}
			}
		});
        container.add(difficulty);
        
        JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(e->exitButtonClick());
		exitButton.setForeground(c);
		exitButton.setBackground(Color.WHITE);
		exitButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    exitButton.setBounds(55, 210, 120, 35);
	    container.add(exitButton);
	    
	    JButton startButton = new JButton("Start");
	    startButton.addActionListener(e->StartButtonClick());
	    startButton.setForeground(c);
	    startButton.setBackground(Color.WHITE);
	    startButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    startButton.setBounds(335, 210, 120, 35);
	    container.add(startButton);
	    
	    setUndecorated(true);//JFrame in çerçevesini kaldýrmak için
		setVisible(true);
		setFocusable(true);
		setSize(500, 300);
        setLocationRelativeTo(null);
	}
	public void exitButtonClick(){
		System.exit(0);		
	 }

	public void StartButtonClick(){
		username = userName.getText();
		if(username.length() == 0) {
			JOptionPane.showMessageDialog(null, "Lütfen bir kullanýcý adý giriniz", "Eksik bilgi", JOptionPane.PLAIN_MESSAGE);
		}else {
			ps = new PlaneSelect();
		    setVisible(false);	
		}
	 }
}

