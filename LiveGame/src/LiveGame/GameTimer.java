package LiveGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
	private int interval;
	private LifeGame trigger;
	
	//将在主程序中初始化实例，计时器以interval秒的频率触发trigger
	public GameTimer(LifeGame trigger,int interval) {
		
		this.trigger=trigger;
		this.interval=interval;
		
		//按下start按钮，调用start()函数
		this.trigger.setStart(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				start();
			}
			
		});
		
	}
	
	//启动计时器，之后将以interval秒的间隔持续触发
	public void start() {
		
		  Timer timer = new Timer();
		      
		  //前一次执行程序结束后 interval*1000ms 后开始执行下一次程序
		  timer.schedule(new TimerTask() {
			  
		      @Override
		      public void run() {
		           trigger.game_cycle();      
		      }
		  
		 }, 0,interval*1000);
	}
}
