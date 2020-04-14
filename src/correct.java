import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class correct extends JFrame {
	JScrollPane scrollPane;
	ImageIcon startScreen;
	ImageIcon explainscreen;
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introbackground;
	int imagebackgroundcnt=0;
	  Toolkit kit = Toolkit.getDefaultToolkit();
	//@SuppressWarnings("deprecation")
	public correct(int num) {
		//��׶��� �迭 ��ȣ
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/etc/omegaBoy.PNG"));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1080,720);
		setVisible(true);
		setTitle("������ �̻��� Ż��");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		String[] imagebackground = {"Gcorrect.png", "gameStory26.png", "gameStory27.png", "gameStory28.png"};//��׶��� ���� �迭
		switch(num) {
		case 5:startScreen = new ImageIcon("images/backgrounds/"+imagebackground[1]);break;
		case 8:startScreen = new ImageIcon("images/backgrounds/"+imagebackground[2]);break;
		case 10:startScreen = new ImageIcon("images/backgrounds/"+imagebackground[3]);break;
		default:startScreen = new ImageIcon("images/backgrounds/"+imagebackground[0]);break;
		}


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
            	switch(num) {
        		case 3:new quiz3();dispose();break;
        		case 4:new quiz4();dispose();break;
        		case 5:new quiz1(2);dispose();break;
        		case 6:new quiz1(3);dispose();break;
        		case 7:new quiz7();dispose();break;
        		case 8:new quiz1(4);dispose();break;
        		case 9:new quiz1(5);dispose();break;
        		case 10:new quiz1(6);dispose();break;
        		case 11:new quiz1(7);dispose();break;
        		case 12:new quiz1(8);dispose();break;
        		case 13:new quiz1(9);dispose();break;
        		case 14:new quiz1(10);dispose();break;
        		case 15:new quiz1(11);dispose();break;	
            	}
                /*new goto2(); // Ŭ���� newWindow�� ���� ������
                dispose();*/
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