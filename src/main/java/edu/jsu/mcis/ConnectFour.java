package edu.jsu.mcis;

import java.io.*;
import java.util.*;

public class ConnectFour {
    public enum Location {EMPTY, RED, BLACK};
	private Location[][] board;
	private int COLUMNS = 7;
	private int ROWS = 6;
	private boolean redTurn;
	private int TOP = 5;
	private int mark = 0;
    
    public ConnectFour() {
        board = new Location[ROWS][COLUMNS];
		for(int i = 0; i < ROWS; i++)
		{
			for(int j = 0; j < COLUMNS; j++)
			{
				board[i][j] = Location.EMPTY;
			}
		}
		redTurn = true;
    }
    
    public Location getTopOfColumn(int column) {
		return board[TOP][column];
    }
    
    public int getHeightOfColumn(int column) {
		int j = 0;
		for(int i = 5; i >= 0; i--)
		{
			if(board[i][column] != Location.EMPTY)
			{
				j++;
			}
		}
        return j;
    }
    
    public void dropToken(int column) throws ColumnFullException{
		mark ++;
		for (int i = 5; i >= 0; i--)
		{
			if(board[i][column] == Location.EMPTY && redTurn == true){
				board[i][column] = Location.RED;
				TOP = i;
				redTurn = false;
				break;
			}
			else if(board[i][column] == Location.EMPTY && redTurn == false){
				board[i][column] = Location.BLACK;
				TOP = i;
				redTurn = true;
				break;
			}
		}
		if(mark > 6){
			throw new ColumnFullException(" ");
		}
    }
}