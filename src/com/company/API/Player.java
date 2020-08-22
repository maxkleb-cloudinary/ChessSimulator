package com.company.API;


import com.sun.tools.javac.util.Pair;

public interface Player {
    void initialize(boolean isWhite);

    /**
     * The method will only gets opponent's last legal move and should provide
     * the next legal move. If the move is not legal, the engine
     * will give the Player up to 3 retries to provide a valid move.
     * Otherwise the Player will be defeated.
     *
     * This interface supposed to support both human and machine player's implementation.
     *
     * @param prevMove - last legal move
     * @return current legal move
     */
    Pair<Spottible, Spottible> nextMove(Pair<Spottible, Spottible> prevMove);
    boolean isWhiteSide();
}
