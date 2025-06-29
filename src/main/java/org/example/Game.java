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
                // nur für US-001 – noch keine Gewinnlogik
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Ungültiger Zug. Versuche es erneut.");
            }
        }
    }
}
