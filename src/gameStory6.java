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
		setTitle("������ �̻��� Ż��");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		String[] imagebackground = {"Gcorrect.png","gameStory36.png", "gameStory37.png", "gameStory38.png", "gameStory39.png","gameStory40.png", "gameStory41.png", "gameStory42.png", "gameStory43.png", "gameStory44.png"};//��׶��� ���� �迭
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
		//------------------------------------------------------------------��׶����̹���
		panel.setLayout(null);
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