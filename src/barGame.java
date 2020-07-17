//import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
@SuppressWarnings("serial")
class MyLabel extends JLabel{
    int barSize=0;//바의 크기
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
        if(width==0) return;//크기가 0이면 바를 그릴 필요 없음
        g.fillRect(0,0,width,this.getHeight());
    }
    synchronized boolean fill(){
        if(barSize==maxBarSize){
        	//return 1;
            try{
                this.wait();
		//바의 크기가 최대이면, ConsumerThread에 의해 바의 크기가 줄어들때까지 대기
            }
            catch(Exception e){
                return false;
            }
            return true;
        }
        barSize++;
        this.repaint();//바 다시그리기
        this.notify();//기다리는 ConsumerThread 스레드 깨우기
		return false;
        
    }
	synchronized void consume(){
        if(barSize==0){
            try{
                this.wait();
		//바의 크기가 0이면 바의 크기가 0보다 커질때까지 대기
            }
            catch(Exception e){
                return;
            }
        }
        barSize--;
        this.repaint();//바 다시 그리기
        this.notify();//기다리는 이벤트 스레드 깨우기
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
                con.consume();//0.2초마다 바를 1씩 줄인다.
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
    MyLabel bar = new MyLabel(100);//바의 최대 크기를 100으로 지정
    barGame(){
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/etc/omegaBoy.PNG"));
        this.setTitle("팡이의 이상한 탈출");
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
        //키 리스너 등록
        this.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
               if(bar.fill()==true) {

                	new gameStory7();
                	dispose();//키를 누를때마다 바가 1씩 증가
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
		setContentPane(scrollPane);//필수 ☆☆☆☆☆
        this.requestFocus();//키 처리권 부여
        ConsumerThread th = new ConsumerThread(bar);//스레드 생성
        th.start();//스레드 시작
    }
	public static void main(String[] args) {
		new barGame();
	}
}
