package org.example;

import java.util.Scanner;

public class Game {
    private final Board board = new Board();
    private char currentPlayer = 'X';

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tic Tac Toe gestartet!");
        while (true) {
            board.print();
            System.out.println("Spieler " + currentPlayer + " ist am Zug.");

            int row, col;
            System.out.print("Zeile (0-2): ");
            row = scanner.nextInt();
            System.out.print("Spalte (0-2): ");
            col = scanner.nextInt();

            if (board.placeSymbol(row, col, currentPlayer)) {
                if (board.hasWon(currentPlayer)) {
                    board.print();
                    System.out.println("Spieler " + currentPlayer + " hat gewonnen!");
                    break;
                }
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Ungültiger Zug. Versuche es erneut.");
            }
        }
    }
}
