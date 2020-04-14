import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class endGame extends JFrame {
	JScrollPane scrollPane;
	ImageIcon startScreen;
	ImageIcon explainscreen;
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introbackground;
	  Toolkit kit = Toolkit.getDefaultToolkit();
	//@SuppressWarnings("deprecation")
	public endGame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/etc/omegaBoy.PNG"));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1080,720);
		setVisible(true);
		setTitle("������ �̻��� Ż��");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		startScreen = new ImageIcon("images/backgrounds/TheEnd.png");

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
		ImageIcon gameend_default = new ImageIcon("images/buttons/gameOver_default.png"); //���ӽ��� �⺻
		ImageIcon gameend_rollover=new ImageIcon("images/buttons/gameOver_rollover.png"); //���ӽ��� ���콺 �÷��� ��
		JButton btn2 = new JButton(gameend_default); //���� ��ư 
		btn2.setBounds(870,580,170, 80);// ���� ��ư ��ġ: x=830, y=530  ũ��: 200*100
		btn2.setRolloverIcon(gameend_rollover);
		// �̰� �ϸ� ��ư�� ������
		btn2.setBorderPainted(false); 
		btn2.setFocusPainted(false); 
		btn2.setContentAreaFilled(false);
		panel.add(btn2);
		btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
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