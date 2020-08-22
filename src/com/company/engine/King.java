package com.company.engine;

class King extends Piece {
    private boolean castlingDone = false;

    King(boolean white) {
        super(white);
    }

    boolean isCastlingDone() {
        return castlingDone == true;
    }

    void setCastlingDone(boolean castlingDone) {
        this.castlingDone = castlingDone;
    }

    boolean isCastling(Spot start, Spot end) {
        // TODO: check castling validity
        return true;
    }

    @Override
    boolean canMove(Board board, Spot start, Spot end) {
        // TODO: implement the logic that validates King's moves:
        //  it can't move to the spot that has
        //  a piece of the same color
        //  check if the move will not cause the king
        //  being under attack
        //  Also validate a castling
        return true;
    }
}