package com.company.engine;

import com.company.API.Spottible;

class Spot extends Spottible {
    private Piece piece;

    Spot(int x, int y, Piece piece) {
        this.setPiece(piece);
        this.set(x, y);
    }

    Piece getPiece() {
        return this.piece;
    }

    void setPiece(Piece p) {
        this.piece = p;
    }
}