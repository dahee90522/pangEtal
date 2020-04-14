//import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
@SuppressWarnings("serial")
class MyLabel extends JLabel{
    int barSize=0;//���� ũ��
    int maxBarSize;
    JFrame j = new JFrame();
    Color color = new Color(199, 115, 116);
    MyLabel(int maxBarSize){
        this.maxBarSize=maxBarSize;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(color);
        int width =(int)(((double)(this.getWidth()))/maxBarSize*barSize);
        if(width==0) return;//ũ�Ⱑ 0�̸� �ٸ� �׸� �ʿ� ����
        g.fillRect(0,0,width,this.getHeight());
    }
    synchronized boolean fill(){
        if(barSize==maxBarSize){
        	//return 1;
            try{
                this.wait();//���� ũ�Ⱑ �ִ��̸�, ConsumerThread�� ���� ���� ũ�Ⱑ �پ�鶧���� ���
            }
            catch(Exception e){
                return false;
            }
            return true;
        }
        barSize++;
        this.repaint();//�� �ٽñ׸���
        this.notify();//��ٸ��� ConsumerThread ������ �����
		return false;
        
    }
	synchronized void consume(){
        if(barSize==0){
            try{
                this.wait();//���� ũ�Ⱑ 0�̸� ���� ũ�Ⱑ 0���� Ŀ�������� ���
            }
            catch(Exception e){
                return;
            }
        }
        barSize--;
        this.repaint();//�� �ٽ� �׸���
        this.notify();//��ٸ��� �̺�Ʈ ������ �����
    }
}

class ConsumerThread extends Thread{
    MyLabel con;
    ConsumerThread(MyLabel con){
        this.con=con;
    }
    public void run(){
        while(true){
            try{
                sleep(200);
                con.consume();//0.2�ʸ��� �ٸ� 1�� ���δ�.
            }
            catch(Exception e){
                return;
            }
        }
    }
}
@SuppressWarnings("serial")
class barGame extends JFrame{
	ImageIcon startScreen;
    MyLabel bar = new MyLabel(100);//���� �ִ� ũ�⸦ 100���� ����
    barGame(){
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/etc/omegaBoy.PNG"));
        this.setTitle("������ �̻��� Ż��");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
		startScreen = new ImageIcon("images/backgrounds/barGamebg.png");
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(startScreen.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}

		};
        bar.setBackground(Color.white);
        bar.setOpaque(true);
        bar.setLocation(290, 480);
        bar.setSize(500,60);
        panel.add(bar);
        //Ű ������ ���
        this.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
               if(bar.fill()==true) {

                	new gameStory7();
                	dispose();//Ű�� ���������� �ٰ� 1�� ����
                }
                
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }
            
        });
        this.setSize(1080,720);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
		this.setResizable(false);
		panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(panel);
		panel.setLayout(null);
		setContentPane(scrollPane);//�ʼ� �١١١١�
        this.requestFocus();//Ű ó���� �ο�
        ConsumerThread th = new ConsumerThread(bar);//������ ����
        th.start();//������ ����
    }
	public static void main(String[] args) {
		new barGame();
	}
}