package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest extends Object {

    @Test
    void validRow() {
        Solver s = new Solver();
        Board b = new Board();
        b.set(0, 0, 9);
        assertTrue(s.validRow(b, 0));

        b.set(0, 1, 9);
        b.set(1, 1, 9);
        assertTrue(!s.validRow(b, 1));
    }

    @Test
    void validAllRows() {
        Solver s = new Solver();
        Board b = new Board();
        b.set(0, 0, 9);
        b.set(1, 1, 9);
        b.set(2, 2, 9);
        b.set(3, 3, 9);
        b.set(4, 4, 9);
        b.set(5, 5, 9);
        b.set(6, 6, 9);
        b.set(7, 7, 9);
        b.set(8, 8, 9);
        assertTrue(s.validAllRows(b));

        b.set(7, 8, 9);
        assertTrue(!s.validAllRows(b));
    }

    @Test
    void validColumn() {
        Solver s = new Solver();
        Board b = new Board();
        b.set(0, 0, 9);
        assertTrue(s.validColumn(b, 0));

        b.set(0, 1, 9);
        b.set(1, 1, 9);
        assertTrue(!s.validColumn(b, 1));
    }

    @Test
    void validAllColumns() {
        Solver s = new Solver();
        Board b = new Board();
        b.set(0, 0, 9);
        b.set(1, 1, 9);
        b.set(2, 2, 9);
        b.set(3, 3, 9);
        b.set(4, 4, 9);
        b.set(5, 5, 9);
        b.set(6, 6, 9);
        b.set(7, 7, 9);
        b.set(8, 8, 9);
        assertTrue(s.validAllColumns(b));

        b.set(8, 7, 9);
        assertTrue(!s.validAllColumns(b));
    }

    @Test
    void validSquare() {
        Solver s = new Solver();
        Board b = new Board();
        b.set(0, 0, 9);
        assertTrue(s.validSquare(b, 0, 0));

        b.set(1, 1, 9);
        assertTrue(!s.validSquare(b, 0, 0));
    }

    @Test
    void validAllSquares() {
        Solver s = new Solver();
        Board b = new Board();
        b.set(0, 0, 9);
        b.set(3, 0, 9);
        b.set(6, 0, 9);

        b.set(0, 3, 9);
        b.set(3, 3, 9);
        b.set(6, 3, 9);

        b.set(0, 6, 9);
        b.set(3, 6, 9);
        b.set(6, 6, 9);
        assertTrue(s.validAllSquares(b));

        b.set(8, 8, 9);
        assertTrue(!s.validAllSquares(b));
    }

    @Test
    void valid() {
    }

    @Test
    void complete() {
    }

    @Test
    void completeAndValid() {
        /*
        Solver s = new Solver();
        Board b = new Board();
        b.set(0, 0, 5);
        b.set(1, 0, 3);
        b.set(2, 0, 4);
        b.set(3, 0, 6);
        b.set(4, 0, 7);
        b.set(5, 0, 8);
        b.set(6, 0, 9);
        b.set(7, 0, 1);
        b.set(8, 0, 2);
        assertTrue(s.valid(b));
        assertTrue(!s.completeAndValid(b));

        b.set(0, 1, 6);
        b.set(1, 1, 7);
        b.set(2, 1, 2);
        b.set(3, 1, 1);
        b.set(4, 1, 9);
        b.set(5, 1, 5);
        b.set(6, 1, 3);
        b.set(7, 1, 4);
        b.set(8, 1, 8);
        assertTrue(s.valid(b));
        assertTrue(!s.completeAndValid(b));

        b.set(0, 2, 1);
        b.set(1, 2, 9);
        b.set(2, 2, 8);
        b.set(3, 2, 3);
        b.set(4, 2, 4);
        b.set(5, 2, 2);
        b.set(6, 2, 5);
        b.set(7, 2, 6);
        b.set(8, 2, 7);
        assertTrue(s.valid(b));
        assertTrue(!s.completeAndValid(b));

        b.set(0, 3, 8);
        b.set(1, 3, 5);
        b.set(2, 3, 9);
        b.set(3, 3, 7);
        b.set(4, 3, 6);
        b.set(5, 3, 1);
        b.set(6, 3, 4);
        b.set(7, 3, 2);
        b.set(8, 3, 3);
        assertTrue(s.valid(b));
        assertTrue(!s.completeAndValid(b));

        b.set(0, 4, 4);
        b.set(1, 4, 2);
        b.set(2, 4, 6);
        b.set(3, 4, 8);
        b.set(4, 4, 5);
        b.set(5, 4, 3);
        b.set(6, 4, 7);
        b.set(7, 4, 9);
        b.set(8, 4, 1);
        assertTrue(s.valid(b));
        assertTrue(!s.completeAndValid(b));

        b.set(0, 5, 7);
        b.set(1, 5, 1);
        b.set(2, 5, 3);
        b.set(3, 5, 9);
        b.set(4, 5, 2);
        b.set(5, 5, 4);
        b.set(6, 5, 8);
        b.set(7, 5, 5);
        b.set(8, 5, 6);
        assertTrue(s.valid(b));
        assertTrue(!s.completeAndValid(b));

        b.set(0, 6, 9);
        b.set(1, 6, 6);
        b.set(2, 6, 1);
        b.set(3, 6, 5);
        b.set(4, 6, 3);
        b.set(5, 6, 7);
        b.set(6, 6, 2);
        b.set(7, 6, 8);
        b.set(8, 6, 4);
        assertTrue(s.valid(b));
        assertTrue(!s.completeAndValid(b));

        b.set(0, 7, 2);
        b.set(1, 7, 8);
        b.set(2, 7, 7);
        b.set(3, 7, 4);
        b.set(4, 7, 1);
        b.set(5, 7, 9);
        b.set(6, 7, 6);
        b.set(7, 7, 3);
        b.set(8, 7, 5);
        assertTrue(s.valid(b));
        assertTrue(!s.completeAndValid(b));

        b.set(0, 8, 3);
        b.set(1, 8, 4);
        b.set(2, 8, 5);
        b.set(3, 8, 2);
        b.set(4, 8, 8);
        b.set(5, 8, 6);
        b.set(6, 8, 1);
        b.set(7, 8, 7);
        b.set(8, 8, 9);
        assertTrue(s.valid(b));
        assertTrue(s.completeAndValid(b));
         */
    }

    @Test
    void solve() {
        /*
        Solver s = new Solver();
        Board b = new Board();
        b.set(0, 0, 5);
        b.set(1, 0, 3);
        b.set(2, 0, 4);
        b.set(3, 0, 6);
        b.set(4, 0, 7);
        b.set(5, 0, 8);
        b.set(6, 0, 9);
        b.set(7, 0, 1);
        b.set(8, 0, 2);
        assertTrue(s.valid(b));
        assertTrue(!s.completeAndValid(b));

        b.set(0, 1, 6);
        b.set(1, 1, 7);
        b.set(2, 1, 2);
        b.set(3, 1, 1);
        b.set(4, 1, 9);
        b.set(5, 1, 5);
        b.set(6, 1, 3);
        b.set(7, 1, 4);
        b.set(8, 1, 8);
        assertTrue(s.valid(b));
        assertTrue(!s.completeAndValid(b));

        b.set(0, 2, 1);
        b.set(1, 2, 9);
        b.set(2, 2, 8);
        b.set(3, 2, 3);
        b.set(4, 2, 4);
        b.set(5, 2, 2);
        b.set(6, 2, 5);
        b.set(7, 2, 6);
        b.set(8, 2, 7);
        assertTrue(s.valid(b));
        assertTrue(!s.completeAndValid(b));

        b.set(0, 3, 8);
        b.set(1, 3, 5);
        b.set(2, 3, 9);
        b.set(3, 3, 7);
        b.set(4, 3, 6);
        b.set(5, 3, 1);
        b.set(6, 3, 4);
        b.set(7, 3, 2);
        b.set(8, 3, 3);
        assertTrue(s.valid(b));
        assertTrue(!s.completeAndValid(b));

        b.set(0, 4, 4);
        b.set(1, 4, 2);
        b.set(2, 4, 6);
        b.set(3, 4, 8);
        b.set(4, 4, 5);
        b.set(5, 4, 3);
        b.set(6, 4, 7);
        b.set(7, 4, 9);
        b.set(8, 4, 1);
        assertTrue(s.valid(b));
        assertTrue(!s.completeAndValid(b));

        b.set(0, 5, 7);
        b.set(1, 5, 1);
        b.set(2, 5, 3);
        b.set(3, 5, 9);
        b.set(4, 5, 2);
        b.set(5, 5, 4);
        b.set(6, 5, 8);
        b.set(7, 5, 5);
        b.set(8, 5, 6);
        assertTrue(s.valid(b));
        assertTrue(!s.completeAndValid(b));

        b.set(0, 6, 9);
        b.set(1, 6, 6);
        b.set(2, 6, 1);
        b.set(3, 6, 5);
        b.set(4, 6, 3);
        b.set(5, 6, 7);
        b.set(6, 6, 2);
        b.set(7, 6, 8);
        b.set(8, 6, 4);
        assertTrue(s.valid(b));
        assertTrue(!s.completeAndValid(b));

        b.set(0, 7, 2);
        b.set(1, 7, 8);
        b.set(2, 7, 7);
        b.set(3, 7, 4);
        b.set(4, 7, 1);
        b.set(5, 7, 9);
        b.set(6, 7, 6);
        b.set(7, 7, 3);
        b.set(8, 7, 5);
        assertTrue(s.valid(b));
        assertTrue(!s.completeAndValid(b));

        b.set(0, 8, 3);
        b.set(1, 8, 4);
        b.set(2, 8, 5);
        b.set(3, 8, 2);
        b.set(4, 8, 8);
        b.set(5, 8, 6);
        b.set(6, 8, 1);
        b.set(7, 8, 7);
        assertTrue(s.valid(b));
        assertTrue(!s.completeAndValid(b));

        Board solution = s.solve(b);
        assertTrue(solution.get(8, 8) == null);
         */
    }
}