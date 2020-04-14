import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class rockscissorpaper_scissor extends JFrame {
	JScrollPane scrollPane;
	ImageIcon startScreen;
	ImageIcon explainscreen;
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introbackground;
	  Toolkit kit = Toolkit.getDefaultToolkit();
		int cnt=0;
	public rockscissorpaper_scissor(int num) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/etc/omegaBoy.PNG"));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1080,720);
		setVisible(true);
		setTitle("팡이의 이상한 탈출");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		String[] papercw = {"select2_scissor(wrong)1.png" , "select2_scissor(correct)1.png"};
		startScreen = new ImageIcon("images/backgrounds/"+papercw[num]);

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
		
		ImageIcon again_default = new ImageIcon("images/buttons/regame_default.png");
		ImageIcon again_rollover=new ImageIcon("images/buttons/regame_rollover.png");
		ImageIcon next_default = new ImageIcon("images/buttons/next_default_inGame.png");
		ImageIcon next_rollover=new ImageIcon("images/buttons/next_rollover_inGame.png");
		
		JButton again = new JButton(again_default); //시작 버튼 
		again.setBounds(800,620,80, 40);;// 시작 버튼 위치: x=830, y=530  크기: 200*100
		again.setRolloverIcon(again_rollover);
		JButton next = new JButton(next_default); //시작 버튼 
		next.setBounds(950,620,80, 40);// 시작 버튼 위치: x=830, y=530  크기: 200*100
		next.setRolloverIcon(next_rollover);
		
		// 이거 하면 버튼에 배경없음
		again.setBorderPainted(false); 
		again.setFocusPainted(false); 
		again.setContentAreaFilled(false);
		
		next.setBorderPainted(false); 
		next.setFocusPainted(false); 
		next.setContentAreaFilled(false);

		if(num==0) {panel.add(again);panel.add(next);}//버튼 다시하기, 다음으로
		if(num==1) {panel.add(next);}//버튼 다시하기
		next.addActionListener(new ActionListener() {//okButton을 누르면
	        public void actionPerformed(ActionEvent e) {
	        	if(num==1) {//만약 1일 경우 이기는 설정 
	        		new gameStory5();dispose();//다음 스토리로 이어짐
	        	}
	        	else if(num==0) {//0일 경우 지는 설정
	        		new gameOverrsp(); dispose();//게임 오버창 띄움
	        	}
			}
		});
		again.addActionListener(new ActionListener() {//okButton을 누르면
	        public void actionPerformed(ActionEvent e) {
	        		new rockscissorpaper();dispose();//다시 가위바위보를 하게 됨
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