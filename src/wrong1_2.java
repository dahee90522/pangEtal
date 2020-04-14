import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class wrong1_2 extends JFrame {
	JScrollPane scrollPane;
	ImageIcon startScreen;
	ImageIcon explainscreen;
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introbackground;
	  Toolkit kit = Toolkit.getDefaultToolkit();
	  int backgroundimgcnt=0;
	public wrong1_2(int num) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/etc/omegaBoy.PNG"));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1080,720);
		setVisible(true);
		setTitle("������ �̻��� Ż��");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		String[] imagebackground1 = {"wrong3.png", "wrong4.png", "wrong5.png"};//��׶��� ���� �迭
		String[] imagebackground2 = {"Gwrong3.png", "Gwrong4.png", "wrong5.png"};
		if(num==1)startScreen = new ImageIcon("images/backgrounds/"+imagebackground1[backgroundimgcnt]);
		if(num==2)startScreen = new ImageIcon("images/backgrounds/"+imagebackground2[backgroundimgcnt]);
		if(num==3)startScreen = new ImageIcon("images/backgrounds/Gwrong3.png");

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(startScreen.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}

		};

		panel.setLayout(null);

		scrollPane = new JScrollPane(panel);
		//------------------------------------------------------------------��׶����̹���
		panel.setLayout(null);
		setContentPane(scrollPane);
		ImageIcon gameStart_default = new ImageIcon("images/buttons/next_default_inGame.png"); //���ӽ��� �⺻
		ImageIcon gameStrat_rollover=new ImageIcon("images/buttons/next_rollover_inGame.png"); //���ӽ��� ���콺 �÷��� ��
		JButton btn1 = new JButton(gameStart_default); //���� ��ư 
		btn1.setBounds(950,620,80, 40);// ���� ��ư ��ġ: x=830, y=530  ũ��: 200*100
		btn1.setRolloverIcon(gameStrat_rollover);
		// �̰� �ϸ� ��ư�� ������
		btn1.setBorderPainted(false); 
		btn1.setFocusPainted(false); 
		btn1.setContentAreaFilled(false);
		panel.add(btn1);
		btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(backgroundimgcnt==2) {
            		new gameOver();dispose(); // Ŭ���� newWindow�� ���� ������
                    dispose();
            	}
            	
            	else {
            		if(num==1) {
		            	backgroundimgcnt++;
		            	startScreen = new ImageIcon("images/backgrounds/"+ imagebackground1[backgroundimgcnt]);
            		}
            		else if(num==2) {
		            	backgroundimgcnt++;
		            	startScreen = new ImageIcon("images/backgrounds/"+ imagebackground2[backgroundimgcnt]);
            		}
            		else if(num==3) {
            			new gameOverrsp();dispose();
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