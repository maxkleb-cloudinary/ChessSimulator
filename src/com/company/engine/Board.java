package com.company.engine;

class Board {
    Spot[][] spots;

    Board() {
        this.resetBoard();
    }

    Spot getSpot(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return null;
        }

        return spots[x][y];
    }

    void resetBoard() {
        // initialize white pieces
        spots[0][0] = new Spot(0, 0, new Rook(true));
        spots[0][1] = new Spot(0, 1, new Knight(true));
        spots[0][2] = new Spot(0, 2, new Bishop(true));

        spots[1][0] = new Spot(1, 0, new Pawn(true));
        spots[1][1] = new Spot(1, 1, new Pawn(true));
        spots[1][2] = new Spot(1, 2, new Pawn(true));
        // TODO: initialize the rest of white pieces

        // initialize black pieces
        spots[7][0] = new Spot(7, 0, new Rook(false));
        spots[7][1] = new Spot(7, 1, new Knight(false));
        spots[7][2] = new Spot(7, 2, new Bishop(false));

        spots[6][0] = new Spot(6, 0, new Pawn(false));
        spots[6][1] = new Spot(6, 1, new Pawn(false));
        spots[6][2] = new Spot(6, 2, new Pawn(false));
        // TODO: initialize the rest of black pieces


        // initialize remaining spots
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                spots[i][j] = new Spot(i, j, null);
            }
        }
    }
}