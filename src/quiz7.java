import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
@SuppressWarnings("serial")
public class quiz7 extends JFrame{
	JScrollPane scrollPane;
	ImageIcon startScreen;
	ImageIcon explainscreen;
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introbackground;
	 Toolkit kit = Toolkit.getDefaultToolkit();
	 int quizcnt=0;
	public quiz7() {
			setIconImage(Toolkit.getDefaultToolkit().getImage("images/etc/omegaBoy.PNG"));
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(1080,720);
			setVisible(true);
			setTitle("팡이의 이상한 탈출");
			setLayout(null);
			setLocationRelativeTo(null);
			setResizable(false);
			startScreen = new ImageIcon("images/backgrounds/quiz7.png");

			JPanel panel = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(startScreen.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponent(g);
				}

			};
			panel.setLayout(null);

			scrollPane = new JScrollPane(panel);
			//------------------------------------------------------------------백그라운드이미지
			
			panel.setLayout(null);
			setContentPane(scrollPane);
			ImageIcon answer1_default = new ImageIcon("images/buttons/quiz7-1_default.png"); //게임시작 기본
			ImageIcon answer1_rollover=new ImageIcon("images/buttons/quiz7-1_rollover.png"); //게임시작 마우스 올렸을 때
			ImageIcon answer2_default = new ImageIcon("images/buttons/quiz7-2_default.png"); //게임시작 기본
			ImageIcon answer2_rollover=new ImageIcon("images/buttons/quiz7-2_rollover.png"); //게임시작 마우스 올렸을 때
			ImageIcon answer3_default = new ImageIcon("images/buttons/quiz7-3_default.png"); //게임시작 기본
			ImageIcon answer3_rollover=new ImageIcon("images/buttons/quiz7-3_rollover.png"); //게임시작 마우스 올렸을 때
			
			JButton okButton1 = new JButton(answer1_default);
			JButton okButton2 = new JButton(answer2_default);
			JButton okButton3 = new JButton(answer3_default);
			
			okButton1.setBounds(290,550,90, 70);
			okButton1.setRolloverIcon(answer1_rollover);
			okButton2.setBounds(490,550,90, 70);
			okButton2.setRolloverIcon(answer2_rollover);
			okButton3.setBounds(690,550,90, 70);
			okButton3.setRolloverIcon(answer3_rollover);
			
			okButton1.setBorderPainted(false); 
			okButton1.setFocusPainted(false); 
			okButton1.setContentAreaFilled(false);
			
			okButton2.setBorderPainted(false); 
			okButton2.setFocusPainted(false); 
			okButton2.setContentAreaFilled(false);
			
			okButton3.setBorderPainted(false); 
			okButton3.setFocusPainted(false); 
			okButton3.setContentAreaFilled(false);
			
			panel.add(okButton1);
			panel.add(okButton2);
			panel.add(okButton3);
			//okButton.setFont(new Font("Serif", Font.BOLD, 11));
			okButton3.addActionListener(new ActionListener() {//okButton을 누르면
	            public void actionPerformed(ActionEvent e) {
	            	new correct(8);dispose();new boardpane(7);
				}
			});
			okButton1.addActionListener(new ActionListener() {//okButton을 누르면
	            public void actionPerformed(ActionEvent e) {
	            	new wrong1(2, 7);dispose();
				}
			});
			okButton2.addActionListener(new ActionListener() {//okButton을 누르면
	            public void actionPerformed(ActionEvent e) {
	            	new wrong1(2, 7);dispose();
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