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
		
		setTitle("������ �̻��� Ż��");
		setSize(1080,720);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ImageIcon homeBackground = new ImageIcon("images/backgrounds/home.png");
		Image homeBack= homeBackground.getImage();
		JPanel jp = new JPanel() { //��� �ֱ� 
			public void paintComponent(Graphics g) {
				g.drawImage(homeBack,0,0,1080,720,null);
				setOpaque(false);
				super.paintComponent(g);
			} 
		};
		jp.setLayout(null);
		
		ImageIcon gameStart_default = new ImageIcon("images/buttons/gameStart_default.png"); //���ӽ��� �⺻
		ImageIcon gameStrat_rollover=new ImageIcon("images/buttons/gameStart_rollover.png"); //���ӽ��� ���콺 �÷��� ��
		JButton btn1 = new JButton(gameStart_default); //���� ��ư 
		btn1.setBounds(30,530,200,100);	// ���� ��ư ��ġ: x=30, y=530  ũ��: 200*100
		btn1.setRolloverIcon(gameStrat_rollover);
		// �̰� �ϸ� ��ư�� ������
		btn1.setBorderPainted(false); 
		btn1.setFocusPainted(false); 
		btn1.setContentAreaFilled(false);
		btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new gameStory1(); // Ŭ���� newWindow�� ���� ������
                dispose();
			}
		});
		
		ImageIcon gameRule_default = new ImageIcon("images/buttons/gameRule_default.png"); //���ӽ��� �⺻
		ImageIcon gameRule_rollover=new ImageIcon("images/buttons/gameRule_rollover.png"); //���ӽ��� ���콺 �÷��� ��
		JButton btn2 = new JButton(gameRule_default); //���� ��ư 
		btn2.setBounds(430,530,200,100);	// ���� ��ư ��ġ: x=30, y=530  ũ��: 200*100
		btn2.setRolloverIcon(gameRule_rollover);
		// �̰� �ϸ� ��ư�� ������
		btn2.setBorderPainted(false); 
		btn2.setFocusPainted(false); 
		btn2.setContentAreaFilled(false);
		btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GameRule(); // Ŭ���� newWindow�� ���� ������
                dispose();
			}
		});

		
		ImageIcon exit_default=new ImageIcon("images/buttons/exit_default.png");
		ImageIcon exit_rollover=new ImageIcon("images/buttons/exit_rollover.png");
		JButton btn3= new JButton(exit_default); //���� ���� ��ư 
		btn3.setRolloverIcon(exit_rollover); // ���콺 �÷��� �� ��ư �̹���
		btn3.setBorderPainted(false); 
		btn3.setFocusPainted(false); 
		btn3.setContentAreaFilled(false);
		btn3.setBounds(830,530,200,100);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		 
		jp.add(btn1); // ��ư�� �гο� ���̱�
		jp.add(btn2);
		jp.add(btn3);
		getContentPane().add(jp); // �����ӿ� �г� ���̱�
		this.setVisible(true); // �̰� �ֳִ��� �𸣰ڴµ� �̰� �ȳ����� �Ⱥ���...��
	}
	 public static void main(String[] args) {
			new Home();
		}
}
