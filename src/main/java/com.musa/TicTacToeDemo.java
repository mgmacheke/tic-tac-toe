package com.musa;

import java.util.Scanner;

public class TicTacToeDemo {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        playGame();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] +" | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void playGame(){
        boolean gameRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (gameRunning) {
            displayBoard();
            System.out.println("Player " + currentPlayer + " enter row from (0 - 2) and column from (0 - 2)");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                if(isWinner()){
                    displayBoard();
                    System.out.println("Winner is " + currentPlayer);
                    gameRunning = false;
                }else if (isBoardFull()){
                    displayBoard();
                    System.out.println("It's a tie!");
                    gameRunning = false;
                }else
                    switchPlayer();

            } else {
                System.out.println("invalid move");
            }
        }
        System.out.println();
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X')? 'O' : 'X';
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j] == ' ')
                    return false;
            }
        }
        return  true;
    }

    private static boolean isWinner() {
        for (int i = 0; i < 3; i++) {
            if(board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer ||
            board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                return true;
        }
        return board[0][0] == board[1][1] && board[1][2] == board[2][2] ||
            board[0][2] == board[1][1] && board[0][0] == board[2][0];
    }

}
