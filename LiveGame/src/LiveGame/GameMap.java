package LiveGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameMap extends JPanel{
	
	private final int rows=25;
	private final int cols=25;
	private int isAlive[][];
	
	private final int gridSize=20; 
	private JButton start=new JButton("start") ;
	
	//地图将在逻辑模块进行初始化
	public GameMap(int[][] init_life_ratio) {
		
		JFrame f=new JFrame();
		
		f.setTitle("game of life");
		
		f.setLayout(null);
		f.setResizable(false);
	//	f.setSize(580, 560);
		
		int screenW=(int)this.getToolkit().getScreenSize().getWidth();
		int screenH=(int)this.getToolkit().getScreenSize().getHeight();
		//f.setLocation((screenW-500)/2, (screenH-500)/2);
		f.setBounds((screenW-580)/2, (screenH-560)/2,600,560);
		
		this.setLayout(null);
		this.add(start);
		this.setBounds(0, 0, 640, 550);
		start.setBounds(505, 10, 70, 30);
		
		f.add(this);
		
		//地图初始化
		isAlive=init_life_ratio;
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//重置地图并按life_ratio填充地图
	public void reset(int[][] life_ratio) {
		
		isAlive=life_ratio;
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
	
				this.fill(i, j, isAlive[i][j]);	
			}
		}
	}
	
	//地图上一个方格周围活细胞数
	public int get_neighbor_count(int row,int col) {
		
		int count=0;
		if (row==0 && col==0) {  //左上角顶点
			count=isAlive[row][col+1]+isAlive[row+1][col]+isAlive[row+1][col+1];
		}
		else if(row==0 && col==cols-1) {  //右上角顶点
			count=isAlive[row][col-1]+isAlive[row+1][col]+isAlive[row+1][col-1];
		}
		else if(row==rows-1 && col==0){  //左下角顶点
			count=isAlive[row-1][col]+isAlive[row-1][col+1]+isAlive[row][col+1];
		}
		else if(row==rows-1 && col==cols-1) {  //右下角顶点
			count=isAlive[row-1][col]+isAlive[row-1][col-1]+isAlive[row][col-1];
		}
		else if(row==0 && col>0 && col<cols-1){  //最上面一行不包括顶点
			for(int i=col-1;i<=col+1;i++) {
				count+=isAlive[row][i];
				count+=isAlive[row+1][i];
			}
			count=count-isAlive[row][col];
		}
		else if(row==rows-1 && col>0 && col<cols-1) {  //最下面一行不包括顶点
			for(int i=col-1;i<=col+1;i++) {
				count+=isAlive[row][i];
				count+=isAlive[row-1][i];
			}
			count=count-isAlive[row][col];
		}
		else if(col==0 && row>0 && row<rows-1) {  //最左边一行不包括顶点
			for(int i=row-1;i<=row+1;i++) {
				count+=isAlive[i][col];
				count+=isAlive[i][col+1];
			}
			count=count-isAlive[row][col];
		}
		else if(col==cols-1 && row>0 && row<rows-1) {  //最右边一行不包括顶点
			for(int i=row-1;i<=row+1;i++) {
				count+=isAlive[i][col];
				count+=isAlive[i][col-1];
			}
			count=count-isAlive[row][col];
		}
		else {  //周围有8个点的情况
			for(int i=col-1;i<=col+1;i++) {
				count+=isAlive[row-1][i];
				count+=isAlive[row][i];
				count+=isAlive[row+1][i];
			}
			count=count-isAlive[row][col];
		}
			
		return count;
	}
	
	//更新地图上方格的状态，填充颜色
	private void fill(int row,int col,int val) {
		
		//isAlive[row][col]=val;
		
		Graphics g=this.getGraphics();
		
		if(val==1)  //活，地图上填充黑色
		{
			g.setColor(Color.BLACK);
			g.fillRect(col*gridSize+1, row*gridSize+1, gridSize-1, gridSize-1);
			
		}
		else        //死，地图上填充白色
		{
			g.setColor(Color.WHITE);
			g.fillRect(col*gridSize+1, row*gridSize+1, gridSize-1, gridSize-1);
		}
		
	}
	
	//获取地图上方格的状态
	public int get(int row,int col) {
		
		return isAlive[row][col];
	}
	
	
	//获取行数
	public int getRows() {
		return this.rows;
	}
	//获取列数
	public int getCols() {
		return this.cols;
	}
	
	//绘制地图格子,并初始化地图
	public void paint(Graphics g) {
		
		g.setColor(Color.LIGHT_GRAY);   
		
		for(int i=0;i<=rows;i++) {  //画行
			g.drawLine(i*gridSize, 0, i*gridSize, rows*gridSize);
		}
		for(int i=0;i<=cols;i++) {  //画列
			g.drawLine(0, i*gridSize, cols*gridSize, i*gridSize);
		}
		
		//画初始地图
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(isAlive[i][j]==1)  //活，地图上填充黑色
				{
					g.setColor(Color.BLACK);
					g.fillRect(j*gridSize+1, i*gridSize+1, gridSize-1, gridSize-1);
				}
				else        //死，地图上填充白色
				{
					g.setColor(Color.WHITE);
					g.fillRect(j*gridSize+1, i*gridSize+1, gridSize-1, gridSize-1);
					
				}
			}
		}
		
	}
	
	//为start按钮注册事件
	public void setStart(ActionListener e) {
		start.addActionListener(e);
	}

}
