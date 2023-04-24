package Production_Code;

import java.util.Random;

public class GeneralMode extends Board {

	public Board newBoard = new Board();
	public int blueScore = 0;
	public int redScore = 0;
	public String result;

	public GeneralMode(Board board) {
		newBoard = board;
	}

	public void generalMove(int row, int col) {
		if (row >= 0 && row < newBoard.size && col >= 0 && col < newBoard.size && newBoard.grid[row][col] == ' '
				&& newBoard.element != ' ') {
			newBoard.grid[row][col] = newBoard.element;
			isEndGame(row,col);
			
		}
	}
	public void isEndGame(int row, int col) {
		if (newBoard.checkSOS(row, col) != 0) {
			if (newBoard.turn.equals("blue"))
				blueScore += newBoard.checkSOS(row, col);
			else if (newBoard.turn.equals("red"))
				redScore += newBoard.checkSOS(row, col);
		} else if (newBoard.checkSOS(row, col) == 0) {
			if (newBoard.turn.equals("blue")) {
				newBoard.turn = "red";
			}
			else if (newBoard.turn.equals("red")) {
				newBoard.turn = "blue";
			}
		}
	}

	public void isHavingWinner() {
		if (newBoard.isFullBoard()) {
			if (blueScore == redScore)
				result = "draw";
			else if (blueScore > redScore)
				result = "blue";
			else if (redScore > blueScore)
				result = "red";
		}
	}
	public void AutoGeneralPlay() {
		Random random= new Random();
		do {
			newBoard.row = random.nextInt(newBoard.size); 
			newBoard.col = random.nextInt(newBoard.size);
		}while(newBoard.grid[newBoard.row][newBoard.col] != ' ');
		
		if (newBoard.row >= 0 && newBoard.row < newBoard.size && newBoard.col >= 0 && newBoard.col <newBoard.size && newBoard.grid[newBoard.row][newBoard.col] == ' ') {
			newBoard.grid[newBoard.row][newBoard.col] = newBoard.chooseElement();
			
			isEndGame(newBoard.row,newBoard.col);

		}
	}

}
