package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BoardTest {
    @Test
    void testPlaceSymbolValid() {
        Board board = new Board();
        assertTrue(board.placeSymbol(1, 1, 'X'));
    }

    @Test
    void testPlaceSymbolInvalidOccupied() {
        Board board = new Board();
        board.placeSymbol(0, 0, 'X');
        assertFalse(board.placeSymbol(0, 0, 'O'));
    }

    @Test
    void testPlaceSymbolInvalidOutOfBounds() {
        Board board = new Board();
        assertFalse(board.placeSymbol(-1, 0, 'X'));
        assertFalse(board.placeSymbol(0, 3, 'O'));
    }
  
}