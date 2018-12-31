package proje;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class StartScreen extends JWindow {
	
	SelectScreen se;
	
	public static Image background;
	static JProgressBar progressBar = new JProgressBar();
	static Container container;
	
    static int yuklenme;
    static Timer timer1;
    static Color pBarBC;
    static Color pBarFC;
    
    public StartScreen() {
    	//setIconImage(ImageIO.read(StartScreen.class.getResource("background.jpg")));
        setSize(600, 450);
        setLocationRelativeTo(null);
        
    	container = getContentPane();
        container.setLayout(null);
        
        try {
			background =ImageIO.read(StartScreen.class.getResource("background.jpg"));
		} catch (IOException ýe) {
			ýe.printStackTrace();
		}
        
        pBarBC = new Color(239,244,248);
        pBarFC = new Color(80,130,163);
        
        progressBar.setBounds(125, 400, 350, 20);
        progressBar.setBackground(pBarBC);
        progressBar.setForeground(pBarFC);
        progressBar.setStringPainted(true);
        container.add(progressBar);
        progressBarYüklenme();

        final int dur = 6000;
        final Runnable kapatRunner = new Runnable()
        {
            public void run()
            {
                setVisible(false);
                se=new SelectScreen();
                dispose();
            }
        };

        final Runnable bekleRunner = new Runnable()
        {
            public void run()
            {
                try
                {
                    Thread.sleep(dur);
                    timer1.stop();
                    SwingUtilities.invokeAndWait(kapatRunner);//Bir uygulama iþ parçacýðýnýn GUI'yi güncellemesi gerektiðinde bu yöntem kullanýlmalýdýr.
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        };
        setVisible(true);
        Thread splashThread = new Thread(bekleRunner, "SplashThread");
        splashThread.start();
    }
    
    public void paint(Graphics g) {
    	g.drawImage(background, 0, 0, 600, 450, null);
	}

	public void progressBarYüklenme() {
        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	yuklenme++;
                progressBar.setValue(yuklenme);//progressBar'ýn deðerini deðiþtir
            }
        };
        timer1 = new Timer(50, al);
        timer1.start();//timerTask nesnesi kullansaydým ActionListener da yazdýklarýmý ayný þekilde timerTask ýn içide run methodunda yazmam gerekirdi
    }
    
    
	public static void main(String[] args) {
		new StartScreen();
	}

}

