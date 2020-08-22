package com.company.engine;

 class Bishop extends Piece {
     Bishop(boolean white) {
        super(white);
    }

    @Override
     boolean canMove(Board board, Spot start, Spot end) {
        //TODO: validate Bishop's move
        return false;
    }
}
