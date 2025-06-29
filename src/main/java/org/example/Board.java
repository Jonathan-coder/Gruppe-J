package org.example;

public class Board {
    private final char[][] grid = new char[3][3];

    public Board() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                grid[i][j] = ' ';
    }

    public void print() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public boolean placeSymbol(int row, int col, char symbol) {
        if (row < 0 || row > 2 || col < 0 || col > 2) return false;
        if (grid[row][col] != ' ') return false;

        grid[row][col] = symbol;
        return true;
    }
    public char[][] getGrid() {
        return grid;
    }
    public boolean hasWon(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (grid[0][j] == symbol && grid[1][j] == symbol && grid[2][j] == symbol) {
                return true;
            }
        }

        if (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) {
            return true;
        }

        if (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol) {
            return true;
        }

        return false;
    }
}
