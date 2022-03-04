package com.roni.tictactoegames.model;

import java.util.ArrayList;
import java.util.List;

public class BoardDomain {
    private List<List<String>> cells;

    public List<List<String>> getCells() {
        return this.cells;
    }

    public BoardDomain(int boardDimension) {
        this.cells = new ArrayList<>();

        int i = 0;
        while (i < boardDimension) {
            List<String> rows = new ArrayList<>();
            this.cells.add(rows);

            int j = 0;
            while (j < boardDimension) {
                rows.add("");
                j++;
            }

            i++;
        }
    }

    public boolean doMove(int x, int y, String player) {
        if ((x < this.cells.size()) && (y < this.cells.size())) {
            List<String> rows = this.cells.get(x);
            String value = rows.get(y);

            if (value == "") {
                rows.set(y, player);
                return true;
            }
        }
        return false;
    }

    public String checkTheWinner() {
        int boardDimension = this.cells.size();
        int[] verticalPoints = new int[boardDimension];
        int diagonalPointA = 0, diagonalPointB = 0;
        int total = 0, point = 0;

        for (int m = 0; m < boardDimension; m++) {
            List<String> rows = this.cells.get(m);
            point = 0;
            for (int n = 0; n < boardDimension; n++) {
                String value = rows.get(n);
                if (value == "O") {
                    total++;
                    point++;
                    verticalPoints[n]++;

                    if (m == n)
                        diagonalPointA++;

                    if (m + n == boardDimension - 1)
                        diagonalPointB++;

                } else if (value == "X") {
                    total++;
                    point--;
                    verticalPoints[n]--;

                    if (m == n)
                        diagonalPointA--;

                    if (m + n == boardDimension - 1)
                        diagonalPointB--;
                }

                if ((total == boardDimension * boardDimension) || (Math.abs(point) == boardDimension)
                        || (Math.abs(verticalPoints[n]) == boardDimension) || (Math.abs(diagonalPointA) == boardDimension)
                        || (Math.abs(diagonalPointB) == boardDimension)) {
                    if (point == boardDimension || verticalPoints[n] == boardDimension || diagonalPointA == boardDimension
                            || diagonalPointB == boardDimension) {
                        return "O";
                    } else if (point * -1 == boardDimension || verticalPoints[n] * -1 == boardDimension
                            || diagonalPointA * -1 == boardDimension || diagonalPointB * -1 == boardDimension) {
                        return "X";
                    } else {
                        return "draw";
                    }
                }
            }
        }

        return null;
    }
}
