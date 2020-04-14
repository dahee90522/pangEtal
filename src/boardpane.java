//import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
@SuppressWarnings("serial")

public class boardpane extends JFrame{
	JScrollPane scrollPane;
	ImageIcon startScreen;
	ImageIcon explainscreen;
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introbackground;
	  Toolkit kit = Toolkit.getDefaultToolkit();
	//@SuppressWarnings("deprecation")
	boardpane(int num) {
		//백그라운드 배열 번호
		
		String[] imageboard = {"0.png", "1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png", "8.png", "9.png", "10.png", "11.png", "12.png", "13.png", "14.png", "15.png"};//백그라운드 사진 배열
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/etc/omegaBoy.PNG"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(410,310);
		//setSize(1080, 720);
		setVisible(true);
		setTitle("팡이의 이상한 탈출");
		setLayout(null);
		setLocation(0,0);
		//setLocationRelativeTo(null);
		
		setResizable(false);
		startScreen = new ImageIcon("images/boardsmall/"+ imageboard[num]);

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(startScreen.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}

		};

		panel.setLayout(null);
		scrollPane = new JScrollPane(panel);
		panel.setLayout(null);
		setContentPane(scrollPane);//필수 ☆☆☆☆☆
		
	}


	public void paint(Graphics g) {
		screenImage = createImage(1300, 750);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(introbackground, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
}