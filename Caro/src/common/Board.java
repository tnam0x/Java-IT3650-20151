package common;

import java.io.Serializable;

/**
 * The board class describe a board
 *
 */
@SuppressWarnings("serial")
public class Board implements Serializable{
	private Point[][] board;
	public static final int BOARDSIZE = 25;
	//numbered direction
	public static final int D_UP		= 0;
	public static final int D_UPRIGHT   = 1;
	public static final int D_RIGHT		= 2;
	public static final int D_DOWNRIGHT	= 3;
	public static final int D_DOWN      = 4;
	public static final int D_DOWNLEFT  = 5;
	public static final int D_LEFT      = 6;
	public static final int D_UPLEFT    = 7;
    //the change of direction
    private int[] dX, dY;
    /**
     * The contructor methods create an empty board
     */
    public Board(){
    	//create an empty board
    	this.board = new Point[25][25];
    	for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                board[i][j] = new Point();
            }
        }
    	//make the change
    	this.dX = new int[8];
    	this.dY = new int[8];
    	dX[0] =  0;  dY[0] = -1;
        dX[1] =  1;  dY[1] = -1;
        dX[2] =  1;  dY[2] =  0;
        dX[3] =  1;  dY[3] =  1;
        dX[4] =  0;  dY[4] =  1;
        dX[5] = -1;  dY[5] =  1;
        dX[6] = -1;  dY[6] =  0;
        dX[7] = -1;  dY[7] = -1;
    }
    /**
     * The countPoint methods counting number of point in a row with one direction
     * @param color a state of point need to count
     * @param x coordinates of start point
     * @param y coordinates of start point
     * @param direc direction
     * @return number of point with same color in a row with one direction
     */
    public int countPoint(int color, int x, int y, int direc){
    	int number = 0;
    	int dx = dX[direc];
    	int dy = dY[direc];
    	
    	while (board[x][y].getState() == color){
    		number++;
    		x += dx;
    		y += dy;
    		//check limit
    		if( x < 0 || x >= BOARDSIZE || y < 0 || y >= BOARDSIZE ) break;
    		//check empty
    		if(board[x][y].getState() == Point.EMPTY)
    			break; 		
    	}
    	return number;
    }
    /**
     * The check methods count number of point with a same color in a row with every direction
     * @param color a state of point need to check
     * @param x coordinates of start point
     * @param y coordinates of start point
     * @return
     * true : if  have 5 or more points in a row,
     * false : if have less than 5 points in a row
     */
    public boolean check(int color, int x, int y){
    	int max, next;
    	
    	max = countPoint(color,	x, y, D_UP) + countPoint(color, x, y, D_DOWN) - 1;
    	next = countPoint(color, x, y, D_LEFT) + countPoint(color, x, y, D_RIGHT) - 1;
    	max = (max > next) ? max : next;
    	
    	next = countPoint(color, x, y, D_UPLEFT) + countPoint(color, x, y, D_DOWNRIGHT) - 1;
    	max = (max > next) ? max : next;
    	
    	next = countPoint(color, x, y, D_UPRIGHT) + countPoint(color, x, y, D_DOWNLEFT) - 1;
    	max = (max > next) ? max : next;
    	
    	if (max >= 5)
    		return true;
    	return false;
    }
    /**
     * The put methods setting a state for one point in board
     * @param color a state of point
     * @param x coordinates of point
     * @param y coordinates of point
     * @return
     * false : if the point had a state, 
     * true : if setting done
     */
    public boolean put(int color, int x, int y){
    	boolean rs = false;
    	if (board[x][y].getState() == 0){
    		if (color == Point.RED){
    			board[x][y].setState(Point.RED);
    			rs = true;
    		}
    		else if (color == Point.BLUE){
    			board[x][y].setState(Point.BLUE);
    			rs = true;
    		}
    	}
    	return rs;
    }
    /**
     * The reset methods reset the board
     */
    public void reset(){
    	for (int i = 0; i<25; i++)
    		for (int j = 0; j<25; j++)
    			this.board[i][j] = new Point();
    }
    /**
     * The getState methods getting the state of the point on coordinates
     * @param i coordinates og point
     * @param j coordinates of point
     * @return
     */
	public int getState(int i, int j) {
		return this.board[i][j].getState();
	}
}
