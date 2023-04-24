package Production_Code;

import java.util.Random;

public class SimpleMode extends Board {

	public Board newBoard = new Board();
	public String winner;
	
	public SimpleMode() {
		
	}

	public SimpleMode(Board board) {
		newBoard = board;
	}

	public void simpleMove(int row, int col) {
		if (row >= 0 && row < newBoard.size && col >= 0 && col < newBoard.size && newBoard.grid[row][col] == ' '
				&& newBoard.element != ' ') {
			newBoard.grid[row][col] = newBoard.element;
			doesEndGame( row, col);
		} 
	}
	public void doesEndGame(int row, int col) {
		
		if (newBoard.turn.equals("blue")) {
			if (newBoard.checkSOS(row, col) == 0) {
				if (newBoard.isFullBoard())
					winner = "draw";
				else
					newBoard.turn = "red";
			} else
				winner = "blue";
		} else if (newBoard.turn.equals("red")) {
			if (newBoard.checkSOS(row, col) == 0) {
				if (newBoard.isFullBoard())
					winner = "draw";
				else {
					newBoard.turn = "blue";
				}
			} else {
				winner = "red";
			}
		}
	}
	
	public void AutoSimplePlay() {
		Random random= new Random();
		do {
			newBoard.row = random.nextInt(newBoard.size); 
			newBoard.col = random.nextInt(newBoard.size);
		}while(newBoard.grid[newBoard.row][newBoard.col] != ' ');
		if (newBoard.row >= 0 && newBoard.row < newBoard.size && newBoard.col >= 0 && newBoard.col < newBoard.size && newBoard.grid[newBoard.row][newBoard.col] == ' ') {
			newBoard.grid[newBoard.row][newBoard.col] = newBoard.chooseElement();
			doesEndGame(newBoard.row, newBoard.col);
		}
		
	}

}
