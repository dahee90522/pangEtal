import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class gameStory1 extends JFrame {
	JScrollPane scrollPane;
	ImageIcon startScreen;
	ImageIcon explainscreen;
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introbackground;
	int imagebackgroundcnt=0;
	  Toolkit kit = Toolkit.getDefaultToolkit();
	//@SuppressWarnings("deprecation")
	public gameStory1() {
		//백그라운드 배열 번호
		String[] imagebackground = {"gameStory1.png", "gameStory2.png", "gameStory3.png", "gameStory4.png", "gameStory5.png", "gameStory6.png", "gameStory7.png", "gameStory8.png","gameStory9.png"};//백그라운드 사진 배열
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/etc/omegaBoy.PNG"));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1080,720);
		setVisible(true);
		setTitle("팡이의 이상한 탈출");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		startScreen = new ImageIcon("images/backgrounds/"+ imagebackground[imagebackgroundcnt]);

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(startScreen.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}

		};

		panel.setLayout(null);

		scrollPane = new JScrollPane(panel);
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
		btn1.addActionListener(new ActionListener() {//버튼을 누르게 될 경우
            public void actionPerformed(ActionEvent e) {
            	if(imagebackgroundcnt==8) {//만약 8일경우에 선택하는 창으로 넘어가게 됨(배열의 끝)
            		new select1(); // 클래스 newWindow를 새로 만들어낸다
                    dispose();//이 창 닫기
            	}
            	else {//만약 8이 아닐경우에
	            	imagebackgroundcnt++;//값을 더하여
	            	startScreen = new ImageIcon("images/backgrounds/"+ imagebackground[imagebackgroundcnt]);
	            	//화면을 바꾸게 됨
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