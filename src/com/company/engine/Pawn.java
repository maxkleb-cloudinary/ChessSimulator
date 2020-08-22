package com.company.engine;

class Pawn extends Piece {
    public Pawn(boolean white) {
        super(white);
    }

    @Override
    boolean canMove(Board board, Spot start, Spot end) {
        //TODO: validate Pawn's move
        return false;
    }
}
