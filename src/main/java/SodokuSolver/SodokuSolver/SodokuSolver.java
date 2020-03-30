package SodokuSolver.SodokuSolver;

public class SodokuSolver {
	
	public SodokuSolver() {
		
	}
	
	
	public char[][] solve(char[][] board) {
		int addI=0;
		int addJ=0;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[i][j]=='.') {
					addI=i;
					addJ=j;
				}
			}
		}
		for(int i=1;i<=9;i++) {
			String addChStr = "" + i;
			char newAddCh = addChStr.charAt(0);
			board = solveRec(board, addI, addJ, newAddCh);
			if(this.checkBoardCompletedAndValid(board)) {
				return board;
			}
			board[addI][addJ]='.';
		}
		return board;
	}
	
	public char[][] solveRec(char[][] board, int addI, int addJ, char addCh) {
		board[addI][addJ]=addCh;
		if(this.checkBoardCompletedAndValid(board)) {
			return board;
		}
		else if(this.checkBoardValid(board)==false) {
			board[addI][addJ]='.';
			return board;
		}
		else {
			int newAddI=0;
			int newAddJ=0;
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					if(board[i][j]=='.') {
						newAddI=i;
						newAddJ=j;
					}
				}
			}
			for(int i=1;i<=9;i++) {
				String addChStr = "" + i;
				char newAddCh = addChStr.charAt(0);
				board = solveRec(board, newAddI, newAddJ, newAddCh);
				if(this.checkBoardCompletedAndValid(board)) {
					return board;
				}
			}
			board[newAddI][newAddJ]='.';
			return board;
		}
	}
	
	
	
	public boolean checkBoardCompletedAndValid(char[][] board) {
		return checkBoardFull(board) && checkBoardValid(board);
	}
	
	public boolean checkBoardFull(char[][] board) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[i][j]=='.') {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkBoardValid(char[][] board) {
		return checkSections(board) && checkRowsAndCols(board);
	}
	
	public boolean checkSections(char[][] board) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				char[] section = getSection(board, i, j);
				int[] digitCounts = new int[10];
				for(char ch : section) {
					if(ch=='.') {
						continue;
					}
					//System.out.println("ch = " + ch);
					int value = Integer.parseInt("" + ch);
					digitCounts[value]+=1;
					if(digitCounts[value]>1) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public boolean checkRowsAndCols(char[][] board) {
		for(int i=0;i<9;i++) {
			
			int[] digitCounts = new int[10];
			
			for(int j=0;j<9;j++) {
				if(board[i][j]=='.') {
					continue;
				}
				int digit = Integer.parseInt("" + board[i][j]);
				digitCounts[digit]+=1;
				if(digitCounts[digit]>1) {
					return false;
				}
			}
		}
		
		
		
		for(int j=0;j<9;j++) {
			int[] digitCounts = new int[10];
			for(int i=0;i<9;i++) {
				if(board[i][j]=='.') {
					continue;
				}
				int digit = Integer.parseInt("" + board[i][j]);
				
				digitCounts[digit]+=1;
				if(digitCounts[digit]>1) {
					return false;
				}
			}
		}
		return true;
	}
	
	public char[] getSection(char[][] board, int secI, int secJ) {
		char[] section = new char[9];
		int initialI = secI*3;
		int initialJ = secJ*3;
		int index = 0;
		for(int i=initialI;i<initialI+3;i++) {
			for(int j=initialJ;j<initialJ+3;j++) {
				section[index++]=board[i][j];
			}
		}
		return section;
	}
	
	public void printBoard(char[][] board) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
