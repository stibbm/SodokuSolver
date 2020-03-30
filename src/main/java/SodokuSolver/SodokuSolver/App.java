package SodokuSolver.SodokuSolver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SodokuSolver ss = new SodokuSolver();
        TestBoards tb = new TestBoards();
        char[][] exampleSolvedBoard = tb.getExampleSolvedBoard1();
        printBoard(exampleSolvedBoard);
        //System.exit(0);
        boolean result = ss.checkBoardCompletedAndValid(exampleSolvedBoard);
        System.out.println("true == " + result);
        char[][] exampleUnsolvedBoard = tb.getExampleUnsolvedBoard1();
        boolean result2 = ss.checkBoardCompletedAndValid(exampleUnsolvedBoard);
        System.out.println("false == " + result2);
        char[][] exampleStartingBoard = tb.getInitialBoard1();
        boolean checkValid = ss.checkBoardValid(exampleStartingBoard);
        System.out.println("true == " + checkValid);
        
        char[][] solved = ss.solve(exampleStartingBoard);
        printBoard(solved);
        
        char[][] tb2 = tb.readInBoard("b3.txt");
        char[][] tb2Solved = ss.solve(tb2);
        printBoard(tb2Solved);
        
        
        char[][] expertBoard = tb.readInBoard("b4.txt");
        char[][] solvedExpertBoard=ss.solve(expertBoard);
        printBoard(solvedExpertBoard);
        
    }
    
    public static void printBoard(char[][] board) {
    	for(int i=0;i<9;i++) {
    		for(int j=0;j<9;j++) {
    			System.out.print(board[i][j] + " ");
    			
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
}
