import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class gameStory6 extends JFrame {
	JScrollPane scrollPane;
	ImageIcon startScreen;
	ImageIcon boardScreen;
	ImageIcon explainscreen;
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introbackground;
	  Toolkit kit = Toolkit.getDefaultToolkit();
		int imagebackgroundcnt=0;
	//@SuppressWarnings("deprecation")
	public gameStory6() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/etc/omegaBoy.PNG"));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1080,720);
		setVisible(true);
		setTitle("팡이의 이상한 탈출");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		String[] imagebackground = {"Gcorrect.png","gameStory36.png", "gameStory37.png", "gameStory38.png", "gameStory39.png","gameStory40.png", "gameStory41.png", "gameStory42.png", "gameStory43.png", "gameStory44.png"};//백그라운드 사진 배열
		startScreen = new ImageIcon("images/backgrounds/"+imagebackground[imagebackgroundcnt]);
		boardScreen = new ImageIcon("images/smallboard/15.png");

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(startScreen.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		panel.setLayout(null);

		scrollPane = new JScrollPane(panel);
		//new boardpane(1);
		//------------------------------------------------------------------백그라운드이미지
		panel.setLayout(null);
		ImageIcon gameStart_default = new ImageIcon("images/buttons/next_default_inGame.png"); //게임시작 기본
		ImageIcon gameStrat_rollover=new ImageIcon("images/buttons/next_rollover_inGame.png"); //게임시작 마우스 올렸을 때
		JButton btn1 = new JButton(gameStart_default); //시작 버튼 
		btn1.setBounds(950,620,80, 40);// 시작 버튼 위치: x=830, y=530  크기: 200*100
		btn1.setRolloverIcon(gameStrat_rollover);
		// 이거 하면 버튼에 배경없음
		btn1.setBorderPainted(false); 
		btn1.setFocusPainted(false); 
		btn1.setContentAreaFilled(false);
		panel.add(btn1);
		setContentPane(scrollPane);
		btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(imagebackgroundcnt==9) {
            		new barGame();
                    dispose();
            	}
            	else {
	            	imagebackgroundcnt++;
	            	startScreen = new ImageIcon("images/backgrounds/"+ imagebackground[imagebackgroundcnt]);
            	}
			}
		});
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
	public static void main(String[] args) {
		new gameStory6();
	}

}