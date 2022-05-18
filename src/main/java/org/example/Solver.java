package org.example;

import java.util.HashSet;
import java.util.Set;

public class Solver {
    private Set<Integer> checker;

    public Solver() {
        checker = new HashSet<Integer>();
        checker.add(1);
        checker.add(2);
        checker.add(3);
        checker.add(4);
        checker.add(5);
        checker.add(6);
        checker.add(7);
        checker.add(8);
        checker.add(9);
    }

    public boolean validRow(Board b, int r) {
        Set<Integer> n = new HashSet<>(checker);
        for (int c = 0; c < 9; c++) {
            Integer i = b.get(c, r);
            if (i != null) {
                if (!n.contains(i)) {
                    return false;
                } else {
                    n.remove(i);
                }
            }
        }
        return true;
    }

    public boolean validAllRows(Board b) {
        for (int r = 0; r < 9; r++) {
            if (!validRow(b, r))
                return false;
        }
        return true;
    }

    public boolean validColumn(Board b, int c) {
        Set<Integer> n = new HashSet<>(checker);
        for (int r = 0; r < 9; r++) {
            Integer i = b.get(r, c);
            if (i != null) {
                if (!n.contains(i)) {
                    return false;
                } else {
                    n.remove(i);
                }
            }
        }
        return true;
    }

    public boolean validAllColumns(Board b) {
        for (int c = 0; c < 9; c++) {
            if (!validColumn(b, c))
                return false;
        }
        return true;
    }

    public boolean validSquare(Board b, int ac, int ar) {
        Set<Integer> n = new HashSet<>(checker);
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                Integer i = b.get(ac + c, ar + r);
                if (i != null) {
                    if (!n.contains(i)) {
                        return false;
                    } else {
                        n.remove(i);
                    }
                }
            }
        }
        return true;
    }

    public boolean validAllSquares(Board b) {
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                if (!validSquare(b, c, r))
                    return false;
            }
        }
        return true;
    }

    public boolean valid(Board b) {
        return validAllRows(b) && validAllColumns(b) && validAllSquares(b);
    }

    public boolean complete(Board b) {
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                if (b.get(c, r) == null)
                    return false;
            }
        }
        return true;
    }

    public boolean completeAndValid(Board b) {
        return valid(b) && complete(b);
    }

    /*Backtracking solution. If the board is partially fill Complete it.*/
    Board solve(Board partial) {
        if (!valid(partial)) {
            return null;
        }
        if (completeAndValid(partial)) {
            return partial;
        }

        Board b = new Board(partial);
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                Integer i = b.get(c, r);
                if (i == null) {
                    Set<Integer> tryUs = new HashSet<>(checker);
                    for (Integer number : tryUs) {
                        b.set(c, r, number);
                        Board solution = solve(b);
                        if (solution != null) {
                            return solution;
                        }
                    }
                    return null;
                }
            }
        }
        return null;
    }
}