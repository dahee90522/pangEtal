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
		setTitle("������ �̻��� Ż��");
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
		
		JButton again = new JButton(again_default); //���� ��ư 
		again.setBounds(800,620,80, 40);;// ���� ��ư ��ġ: x=830, y=530  ũ��: 200*100
		again.setRolloverIcon(again_rollover);
		JButton next = new JButton(next_default); //���� ��ư 
		next.setBounds(950,620,80, 40);// ���� ��ư ��ġ: x=830, y=530  ũ��: 200*100
		next.setRolloverIcon(next_rollover);
		
		// �̰� �ϸ� ��ư�� ������
		again.setBorderPainted(false); 
		again.setFocusPainted(false); 
		again.setContentAreaFilled(false);
		
		next.setBorderPainted(false); 
		next.setFocusPainted(false); 
		next.setContentAreaFilled(false);

		if(num==0) {panel.add(again);panel.add(next);}//��ư �ٽ��ϱ�, ��������
		if(num==1) {panel.add(next);}//��ư �ٽ��ϱ�
		next.addActionListener(new ActionListener() {//okButton�� ������
	        public void actionPerformed(ActionEvent e) {
	        	if(num==1) {//���� 1�� ��� �̱�� ���� 
	        		new gameStory5();dispose();//���� ���丮�� �̾���
	        	}
	        	else if(num==0) {//0�� ��� ���� ����
	        		new gameOverrsp(); dispose();//���� ����â ���
	        	}
			}
		});
		again.addActionListener(new ActionListener() {//okButton�� ������
	        public void actionPerformed(ActionEvent e) {
	        		new rockscissorpaper();dispose();//�ٽ� ������������ �ϰ� ��
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