package com.company.engine;

class Rook extends Piece {
    Rook(boolean white) {
        super(white);
    }

    @Override
    boolean canMove(Board board, Spot start, Spot end) {
        // TODO: validate Rook's moves
        return false;
    }
}
