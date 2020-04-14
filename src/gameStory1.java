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
		//��׶��� �迭 ��ȣ
		String[] imagebackground = {"gameStory1.png", "gameStory2.png", "gameStory3.png", "gameStory4.png", "gameStory5.png", "gameStory6.png", "gameStory7.png", "gameStory8.png","gameStory9.png"};//��׶��� ���� �迭
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/etc/omegaBoy.PNG"));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1080,720);
		setVisible(true);
		setTitle("������ �̻��� Ż��");
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
		btn1.addActionListener(new ActionListener() {//��ư�� ������ �� ���
            public void actionPerformed(ActionEvent e) {
            	if(imagebackgroundcnt==8) {//���� 8�ϰ�쿡 �����ϴ� â���� �Ѿ�� ��(�迭�� ��)
            		new select1(); // Ŭ���� newWindow�� ���� ������
                    dispose();//�� â �ݱ�
            	}
            	else {//���� 8�� �ƴҰ�쿡
	            	imagebackgroundcnt++;//���� ���Ͽ�
	            	startScreen = new ImageIcon("images/backgrounds/"+ imagebackground[imagebackgroundcnt]);
	            	//ȭ���� �ٲٰ� ��
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