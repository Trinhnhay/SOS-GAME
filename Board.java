package Production_Code;

import java.util.Random;

public class Board {

	// ' ' for empty, S for S, O for O
	public char element = ' ';
	public char[][] grid;
	public int size; // initialize the board size
	public String gameMode = null;
	public String turn;// either blue or red
	//public String redPlayer;// human or computer
	//public String bluePlayer;
	public int row;
	public int col;
	
	public Board() {

		initializeBoard();
		turn = "blue";
		
	}

	public Board(int boardSize, String mode) {
		getBoardSize(boardSize);
		getGameMode(mode);
		turn = "blue";
		initializeBoard();

	}
	
	public void getBoardSize(int boardSize) {
		if (boardSize >= 3 && boardSize <= 20) {
			size = boardSize;
		} else
			size = 0;
	}

	public void getGameMode(String mode) {
		if (mode.equals("simple") || mode.equals("general"))
			gameMode = mode;
		else
			gameMode = null;
	}

	public void initializeBoard() {
		grid = new char[size][size];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				grid[row][col] = ' ';
			}
		}
	}

	public void getElement(char chess) {
		if (chess == 'S' || chess == 'O')
			element = chess;
		else
			element = ' ';
	}

	public void simpleMakeMove(int row, int col) {
		if (row >= 0 && row < size && col >= 0 && col < size && grid[row][col] == ' ' && element != ' ') {
			grid[row][col] = element;
			if (turn.equals("blue")) {
				turn = "red";
			} else if (turn.equals("red")) {
				turn = "blue";
			}
		}
	}

	public void generalMakeMove(int row, int col) {
		if (row >= 0 && row < size && col >= 0 && col < size && grid[row][col] == ' ' && element != ' ') {
			grid[row][col] = element;
			if (checkSOS(row, col) == 0 && turn.equals("blue")) {
				turn = "red";
			} else if (checkSOS(row, col) == 0 && turn.equals("red")) {
				turn = "blue";
			}
		}
	}

	public int checkSOS(int row, int col) {
		int count = 0;
		if (grid[row][col] == 'O') {
			try {
				if (grid[row][col + 1] == 'S' && grid[row][col - 1] == 'S')
					count++;
			} catch (Exception e) {
			}

			try {
				if (grid[row + 1][col] == 'S' && grid[row - 1][col] == 'S')
					count++;
			} catch (Exception e) {
			}

			try {
				if (grid[row - 1][col - 1] == 'S' && grid[row + 1][col + 1] == 'S')
					count++;
			} catch (Exception e) {
			}
			try {
				if (grid[row + 1][col - 1] == 'S' && grid[row - 1][col + 1] == 'S')
					count++;
			} catch (Exception e) {
			}
		} else if (grid[row][col] == 'S') {
			try {
				if (grid[row][col + 1] == 'O' && grid[row][col + 2] == 'S')
					count++;
			} catch (Exception e) {
			}

			try {
				if (grid[row][col - 1] == 'O' && grid[row][col - 2] == 'S')
					count++;
			} catch (Exception e) {
			}
			try {
				if (grid[row - 1][col] == 'O' && grid[row - 2][col] == 'S')
					count++;
			} catch (Exception e) {
			}
			try {
				if (grid[row + 1][col] == 'O' && grid[row + 2][col] == 'S')
					count++;
			} catch (Exception e) {
			}
			try {
				if (grid[row + 1][col + 1] == 'O' && grid[row + 2][col + 2] == 'S')
					count++;
			} catch (Exception e) {
			}
			try {
				if (grid[row - 1][col - 1] == 'O' && grid[row - 2][col - 2] == 'S')
					count++;
			} catch (Exception e) {
			}
			try {
				if (grid[row - 1][col + 1] == 'O' && grid[row - 2][col + 2] == 'S')
					count++;
			} catch (Exception e) {
			}
			try {
				if (grid[row + 1][col - 1] == 'O' && grid[row + 2][col - 2] == 'S')
					count++;
			} catch (Exception e) {
			}

		}
		return count;
	}

	public boolean isFullBoard() {
		boolean flag = true;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (grid[i][j] == ' ') {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	
	public char chooseElement() {
		Random random= new Random();
		int num = random.nextInt(100);
		if (num%2==0)
			element='O';
		else
			element ='S';
		return element;
	}

}
