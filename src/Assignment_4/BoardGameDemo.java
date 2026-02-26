package Assignment_4;

import java.util.Scanner;

// Abstract class
abstract class BoardGame {
    protected String gameName;

    BoardGame(String gameName) {
        this.gameName = gameName;
    }

    abstract void play();
    abstract void displayBoard();
}

// Chess class
class Chess extends BoardGame {

    char[][] board = new char[8][8];

    Chess() {
        super("Chess");
        initializeBoard();
    }

    void initializeBoard() {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                board[i][j] = '.';

        board[1][4] = 'P'; // Pawn
        board[0][6] = 'N'; // Knight
    }

    void movePiece(String piece, String from, String to) {
        System.out.println(piece + " moved from " + from + " to " + to);
    }

    @Override
    void play() {
        System.out.println("Playing " + gameName);
        movePiece("Pawn", "E2", "E4");
        movePiece("Knight", "G1", "F3");
    }

    @Override
    void displayBoard() {
        System.out.println("Chess Board:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Tic-Tac-Toe class
class TicTacToe extends BoardGame {

    char[][] board = new char[3][3];

    TicTacToe() {
        super("Tic-Tac-Toe");
        initializeBoard();
    }

    void initializeBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = '-';
    }

    void makeMove(int row, int col, char player) {
        if (board[row][col] == '-') {
            board[row][col] = player;
            System.out.println("Player " + player + " placed at (" + row + "," + col + ")");
        }
    }

    @Override
    void play() {
        System.out.println("Playing " + gameName);
        makeMove(0, 0, 'X');
        makeMove(1, 1, 'O');
        makeMove(0, 1, 'X');
    }

    @Override
    void displayBoard() {
        System.out.println("Tic-Tac-Toe Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Main class
public class BoardGameDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a game to play:");
        System.out.println("1. Chess");
        System.out.println("2. Tic-Tac-Toe");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();
        BoardGame game;

        if (choice == 1) {
            game = new Chess();
        } else if (choice == 2) {
            game = new TicTacToe();
        } else {
            System.out.println("Invalid choice!");
            sc.close();
            return;
        }

        game.play();
        game.displayBoard();

        sc.close();
    }
}
