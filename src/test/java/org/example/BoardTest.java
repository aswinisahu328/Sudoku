package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest extends Object {

    @Test
    void get() {
        Board b = new Board();
        for (int c = 0; c < 9; c++) {
            for (int r = 0; r < 9; r++) {
                assertTrue(b.get(c, r) == null);
            }
        }
    }

    @Test
    void set() {
        Board b = new Board();
        for (int c = 0; c < 9; c++) {
            for (int r = 0; r < 9; r++) {
                b.set(c, r, 1);
            }
        }
        for (int c = 0; c < 9; c++) {
            for (int r = 0; r < 9; r++) {
                assertTrue(b.get(c, r) == 1);
            }
        }
    }
}