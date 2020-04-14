import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class gameStory2 extends JFrame {
	JScrollPane scrollPane;
	ImageIcon startScreen;
	ImageIcon explainscreen;
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introbackground;
	  Toolkit kit = Toolkit.getDefaultToolkit();
		int imagebackgroundcnt=0;
	//@SuppressWarnings("deprecation")
	public gameStory2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/etc/omegaBoy.PNG"));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1080,720);
		setVisible(true);
		setTitle("팡이의 이상한 탈출");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		String[] imagebackground = {"gameStory10.png", "gameStory11.png", "gameStory12.png", "gameStory13.png","gameStory14.png", "gameStory15.png", "gameStory16.png", "gameStory17.png", "gameStory18.png","gameStory19.png","gameStory20.png"};//백그라운드 사진 배열
		startScreen = new ImageIcon("images/backgrounds/"+imagebackground[imagebackgroundcnt]);

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(startScreen.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}

		};

		panel.setLayout(null);

		scrollPane = new JScrollPane(panel);
		new boardpane(0);
		//------------------------------------------------------------------백그라운드이미지
		panel.setLayout(null);
		setContentPane(scrollPane);
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
		btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(imagebackgroundcnt==10) {
            		//new quiz1(0); // 클래스 newWindow를 새로 만들어낸다
            		new quiz1(1);
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

}