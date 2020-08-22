package com.company.client;

import com.company.API.Player;
import com.company.API.Spottible;
import com.sun.tools.javac.util.Pair;

public class MyPlayer implements Player {
    boolean isWhite;

    @Override
    public void initialize(boolean isWhite) {
        this.isWhite = isWhite;
    }

    @Override
    public Pair<Spottible, Spottible> nextMove(Pair<Spottible, Spottible> prevMove) {
        return null;
    }

    @Override
    public boolean isWhiteSide() {
        return isWhite;
    }
}
