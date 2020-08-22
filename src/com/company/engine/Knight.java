package com.company.engine;

class Knight extends Piece {
    public Knight(boolean white) {
        super(white);
    }

    @Override
    boolean canMove(Board board, Spot start, Spot end) {
        //TODO: validate Knight's move
        return false;
    }
}
