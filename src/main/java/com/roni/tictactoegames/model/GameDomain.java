package com.roni.tictactoegames.model;

public class GameDomain {
    private int boardDimension;
    private BoardDomain board;

    private String activePlayer;
    private boolean end = false;
    private String winner;

    public GameDomain(int boardDimension) {
        this.boardDimension = boardDimension;
        this.startGame();
    }

    public int getBoardDimension() {
        return boardDimension;
    }

    public BoardDomain getBoard() {
        return board;
    }


    public String getActivePlayer() {
        return activePlayer;
    }

    public boolean isEnd() {
        return this.end;
    }

    public String getWinner() {
        return this.winner;
    }

    private void changePlayer() {
        if (this.activePlayer =="O")
            this.activePlayer = "X";
        else
            this.activePlayer = "O";

    }

    private void checkWinner() {
        String winnerExist = this.board.checkTheWinner();
        if (winnerExist != null) {
            this.end = true;

            if ( winnerExist != "draw")
                this.winner = winnerExist;
        }
    }


    private void startGame() {
        this.activePlayer = "O";
        this.board = new BoardDomain(this.boardDimension);
    }

    public void doMove(int x, int y) {
        if (!this.end) {
            boolean isValid = this.board.doMove(x, y, this.activePlayer);

            if (isValid) {
                this.changePlayer();
                this.checkWinner();
            }
        }
    }
}
