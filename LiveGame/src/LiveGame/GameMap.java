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
	
	//��ͼ�����߼�ģ����г�ʼ��
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
		
		//��ͼ��ʼ��
		isAlive=init_life_ratio;
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//���õ�ͼ����life_ratio����ͼ
	public void reset(int[][] life_ratio) {
		
		isAlive=life_ratio;
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
	
				this.fill(i, j, isAlive[i][j]);	
			}
		}
	}
	
	//��ͼ��һ��������Χ��ϸ����
	public int get_neighbor_count(int row,int col) {
		
		int count=0;
		if (row==0 && col==0) {  //���ϽǶ���
			count=isAlive[row][col+1]+isAlive[row+1][col]+isAlive[row+1][col+1];
		}
		else if(row==0 && col==cols-1) {  //���ϽǶ���
			count=isAlive[row][col-1]+isAlive[row+1][col]+isAlive[row+1][col-1];
		}
		else if(row==rows-1 && col==0){  //���½Ƕ���
			count=isAlive[row-1][col]+isAlive[row-1][col+1]+isAlive[row][col+1];
		}
		else if(row==rows-1 && col==cols-1) {  //���½Ƕ���
			count=isAlive[row-1][col]+isAlive[row-1][col-1]+isAlive[row][col-1];
		}
		else if(row==0 && col>0 && col<cols-1){  //������һ�в���������
			for(int i=col-1;i<=col+1;i++) {
				count+=isAlive[row][i];
				count+=isAlive[row+1][i];
			}
			count=count-isAlive[row][col];
		}
		else if(row==rows-1 && col>0 && col<cols-1) {  //������һ�в���������
			for(int i=col-1;i<=col+1;i++) {
				count+=isAlive[row][i];
				count+=isAlive[row-1][i];
			}
			count=count-isAlive[row][col];
		}
		else if(col==0 && row>0 && row<rows-1) {  //�����һ�в���������
			for(int i=row-1;i<=row+1;i++) {
				count+=isAlive[i][col];
				count+=isAlive[i][col+1];
			}
			count=count-isAlive[row][col];
		}
		else if(col==cols-1 && row>0 && row<rows-1) {  //���ұ�һ�в���������
			for(int i=row-1;i<=row+1;i++) {
				count+=isAlive[i][col];
				count+=isAlive[i][col-1];
			}
			count=count-isAlive[row][col];
		}
		else {  //��Χ��8��������
			for(int i=col-1;i<=col+1;i++) {
				count+=isAlive[row-1][i];
				count+=isAlive[row][i];
				count+=isAlive[row+1][i];
			}
			count=count-isAlive[row][col];
		}
			
		return count;
	}
	
	//���µ�ͼ�Ϸ����״̬�������ɫ
	private void fill(int row,int col,int val) {
		
		//isAlive[row][col]=val;
		
		Graphics g=this.getGraphics();
		
		if(val==1)  //���ͼ������ɫ
		{
			g.setColor(Color.BLACK);
			g.fillRect(col*gridSize+1, row*gridSize+1, gridSize-1, gridSize-1);
			
		}
		else        //������ͼ������ɫ
		{
			g.setColor(Color.WHITE);
			g.fillRect(col*gridSize+1, row*gridSize+1, gridSize-1, gridSize-1);
		}
		
	}
	
	//��ȡ��ͼ�Ϸ����״̬
	public int get(int row,int col) {
		
		return isAlive[row][col];
	}
	
	
	//��ȡ����
	public int getRows() {
		return this.rows;
	}
	//��ȡ����
	public int getCols() {
		return this.cols;
	}
	
	//���Ƶ�ͼ����,����ʼ����ͼ
	public void paint(Graphics g) {
		
		g.setColor(Color.LIGHT_GRAY);   
		
		for(int i=0;i<=rows;i++) {  //����
			g.drawLine(i*gridSize, 0, i*gridSize, rows*gridSize);
		}
		for(int i=0;i<=cols;i++) {  //����
			g.drawLine(0, i*gridSize, cols*gridSize, i*gridSize);
		}
		
		//����ʼ��ͼ
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(isAlive[i][j]==1)  //���ͼ������ɫ
				{
					g.setColor(Color.BLACK);
					g.fillRect(j*gridSize+1, i*gridSize+1, gridSize-1, gridSize-1);
				}
				else        //������ͼ������ɫ
				{
					g.setColor(Color.WHITE);
					g.fillRect(j*gridSize+1, i*gridSize+1, gridSize-1, gridSize-1);
					
				}
			}
		}
		
	}
	
	//Ϊstart��ťע���¼�
	public void setStart(ActionListener e) {
		start.addActionListener(e);
	}

}
