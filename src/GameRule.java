import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameRule extends JFrame {
	JScrollPane scrollPane;
	ImageIcon startScreen;
	ImageIcon explainscreen;
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introbackground;
	  Toolkit kit = Toolkit.getDefaultToolkit();
	//@SuppressWarnings("deprecation")
	public GameRule() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/etc/omegaBoy.PNG"));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1080,720);
		setVisible(true);
		setTitle("팡이의 이상한 탈출");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		startScreen = new ImageIcon("images/backgrounds/gameRule.png");

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(startScreen.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}

		};

		panel.setLayout(null);

		scrollPane = new JScrollPane(panel);
		//------------------------------------------------------------------백그라운드이미지↑
		panel.setLayout(null);
		setContentPane(scrollPane);
		ImageIcon gameStart_default = new ImageIcon("images/buttons/gameStart_default.png"); //게임시작 기본
		ImageIcon gameStrat_rollover=new ImageIcon("images/buttons/gameStart_rollover.png"); //게임시작 마우스 올렸을 때
		JButton btn1 = new JButton(gameStart_default); //시작 버튼 
		btn1.setBounds(830,530,200,100);// 시작 버튼 위치: x=830, y=530  크기: 200*100
		btn1.setRolloverIcon(gameStrat_rollover);
		// 이거 하면 버튼에 배경없음
		btn1.setBorderPainted(false); 
		btn1.setFocusPainted(false); 
		btn1.setContentAreaFilled(false);
		panel.add(btn1);
		btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new gameStory1(); // 클래스 newWindow를 새로 만들어낸다
                dispose();
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