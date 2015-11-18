package client;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
/**
*
* The CaroGraphics class implements the JPanel draw a caro's board to the CaroFrame.
* 
*/	

@SuppressWarnings("serial")
public class CaroGraphics extends JPanel{
	public final static int sizeCell = 25;
	public final static int row = 25;
	public final static int col = 25;
	public final static int width = sizeCell * col + 1;
	public final static int height = sizeCell * row + 1;
	public int[][] board  ;
	/**
	* The method set a caro's board is  empty
	*/
	public void setBoard(){
		board = new int[25][25];
		for(int i = 0; i < 25; i++)
			for (int j = 0; j < 25; j++)
				board[i][j] = 0;
	}
	/**
	* The method set a caro's board with a int[][]
	* @param board1 The caro's board 
	*/
	public void setBoard(int[][] board1){
		for(int i = 0; i < 25; i++)
			for (int j = 0; j < 25; j++)
				board[i][j] = board1[i][j];
	}
	/**
	* The method set a Point of a caro's board is X or O
	* @param a 1:X, 2:O
	* @param b Rowselected
	* @param c Colselected
	*/
	public boolean setPoint(int a, int b, int c){
		if(board[b][c]!=0) return false;
		else{
			board[b][c] = a;
			return true;
		}
		
	}
	/**
	* The method draw a caro's board to a frame
	*/
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(new Color(238, 238, 238));
		for (int i = 0; i <= row; i++) {
			g.drawLine(i * sizeCell, 0, i * sizeCell, height - 1);
			g.drawLine(0, i * sizeCell, width - 1, i * sizeCell);
		}
		for( int i = 0; i< row; i++)
			for( int j = 0; j < col; j++){
				if(board[i][j]==1){
					g.setColor(Color.RED);
					g.drawLine(j * sizeCell +2 ,i * sizeCell +2, (j+1)*sizeCell-2,(i+1)*sizeCell-2 );
					g.drawLine(j * sizeCell +2, (i+1)*sizeCell+2, (j+1)*sizeCell-2, i*sizeCell-2);
				}
				if(board[i][j] == 2){
					g.setColor(Color.BLUE);
					g.drawOval((j*sizeCell), (i*sizeCell), 24, 24);
				}
			}
	}
}
