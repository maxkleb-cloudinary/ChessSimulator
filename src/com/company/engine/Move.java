package com.company.engine;

class Move {
    private Spot start;
    private Spot end;
    private Piece piece;
    private boolean castlingMove = false;

    Move(Spot start, Spot end) {
        this.start = start;
        this.end = end;
        this.piece = start.getPiece();
    }

    boolean isCastlingMove() {
        return castlingMove == true;
    }

    void setCastlingMove(boolean castlingMove) {
        this.castlingMove = castlingMove;
    }

    Spot getStart() {
        return start;
    }

    Spot getEnd() {
        return end;
    }
}