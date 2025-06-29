package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BoardTest {
    private Board board;

    @BeforeEach
    public void setup() {
        board = new Board();
    }

    @Test
    public void testPlaceSymbol_ValidMove() {
        assertTrue(board.placeSymbol(0, 0, 'X'));
        assertEquals('X', board.getGrid()[0][0]);
    }

    @Test
    public void testPlaceSymbol_InvalidMove_OutOfBounds() {
        assertFalse(board.placeSymbol(-1, 0, 'X'));
        assertFalse(board.placeSymbol(0, 3, 'O'));
    }

    @Test
    public void testPlaceSymbol_InvalidMove_AlreadyOccupied() {
        board.placeSymbol(1, 1, 'X');
        assertFalse(board.placeSymbol(1, 1, 'O'));
    }

    @Test
    public void testHasWon_Row() {
        board.placeSymbol(0, 0, 'X');
        board.placeSymbol(0, 1, 'X');
        board.placeSymbol(0, 2, 'X');
        assertTrue(board.hasWon('X'));
    }

    @Test
    public void testHasWon_Column() {
        board.placeSymbol(0, 0, 'O');
        board.placeSymbol(1, 0, 'O');
        board.placeSymbol(2, 0, 'O');
        assertTrue(board.hasWon('O'));
    }

    @Test
    public void testHasWon_Diagonal() {
        board.placeSymbol(0, 0, 'X');
        board.placeSymbol(1, 1, 'X');
        board.placeSymbol(2, 2, 'X');
        assertTrue(board.hasWon('X'));
    }

    @Test
    public void testHasWon_NoWin() {
        board.placeSymbol(0, 0, 'X');
        board.placeSymbol(0, 1, 'O');
        board.placeSymbol(0, 2, 'X');
        assertFalse(board.hasWon('X'));
        assertFalse(board.hasWon('O'));
    }
  
}