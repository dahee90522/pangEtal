//import java.awt.Container;
//import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;

import javax.swing.*;
import java.awt.Toolkit;
@SuppressWarnings("serial")
public class Home extends JFrame{
	JFrame jframe=new JFrame();
	Home(){
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/etc/omegaBoy.PNG"));
		
		setTitle("팡이의 이상한 탈출");
		setSize(1080,720);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ImageIcon homeBackground = new ImageIcon("images/backgrounds/home.png");
		Image homeBack= homeBackground.getImage();
		JPanel jp = new JPanel() { //배경 넣기 
			public void paintComponent(Graphics g) {
				g.drawImage(homeBack,0,0,1080,720,null);
				setOpaque(false);
				super.paintComponent(g);
			} 
		};
		jp.setLayout(null);
		
		ImageIcon gameStart_default = new ImageIcon("images/buttons/gameStart_default.png"); //게임시작 기본
		ImageIcon gameStrat_rollover=new ImageIcon("images/buttons/gameStart_rollover.png"); //게임시작 마우스 올렸을 때
		JButton btn1 = new JButton(gameStart_default); //시작 버튼 
		btn1.setBounds(30,530,200,100);	// 시작 버튼 위치: x=30, y=530  크기: 200*100
		btn1.setRolloverIcon(gameStrat_rollover);
		// 이거 하면 버튼에 배경없음
		btn1.setBorderPainted(false); 
		btn1.setFocusPainted(false); 
		btn1.setContentAreaFilled(false);
		btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new gameStory1(); // 클래스 newWindow를 새로 만들어낸다
                dispose();
			}
		});
		
		ImageIcon gameRule_default = new ImageIcon("images/buttons/gameRule_default.png"); //게임시작 기본
		ImageIcon gameRule_rollover=new ImageIcon("images/buttons/gameRule_rollover.png"); //게임시작 마우스 올렸을 때
		JButton btn2 = new JButton(gameRule_default); //시작 버튼 
		btn2.setBounds(430,530,200,100);	// 시작 버튼 위치: x=30, y=530  크기: 200*100
		btn2.setRolloverIcon(gameRule_rollover);
		// 이거 하면 버튼에 배경없음
		btn2.setBorderPainted(false); 
		btn2.setFocusPainted(false); 
		btn2.setContentAreaFilled(false);
		btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GameRule(); // 클래스 newWindow를 새로 만들어낸다
                dispose();
			}
		});

		
		ImageIcon exit_default=new ImageIcon("images/buttons/exit_default.png");
		ImageIcon exit_rollover=new ImageIcon("images/buttons/exit_rollover.png");
		JButton btn3= new JButton(exit_default); //게임 종료 버튼 
		btn3.setRolloverIcon(exit_rollover); // 마우스 올렸을 때 버튼 이미지
		btn3.setBorderPainted(false); 
		btn3.setFocusPainted(false); 
		btn3.setContentAreaFilled(false);
		btn3.setBounds(830,530,200,100);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		 
		jp.add(btn1); // 버튼을 패널에 붙이기
		jp.add(btn2);
		jp.add(btn3);
		getContentPane().add(jp); // 프레임에 패널 붙이기
		this.setVisible(true); // 이건 왜넣는지 모르겠는데 이걸 안넣으면 안보여...ㅋ
	}
	 public static void main(String[] args) {
			new Home();
		}
}
