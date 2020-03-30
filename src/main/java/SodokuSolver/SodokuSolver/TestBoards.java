package SodokuSolver.SodokuSolver;

import java.util.*;
import java.io.*;

public class TestBoards {
	public char[][] getExampleSolvedBoard1(){
		char[][] b = readInBoard("b1.txt");
		return b;
	}
	
	public char[][] getExampleUnsolvedBoard1(){
		char[][] b = readInBoard("b1.txt");
		b[3][3]='3';
		return b;
	}
	
	public char[][] getInitialBoard1(){
		char[][] b = readInBoard("b2.txt");
		return b;
	}
	
	
	public char[][] readInBoard(String filename) {
		char[][] b = new char[9][9];
		try {
			Scanner s = new Scanner(new File(filename));
			int lineCount =0;
			while(s.hasNextLine()) {
				String line = s.nextLine();
				for(int i=0;i<9;i++) {
					char ch = line.charAt(i);
					b[lineCount][i]=ch;
				}
				lineCount++;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	
}
