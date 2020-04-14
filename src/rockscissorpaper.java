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
		setTitle("������ �̻��� Ż��");
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
		
		JButton rock = new JButton(r_default); //���� ��ư 
		rock.setBounds(480,450,170, 80);// ���� ��ư ��ġ: x=830, y=530  ũ��: 200*100
		rock.setRolloverIcon(r_rollover);
		JButton scissor = new JButton(s_default); //���� ��ư 
		scissor.setBounds(280,450,170, 80);// ���� ��ư ��ġ: x=830, y=530  ũ��: 200*100
		scissor.setRolloverIcon(s_rollover);
		JButton paper = new JButton(p_default); //���� ��ư 
		paper.setBounds(680,450,170, 80);// ���� ��ư ��ġ: x=830, y=530  ũ��: 200*100
		paper.setRolloverIcon(p_rollover);
		
		// �̰� �ϸ� ��ư�� ������
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

		rock.addActionListener(new ActionListener() {//okButton�� ������
	        public void actionPerformed(ActionEvent e) {
	    		int iValue = rand.nextInt(10);//�ָ��� ���� ��� �������� �� ����
	    		iValue=iValue%2;//�������� 1�ƴϸ� 0
	        	System.out.println(iValue);
	    		new rockscissorpaper_rock(iValue);//�� �ѱ��
	    		dispose();
			}
		});
		scissor.addActionListener(new ActionListener() {//okButton�� ������
	        public void actionPerformed(ActionEvent e) {
	    		int iValue = rand.nextInt(10);//������ ���� ��� �������� �� ����
	    		iValue=iValue%2;//�������� 1�ƴϸ� 0
	        	System.out.println(iValue);
	    		new rockscissorpaper_scissor(iValue);//�� �ѱ��
	    		dispose();
			}
		});
		paper.addActionListener(new ActionListener() {//okButton�� ������
	        public void actionPerformed(ActionEvent e) {
	    		int iValue = rand.nextInt(10);//���� ���� ��� �������� �� ����
	    		iValue=iValue%2;//�������� 1�ƴϸ� 0
	        	System.out.println(iValue);
	    		new rockscissorpaper_paper(iValue);//�� �ѱ��
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