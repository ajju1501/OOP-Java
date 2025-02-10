import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        String[][] board = new String[5][5];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            board[i] = sc.nextLine().trim().split("\\s+");
        }


        String[] calledNumbers = sc.nextLine().trim().split(", ");

     
        BingoGame game = new BingoGame(board, calledNumbers);
        game.play();
        game.printResult();

        sc.close();
    }
}


class Board {
    String[][] board;
    boolean[][] marks;
    int size = 5;

    public Board(String[][] board) {
        this.board = board;
        this.marks = new boolean[size][size];  
    }

 
    public void markNumbers(String[] calledNumbers) {
        for (String mark : calledNumbers) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (board[j][k].equals(mark)) {
                        board[j][k] = "X";
                        marks[j][k] = true;
                    }
                }
            }
        }
    }

    
    public boolean isRowComplete(int row) {
        for (int i = 0; i < size; i++) {
            if (!board[row][i].equals("X")) {
                return false;
            }
        }
        return true;
    }

    
    public boolean isColumnComplete(int column) {
        for (int i = 0; i < size; i++) {
            if (!board[i][column].equals("X")) {
                return false;
            }
        }
        return true;
    }

    
    public boolean isMainDiagonalComplete() {
        for (int i = 0; i < size; i++) {
            if (!board[i][i].equals("X")) {
                return false;
            }
        }
        return true;
    }

    
    public boolean isAntiDiagonalComplete() {
        for (int i = 0; i < size; i++) {
            if (!board[i][size - i - 1].equals("X")) {
                return false;
            }
        }
        return true;
    }

   
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-1; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.print(board[i][size-1]);
            System.out.println();
        }
    }
}


class BingoGame {
    String[][] board;
    String[] calledNumbers;
    private String bingoLetters = "";
    private char[] LETTERS = {'B', 'I', 'N', 'G', 'O'};
    private Board b;

    public BingoGame(String[][] board, String[] calledNumbers) {
        this.board = board;
        this.calledNumbers = calledNumbers;
        this.b = new Board(board);
    }

    
    public void play() {
        int count = 0;
        b.markNumbers(this.calledNumbers);

        
        for (int i = 0; i < b.size; i++) {
            if (b.isRowComplete(i)) {
                strikeLetter();
                count++;
            }
            if (b.isColumnComplete(i)) {
                strikeLetter();
                count++;
            }
        }

     
        if (b.isMainDiagonalComplete()) {
            strikeLetter();
            count++;
        }
        if (b.isAntiDiagonalComplete()) {
            strikeLetter();
            count++;
        }

       
        if (count >= 5) {
            // printResult();
        }
    }

    
    public void strikeLetter() {
        for (int i = 0; i < LETTERS.length; i++) {
            if (LETTERS[i] != '-') { 
                bingoLetters += LETTERS[i] + " ";
                LETTERS[i] = '-';  
                return;
            }
        }
    }

    
    public void printResult() {
        // System.out.println();
        b.printBoard();
        String remainingLetters = "";
        for (char letter : LETTERS) {
            if (letter != '-') {
                remainingLetters += letter + " ";
            }
        }
        
        System.out.println();
        if (bingoLetters.replace(" ", "").length() == LETTERS.length) {
            System.out.println(bingoLetters.trim());
            System.out.println("Game Completed!");
        } else {
            System.out.println("Remaining Letters: " + remainingLetters.trim());
        }
    }
}
