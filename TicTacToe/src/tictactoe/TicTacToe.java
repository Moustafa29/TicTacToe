package tictactoe;

import java.util.* ;

public class TicTacToe {

	public static void main(String[] args) {
	Scanner	input=new Scanner(System.in);
	
//get the players names and symbol
	
	System.out.println("Enter the name of the first player (X): ");
	String name1=input.nextLine();
	
	System.out.println("Enter the name of the second player(O): ");
	String name2=input.nextLine();
	
	
	
//tic tac toe board
	char [][] board =new char[3][3];
	
	for(int i=0; i<3; i++) {
		for(int j=0 ; j<3; j++) {
			board[i][j]='-';
			
		}  
		
	}	
	
	boolean first_player=true , gameEnded=false;
	
while(!gameEnded) {	
		drawboard(board);	
		
//whose player turn
	
	char s =' ';
	
	if(first_player) {
		
		s='X';
	}else s='O';
	
	if(first_player)
		System.out.println(name1+" turn (X)");
	
	else System.out.println(name2+" turn (O)");
	
	
	
	int row=0 , col=0;
	
while(true) {
//getting the place from the user
	
	System.out.println("Enter a row (0 for 1st row , 1 for 2nd row , 2 for 3rd row)");
	 row=input.nextInt();
	System.out.println("Enter a column (0 for 1st col, 1 for 2nd col, 2 for 3rd col)");
     col=input.nextInt();
	
// check if the row and col in the board
	
	if(row<0 || col<0 || row >2 || col>2) {
		
		System.out.println("you out of board");
		//check if the place entered is taken
	}else if (board[row][col] != '-')
		System.out.println("this place is already taken");
	else {break;}
	}

//placing the player position
	
	board[row][col]=s;
	drawboard(board);
	
//check who won
	if(who_won(board)=='X') {
	System.out.println(name1+" has won!");
	gameEnded= true; }
	
	else if(who_won(board)=='O') {
		System.out.println(name2+" has won!");
	gameEnded= true;}
	
	else if(tied(board)) { 
		System.out.println("tie");
	gameEnded= true;}
	
	//change the turn
	else first_player = !first_player;
	  }
drawboard(board);

}
	//drawing dash board
	public static void drawboard(char [][] board) {
		
		for(int i=0; i<3; i++) {
			for(int j=0 ; j<3; j++) {
				System.out.print(board[i][j]);
			}
	          System.out.println();
		
	     }
	}
	
	
	//check who won
	
	public static char who_won(char[][] board) {
		//row check
		for(int i=0;i<3;i++) {
		if(board[i][0]== board[i][1] && board[i][1]==board[i][2] && board[i][0]!='-') {
			return board[i][0];}
		}
		
		//col check
		for(int j=0;j<3;j++) {
			if(board[0][j]== board[1][j] && board[1][j]==board[2][j] && board[0][j]!='-') {
				return board[0][j];}
			}
		//diagonal check
		 if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[0][0]!='-')
		return board[0][0];
		 
		 if(board[2][0]==board[1][1]&&board[1][1]==board[0][2]&&board[2][0]!='-')
				return board[2][0];
		 
		 //tie
		 return '-';
	}
	
	public static boolean tied(char [][] board) {
		for(int i=0 ;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[i][j]=='-')
				return false;	
			}
		}	
		return true;
	}
	
}