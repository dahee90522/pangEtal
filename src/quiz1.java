import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class quiz1 extends JFrame{
	JScrollPane scrollPane;
	ImageIcon startScreen;
	ImageIcon explainscreen;
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introbackground;
	  Toolkit kit = Toolkit.getDefaultToolkit();
	  int quizcnt=0;
	public quiz1(int num) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/etc/omegaBoy.PNG"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1080,720);
		setVisible(true);
		setTitle("팡이의 이상한 탈출");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		String[] imagequiz = {"quiz1.png","quiz5_answer-2.png", "quiz6_answer-0.png",
				"quiz8_answer-1.png", "quiz9_answer-가위바위보.png","quiz10_answer-18.png","quiz11_answer-30.png",
				"quiz12_answer-영희.png", "quiz13_answer-SOS.png", "quiz14_answer-37.png", "quiz15_answer-20.png"};//문제 배열
		String[] imagequizanswer = {"최저임금","2", "0", "1", "가위바위보","18", "30", "영희", "SOS", "37","20"};//정답 배열
		startScreen = new ImageIcon("images/backgrounds/"+imagequiz[num-1]);
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
		ImageIcon answer_default = new ImageIcon("images/buttons/answer_default.png"); //게임시작 기본
		ImageIcon answer_rollover=new ImageIcon("images/buttons/answer_rollover.png"); //게임시작 마우스 올렸을 때
		JTextField tf = new JTextField(40);
		tf.setFont(tf.getFont().deriveFont(30.0f));
		JButton okButton = new JButton(answer_default);
		tf.setBounds(400,500,200, 70);
		okButton.setBounds(610,500,90, 70);
		okButton.setRolloverIcon(answer_rollover);
		okButton.setBorderPainted(false); 
		okButton.setFocusPainted(false); 
		okButton.setContentAreaFilled(false);
		panel.add(tf);
		panel.add(okButton);
		okButton.setFont(new Font("Serif", Font.BOLD, 11));
		okButton.addActionListener(new ActionListener() {//okButton을 누르면
            public void actionPerformed(ActionEvent e) {
        		String a=tf.getText();//textfield 값 불러오기
            	if(a.equals(imagequizanswer[num-1])) {//답 비교
            		switch(num) {
            		case 1:new gameStory3();dispose();new boardpane(1);break;
            		case 2:new correct(6);dispose();new boardpane(5);break;
            		case 3:new correct(7);dispose();new boardpane(6);break;
            		case 4:new correct(9);dispose();new boardpane(8);break;
            		case 5:new correct(10);dispose();new boardpane(9);break;
            		case 6:new correct(11);dispose();new boardpane(10);break;
            		case 7:new gameStory4();dispose();new boardpane(11);break;
            		case 8:new correct(13);dispose();new boardpane(12);break;
            		case 9:new correct(14);dispose();new boardpane(13);break;
            		case 10:new correct(15);dispose();new boardpane(14);break;
            		case 11:new gameStory6();dispose();new boardpane(15);break;
            		}
            	}
            	else {//게임 되돌아가기
            		switch(num) {
            		case 1:new wrong1(1, 1);dispose();break;
            		case 2:new wrong1(2, 5);dispose();break;
            		case 3:new wrong1(2, 6);dispose();break;
            		case 4:new wrong1(2, 8);dispose();break;
            		case 5:new wrong1(2, 9);dispose();break;
            		case 6:new wrong1(2, 10);dispose();break;
            		case 7:new wrong1(2, 11);dispose();break;
            		case 8:new wrong1(2, 12);dispose();break;
            		case 9:new wrong1(2, 13);dispose();break;
            		case 10:new wrong1(2, 14);dispose();break;
            		case 11:new wrong1(2, 15);dispose();break;
            		case 12:new wrong1(2, 16);dispose();break;
            		}
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