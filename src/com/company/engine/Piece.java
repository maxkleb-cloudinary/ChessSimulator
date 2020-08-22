package com.company.engine;

abstract class Piece {

    private boolean killed = false;
    private boolean white = false;

    Piece(boolean white) {
        this.setWhite(white);
    }

    boolean isWhite() {
        return this.white == true;
    }

    void setWhite(boolean white) {
        this.white = white;
    }

    boolean isKilled() {
        return this.killed == true;
    }

    void setKilled(boolean killed) {
        this.killed = killed;
    }

    abstract boolean canMove(Board board,
                             Spot start, Spot end);
}