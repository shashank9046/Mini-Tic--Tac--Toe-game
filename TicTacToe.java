import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	Scanner sc = new Scanner(System.in);
	static int side = 3;
	int moves = 0;
	static int r;
	int c;
	char[][] board = new char[side][side];
	String player1;
	String player2;

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}

	public boolean diagonalCrossed(char board[][]) {
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')
			return (true);

		if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')
			return (true);

		return (false);
	}

	public boolean columnCrossed(char board[][]) {

		for (int i = 0; i < side; i++) {
			if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')
				return (true);
		}
		return (false);
	}

	public boolean rowCrossed(char board[][]) {
		for (int i = 0; i < side; i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ')
				return (true);
		}
		return (false);
	}

	public boolean gameover(char board[][]) {
		return (rowCrossed(board) || columnCrossed(board) || diagonalCrossed(board));
	}

	public void showboard(char board[][]) {
		System.out.print("\n\n");

		System.out.printf("\t\t\t %c | %c | %c \n", board[0][0], board[0][1], board[0][2]);

		System.out.print("\t\t\t------------\n");

		System.out.printf("\t\t\t %c | %c | %c \n", board[1][0], board[1][1], board[1][2]);

		System.out.print("\t\t\t------------\n");
		System.out.printf("\t\t\t %c | %c | %c \n\n", board[2][0], board[2][1], board[2][2]);

		return;
	}

	public void instructions() {
		System.out.print("\t\t\t Tic-Tac-Toe\n\n");

		System.out.print("Choose a cell numbered " + "from 1 to 9 as below" + " and play\n\n");

		System.out.print("\t\t\t 1 | 2 | 3 \n");
		System.out.print("\t\t\t------------\n");
		System.out.print("\t\t\t 4 | 5 | 6 \n");
		System.out.print("\t\t\t------------\n");
		System.out.print("\t\t\t 7 | 8 | 9 \n\n");

		System.out.print("-\t-\t-\t-\t-\t-\t-\t-\t-\t-\n\n");

		return;
	}

	public void initialise(char board[][]) {
		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++)
				board[i][j] = ' ';
		}
	}

	public void playgame(String whoseturn) {
		while ((gameover(board) == false) && (moves != side * side)) {
			if (whoseturn.equals(player1)) {
				System.out.println(player1 + " Enter the respective row and column to insert X ");
				int row = sc.nextInt();
				int column = sc.nextInt();
				if ((row <= 3 && row > 0) && (column <= 3 && column > 0)) {
					if (board[row - 1][column - 1] == ' ') {
						board[row - 1][column - 1] = 'X';
					} else {
						System.out.println("You can not overlap on already filled position");
						continue;
					}
				} else {
					System.out.println("input is not valid please enter the right one");
					continue;
				}
				showboard(board);
				moves++;
				whoseturn = player2;
			} else if (whoseturn.equals(player2)) {
				System.out.println(player2 + " Enter the respective row and column to insert O ");
				int row = sc.nextInt();
				int column = sc.nextInt();
				if ((row <= 3 && row > 0) && (column <= 3 && column > 0)) {
					if (board[row - 1][column - 1] == ' ') {
						board[row - 1][column - 1] = 'O';
					} else {
						System.out.println("You can not overlap on already filled position");
						continue;
					}
				} else {
					System.out.println("input is not valid please enter the right one");
					continue;
				}
				showboard(board);
				moves++;
				whoseturn = player1;
			}
		}
		if ((gameover(board) == false) && (moves == side * side)) {
			System.out.println("It's a draw...");
		} else {
			if (whoseturn.equals(player1)) {
				moves = side * side;
				System.out.println(player2 + " has won the game");
			} else if (whoseturn.equals(player2)) {
				moves = side * side;
				System.out.println(player1 + " has won the game");
			}
		}
	}

	public void setup() {
		initialise(board);
		instructions();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of player1");
		String p1 = sc.nextLine();
		TicTacToe obj = new TicTacToe();
		obj.setPlayer1(p1);
		System.out.println("Enter name of player2");
		String p2 = sc.nextLine();
		obj.setPlayer2(p2);
		int t = rand.nextInt(1000);
		int toss = t % 2;
		if (toss == 1) {
			System.out.println("player1 " + obj.getPlayer1() + " win the toss");
			obj.setup();
			obj.playgame(obj.getPlayer1());
		} else {
			System.out.println("player2 " + obj.getPlayer2() + " win the toss");
			obj.setup();
			obj.playgame(obj.getPlayer2());
		}
		sc.close();
	}

}
