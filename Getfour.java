package getfour;

import java.io.*;
import java.util.Scanner;

public class Getfour {

    public static void displayBoard(int board[][]) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int verticalWinner(int board[][]) {
        int count1, count2, winner = 0;
        int previous;
        for (int i = 0; i < 7; i++) {
            count1 = 0;
            count2 = 0;
            previous = board[5][i];
            for (int j = 5; j >= 0; j--) {
                // player 1 and player 2
                if (board[j][i] == 1) {
                    if (previous == 1) {
                        count1++;
                        count2 = 0;
                    }
                } else if (board[j][i] == 2) {
                    if (previous == 2) {
                        count2++;
                        count1 = 0;
                    }
                }
                previous = board[j][i];
                if (count1 >= 4) {
                    winner = 1;
                }
                if (count2 >= 4) {
                    winner = 2;
                }
            }
        }
        return winner;
    }

    public static int horizontalWinner(int board[][]) {
        int count1, count2, winner = 0;
        int previous;

        for (int i = 5; i >= 0; i--) {
            count1 = 0;
            count2 = 0;
            previous = board[i][0];
            for (int j = 0; j < 7; j++) {
                if (board[i][j] == 1) {
                    if (previous == 1) {
                        count1++;
                        count2 = 0;
                    }
                } else if (board[i][j] == 2) {
                    if (previous == 2) {
                        count2++;
                        count1 = 0;
                    }
                }
                previous = board[i][j];
                if (count1 >= 4) {
                    winner = 1;
                }
                if (count2 >= 4) {
                    winner = 2;
                }
            }
        }
        return winner;
    }

    public static int diagonalWinner1(int board[][]) {
        // two separate bodies for checking diagonals
        // first diagonal check
        int count1, count2, winner = 0, previous;
        // first half of the board 
        for (int i = 0; i < 6; i++) {
            count1 = 0;
            count2 = 0;
            int j = i, k = 0;
            previous = board[i][0];
            while (j >= 0) {
                if (board[j][k] == 1) {
                    if (previous == 1) {
                        count1++;
                        count2 = 0;
                    }
                }

                if (board[j][k] == 2) {
                    if (previous == 2) {
                        count2++;
                        count1 = 0;
                    }
                }
                previous = board[j][k];
                j--;
                k++;
                if (count1 >= 4) {
                    winner = 1;
                }
                if (count2 >= 4) {
                    winner = 2;
                }
            }
        }

        // second half of the board
        if (winner == 0) {
            for (int i = 1; i < 7; i++) {
                count1 = 0;
                count2 = 0;
                previous = board[5][i];
                int j = 5, k = i;
                while (k < 7) {
                    if (board[j][k] == 1) {
                        if (previous == 1) {
                            count1++;
                            count2 = 0;
                        }
                    }

                    if (board[j][k] == 2) {
                        if (previous == 2) {
                            count2++;
                            count1 = 0;
                        }
                    }
                    previous = board[j][k];
                    j--;
                    k++;
                    if (count1 >= 4) {
                        winner = 1;
                    }
                    if (count2 >= 4) {
                        winner = 2;
                    }
                }
            }
        }

        return winner;
    }

    public static int diagonalWinner2(int board[][]) {
        int count1, count2, winner = 0, previous;

        for (int i = 0; i < 6; i++) {
            count1 = 0;
            count2 = 0;
            previous = board[i][6];
            int j = i, k = 6;
            while (j >= 0) {
                if (board[j][k] == 1) {
                    if (previous == 1) {
                        count1++;
                        count2 = 0;
                    }
                }

                if (board[j][k] == 2) {
                    if (previous == 2) {
                        count2++;
                        count1 = 0;
                    }
                }
                previous = board[j][k];
                j--;
                k--;
                if (count1 >= 4) {
                    winner = 1;
                }
                if (count2 >= 4) {
                    winner = 2;
                }
            }
        }

        /*// second half of board
        if (winner == 0) {
            count1 = 0;
            count2 = 0;
            for (int i = 4; i >= 0; i--) {
                previous = board[i][6];
                int j = i, k = 6;
                while (j >= 0) {
                    if (board[j][k] == 1) {
                        if (previous == 1) {
                            count1++;
                            count2 = 0;
                        }
                    }

                    if (board[j][k] == 2) {
                        if (previous == 2) {
                            count2++;
                            count1 = 0;
                        }
                    }
                    previous = board[j][k];
                    j--;
                    k--;
                    if (count1 >= 4) {
                        winner = 1;
                    }
                    if (count2 >= 4) {
                        winner = 2;
                    }
                }
            }
        }*/

        return winner;
    }

    public static int checkBoardStatus(int board[][]) {
        int vert = verticalWinner(board);
        int horiz = horizontalWinner(board);
        int diag1 = diagonalWinner1(board);
        int diag2 = diagonalWinner2(board);

        if (vert > 0) {
            return vert;
        }
        if (horiz > 0) {
            return horiz;
        }
        if (diag1 > 0) {
            return diag1;
        }
        if (diag2 > 0) {
            return diag2;
        }

        return 0;
    }

    public static void changeBoard(int column, int player, int board[][]) {
        for (int i = 5; i >= 0; i--) {
            if (board[i][column] == 0) {
                board[i][column] = player;
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner read = new Scanner(System.in);
        int connect4Board[][] = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}};

        int player = 2;
        int column;
        int status = 0;
        while (status == 0) {
            if (player == 2) {
                player = 1;
            } else {
                player = 2;
            }

            System.out.println("Pick a column: ");
            System.out.println("1 2 3 4 5 6 7");
            System.out.println();
            displayBoard(connect4Board);

            column = read.nextInt();
            changeBoard(column - 1, player, connect4Board);
            status = checkBoardStatus(connect4Board);
        }
        if (status == 1) {
            System.out.println("Player 1 Wins!");
        }
        if (status == 2) {
            System.out.println("Player 2 Wins!");
        }
        displayBoard(connect4Board);

    }

}
