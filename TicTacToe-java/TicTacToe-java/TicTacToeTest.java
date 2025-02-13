import java.util.Scanner;

public class TicTacToeTest {
    public static void runTests() {
        System.out.println("\n----- Running Tests -----\n");

        // Test 1: Board Initialization (3x3)
        Board board3 = new Board(3);
        boolean allEmpty = true;
        for (int i = 0; i < board3.grid.length; i++) {
            for (int j = 0; j < board3.grid[i].length; j++) {
                if (board3.grid[i][j] != ' ') {
                    allEmpty = false;
                }
            }
        }
        if (allEmpty) {
            System.out.println("Test 1 Passed: 3x3 board initialized with all cells empty.");
        } else {
            System.out.println("Test 1 Failed: 3x3 board initialization error.");
        }

        // Test 2: isValidMove Method (3x3)
        if (board3.isValidMove(1, 1)) {
            System.out.println("Test 2.1 Passed: (1,1) is a valid move on 3x3 board.");
        } else {
            System.out.println("Test 2.1 Failed: (1,1) should be valid.");
        }
        if (!board3.isValidMove(-1, 0)) {
            System.out.println("Test 2.2 Passed: (-1,0) correctly identified as invalid.");
        } else {
            System.out.println("Test 2.2 Failed: (-1,0) should be invalid.");
        }
        if (!board3.isValidMove(3, 0)) {
            System.out.println("Test 2.3 Passed: (3,0) correctly identified as invalid.");
        } else {
            System.out.println("Test 2.3 Failed: (3,0) should be invalid.");
        }

        // Test 3: placeMove Method (3x3)
        boolean result = board3.placeMove(0, 0, 'X');
        if (result && board3.grid[0][0] == 'X') {
            System.out.println("Test 3.1 Passed: Successfully placed 'X' at (0,0).");
        } else {
            System.out.println("Test 3.1 Failed: Could not place 'X' at (0,0).");
        }
        // Attempt to place a move in a non-empty cell.
        result = board3.placeMove(0, 0, 'O');
        if (!result && board3.grid[0][0] == 'X') {
            System.out.println("Test 3.2 Passed: Cannot override cell (0,0) which is already occupied.");
        } else {
            System.out.println("Test 3.2 Failed: Overriding cell (0,0) should not be allowed.");
        }
        // Attempt an out-of-bound move.
        result = board3.placeMove(3, 3, 'X');
        if (!result) {
            System.out.println("Test 3.3 Passed: Move at (3,3) correctly identified as out-of-bound.");
        } else {
            System.out.println("Test 3.3 Failed: (3,3) is out-of-bound and move should not be allowed.");
        }

        // Test 4: checkWin Method
        // 4.1 Row win test.
        Board boardWin = new Board(3);
        boardWin.placeMove(0, 0, 'O');
        boardWin.placeMove(0, 1, 'O');
        boardWin.placeMove(0, 2, 'O');
        if (boardWin.checkWin('O')) {
            System.out.println("Test 4.1 Passed: Row win detected for 'O' in first row.");
        } else {
            System.out.println("Test 4.1 Failed: Row win was not detected.");
        }
        // 4.2 Column win test.
        boardWin = new Board(3);
        boardWin.placeMove(0, 0, 'X');
        boardWin.placeMove(1, 0, 'X');
        boardWin.placeMove(2, 0, 'X');
        if (boardWin.checkWin('X')) {
            System.out.println("Test 4.2 Passed: Column win detected for 'X' in first column.");
        } else {
            System.out.println("Test 4.2 Failed: Column win was not detected.");
        }
        // 4.3 Main diagonal win test.
        boardWin = new Board(3);
        boardWin.placeMove(0, 0, 'X');
        boardWin.placeMove(1, 1, 'X');
        boardWin.placeMove(2, 2, 'X');
        if (boardWin.checkWin('X')) {
            System.out.println("Test 4.3 Passed: Main diagonal win detected for 'X'.");
        } else {
            System.out.println("Test 4.3 Failed: Main diagonal win was not detected.");
        }
        // 4.4 Anti-diagonal win test.
        boardWin = new Board(3);
        boardWin.placeMove(0, 2, 'O');
        boardWin.placeMove(1, 1, 'O');
        boardWin.placeMove(2, 0, 'O');
        if (boardWin.checkWin('O')) {
            System.out.println("Test 4.4 Passed: Anti-diagonal win detected for 'O'.");
        } else {
            System.out.println("Test 4.4 Failed: Anti-diagonal win was not detected.");
        }
        // 4.5 No win condition test.
        boardWin = new Board(3);
        boardWin.placeMove(0, 0, 'X');
        boardWin.placeMove(0, 1, 'O');
        boardWin.placeMove(0, 2, 'X');
        if (!boardWin.checkWin('X') && !boardWin.checkWin('O')) {
            System.out.println("Test 4.5 Passed: No win detected as expected on mixed moves.");
        } else {
            System.out.println("Test 4.5 Failed: Incorrect win detection on mixed moves.");
        }

        // Test 5: checkDraw Method
        // 5.1: Not full board should not be a draw.
        Board boardDraw = new Board(3);
        boardDraw.placeMove(0, 0, 'X');
        boardDraw.placeMove(0, 1, 'O');
        if (!boardDraw.checkDraw()) {
            System.out.println("Test 5.1 Passed: Board not full correctly returns no draw.");
        } else {
            System.out.println("Test 5.1 Failed: Board not full incorrectly reported as draw.");
        }
        // 5.2: Full board with no win should return a draw.
        boardDraw = new Board(3);
        boardDraw.placeMove(0, 0, 'X');
        boardDraw.placeMove(0, 1, 'O');
        boardDraw.placeMove(0, 2, 'X');
        boardDraw.placeMove(1, 0, 'X');
        boardDraw.placeMove(1, 1, 'X');
        boardDraw.placeMove(1, 2, 'O');
        boardDraw.placeMove(2, 0, 'O');
        boardDraw.placeMove(2, 1, 'X');
        boardDraw.placeMove(2, 2, 'O');
        if (boardDraw.checkDraw()) {
            System.out.println("Test 5.2 Passed: Full board with no win correctly detected as draw.");
        } else {
            System.out.println("Test 5.2 Failed: Full board with no win not detected as draw.");
        }

        // Test 6: Testing on a Different Board Size (4x4)
        Board board4 = new Board(4);
        allEmpty = true;
        for (int i = 0; i < board4.grid.length; i++) {
            for (int j = 0; j < board4.grid[i].length; j++) {
                if (board4.grid[i][j] != ' ') {
                    allEmpty = false;
                }
            }
        }
        if (allEmpty) {
            System.out.println("Test 6.1 Passed: 4x4 board initialized with all cells empty.");
        } else {
            System.out.println("Test 6.1 Failed: 4x4 board initialization error.");
        }
        result = board4.placeMove(2, 3, 'Z');
        if (result && board4.grid[2][3] == 'Z') {
            System.out.println("Test 6.2 Passed: Successfully placed 'Z' at (2,3) on 4x4 board.");
        } else {
            System.out.println("Test 6.2 Failed: Move at (2,3) on 4x4 board failed.");
        }
        if (!board4.isValidMove(4, 0)) {
            System.out.println("Test 6.3 Passed: (4,0) correctly detected as out-of-bound on 4x4 board.");
        } else {
            System.out.println("Test 6.3 Failed: (4,0) should be out-of-bound for 4x4 board.");
        }

        System.out.println("\n----- Tests Completed -----\n");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Uncomment the following line to run tests.
        runTests();

        // Uncomment the following block to play the game interactively.
        
        // System.out.print("Enter board size (n for an n x n board): ");
        // int boardSize = scanner.nextInt();
        // scanner.nextLine(); // Consume the newline character

        // Player player1 = new Player('X', "Player 1", scanner);
        // Player player2 = new Player('O', "Player 2", scanner);
        // Player[] players = { player1, player2 };

        // Game game = new Game(boardSize, players, scanner);
        // game.start();
        
        scanner.close();
    }
}
