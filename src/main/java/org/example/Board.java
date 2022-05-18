package org.example;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;

/*This class is just to represent the Board. So it doesn't have main() class*/
public class Board {
    /*"private" - because it will help in encapsulation.
    "Integer" is taken over "int", because its will help to check null, in JUnit testCases.
    */
    private Integer[][] board = new Integer[9][9];

    /*Keep track of the spaces in the board.*/
    public Board(){}
    public Board(Board copyMe){
        for (Integer c = 0; c < 9; c++) {
            for (Integer r = 0; r < 9; r++) {
                board[c][r] = copyMe.get(c, r);
            }
        }
    }

    public Integer get(Integer c, Integer r) {
        return board[c][r];
    }

    public void set(Integer c, Integer r, Integer x) {
        board[c][r] = x;
    }

    /*When ever we make class we make a "JUnit tests" in order to test it.*/
}
