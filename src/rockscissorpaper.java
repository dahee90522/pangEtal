import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.Random;
@SuppressWarnings("serial")
public class rockscissorpaper extends JFrame {
	JScrollPane scrollPane;
	ImageIcon startScreen;
	ImageIcon explainscreen;
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introbackground;
	  Toolkit kit = Toolkit.getDefaultToolkit();
	public rockscissorpaper() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/etc/omegaBoy.PNG"));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1080,720);
		setVisible(true);
		setTitle("팡이의 이상한 탈출");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		startScreen = new ImageIcon("images/backgrounds/select2.png");

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
		setContentPane(scrollPane);
		
		ImageIcon r_default = new ImageIcon("images/buttons/rock_default.png");
		ImageIcon r_rollover=new ImageIcon("images/buttons/rock_rollover.png");
		ImageIcon s_default = new ImageIcon("images/buttons/scissor_default.png");
		ImageIcon s_rollover=new ImageIcon("images/buttons/scissor_rollover.png");
		ImageIcon p_default = new ImageIcon("images/buttons/paper_default.png");
		ImageIcon p_rollover=new ImageIcon("images/buttons/paper_rollover.png");
		
		JButton rock = new JButton(r_default); //시작 버튼 
		rock.setBounds(480,450,170, 80);// 시작 버튼 위치: x=830, y=530  크기: 200*100
		rock.setRolloverIcon(r_rollover);
		JButton scissor = new JButton(s_default); //시작 버튼 
		scissor.setBounds(280,450,170, 80);// 시작 버튼 위치: x=830, y=530  크기: 200*100
		scissor.setRolloverIcon(s_rollover);
		JButton paper = new JButton(p_default); //시작 버튼 
		paper.setBounds(680,450,170, 80);// 시작 버튼 위치: x=830, y=530  크기: 200*100
		paper.setRolloverIcon(p_rollover);
		
		// 이거 하면 버튼에 배경없음
		rock.setBorderPainted(false); 
		rock.setFocusPainted(false); 
		rock.setContentAreaFilled(false);
		
		scissor.setBorderPainted(false); 
		scissor.setFocusPainted(false); 
		scissor.setContentAreaFilled(false);
		
		paper.setBorderPainted(false); 
		paper.setFocusPainted(false); 
		paper.setContentAreaFilled(false);
		
		panel.add(rock);panel.add(scissor);panel.add(paper);
		Random rand = new Random();

		rock.addActionListener(new ActionListener() {//okButton을 누르면
	        public void actionPerformed(ActionEvent e) {
	    		int iValue = rand.nextInt(10);//주먹을 누를 경우 랜덤으로 값 생성
	    		iValue=iValue%2;//랜덤으로 1아니면 0
	        	System.out.println(iValue);
	    		new rockscissorpaper_rock(iValue);//값 넘기기
	    		dispose();
			}
		});
		scissor.addActionListener(new ActionListener() {//okButton을 누르면
	        public void actionPerformed(ActionEvent e) {
	    		int iValue = rand.nextInt(10);//가위을 누를 경우 랜덤으로 값 생성
	    		iValue=iValue%2;//랜덤으로 1아니면 0
	        	System.out.println(iValue);
	    		new rockscissorpaper_scissor(iValue);//값 넘기기
	    		dispose();
			}
		});
		paper.addActionListener(new ActionListener() {//okButton을 누르면
	        public void actionPerformed(ActionEvent e) {
	    		int iValue = rand.nextInt(10);//보을 누를 경우 랜덤으로 값 생성
	    		iValue=iValue%2;//랜덤으로 1아니면 0
	        	System.out.println(iValue);
	    		new rockscissorpaper_paper(iValue);//값 넘기기
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
	public static void main(String[] args) {
		new rockscissorpaper();
	}
}