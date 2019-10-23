package LiveGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
	private int interval;
	private LifeGame trigger;
	
	//�����������г�ʼ��ʵ������ʱ����interval���Ƶ�ʴ���trigger
	public GameTimer(LifeGame trigger,int interval) {
		
		this.trigger=trigger;
		this.interval=interval;
		
		//����start��ť������start()����
		this.trigger.setStart(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				start();
			}
			
		});
		
	}
	
	//������ʱ����֮����interval��ļ����������
	public void start() {
		
		  Timer timer = new Timer();
		      
		  //ǰһ��ִ�г�������� interval*1000ms ��ʼִ����һ�γ���
		  timer.schedule(new TimerTask() {
			  
		      @Override
		      public void run() {
		           trigger.game_cycle();      
		      }
		  
		 }, 0,interval*1000);
	}
}
