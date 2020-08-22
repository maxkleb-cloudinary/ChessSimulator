package com.company.engine;

import com.company.API.Player;
import com.company.API.Spottible;
import com.sun.tools.javac.util.Pair;

import java.util.List;

public class Simulator {
    private Player player1;
    private Player player2;
    private Board board;
    private GameStatus status;
    private Player currentTurn;
    // Optional
    private List<Move> gameLog;

    Simulator(Player p1, Player p2) {
        this.initialize(p1, p2);
    }

    private void initialize(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;

        board.resetBoard();
        gameLog.clear();
        status = GameStatus.PENDING;

        // White side starts the game
        if (p1.isWhiteSide()) {
            this.currentTurn = p1;
        } else {
            this.currentTurn = p2;
        }
    }

    public Player run() throws Exception {
        status = GameStatus.ACTIVE;
        int retry = 0;
        Pair<Spottible, Spottible> prevMove = null;
        while (status.equals(GameStatus.ACTIVE)) {
            Pair<Spottible, Spottible> nextMove = currentTurn.nextMove(prevMove);

            // Handle incorrect turn or move
            // Up to 3 retries
            // Otherwise the game will be stopped
            while (retry < 3 && !makePlayersMove(currentTurn,
                    nextMove.fst.x,
                    nextMove.fst.y,
                    nextMove.snd.x,
                    nextMove.snd.y)) {
                nextMove = currentTurn.nextMove(prevMove);
                retry++;
            }

            if (retry >= 3) {
                return (this.currentTurn == player1) ? player2 : player1;
            }
            // reset retries
            retry = 0;

            // next player turn
            this.currentTurn = (this.currentTurn == player1) ? player2 : player1;
        }

        if (status.equals(GameStatus.WHITE_WIN) && player1.isWhiteSide()) return player1;
        else return player2;
    }


    private boolean makePlayersMove(Player player, int startX, int startY, int endX, int endY) {
        Spot startSpot = board.getSpot(startX, startY);
        Spot endSpot = board.getSpot(endX, endY);
        if (startSpot == null || endSpot == null) {
            return false;
        }
        Move move = new Move(startSpot, endSpot);
        if (!isValidMove(player, move)) return false;
        makeMove(player, move);
        return true;
    }

    private boolean isValidMove(Player player, Move move) {
        Piece sourcePiece = move.getStart().getPiece();
        // Handle incorrect turn or move
        if (player != currentTurn
                || sourcePiece == null
                || sourcePiece.isWhite() != player.isWhiteSide()
                || !sourcePiece.canMove(board, move.getStart(), move.getEnd())) {
            return false;
        }

        return true;
    }

    private void makeMove(Player player, Move move) {
        Piece source = move.getStart().getPiece();
        Piece destination = move.getEnd().getPiece();


        // validate castling if done
        if (source != null && source instanceof King
                && ((King) source).isCastling(move.getStart(), move.getEnd())) {
            move.setCastlingMove(true);
        }

        // write to the game log
        gameLog.add(move);

        // do the actual move
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);

        // check if piece was killed
        if (destination != null) {
            // declare mate if valid
            // TODO: valid that the King is under attack
            //  and the opponent doesn't have a way to escape
            //  or protect the King
            if (destination instanceof King) {
                if (player.isWhiteSide()) {
                    status = GameStatus.WHITE_WIN;
                } else {
                    status = GameStatus.BLACK_WIN;
                }
            }
            destination.setKilled(true);
            // TODO: Handle all possible options of killing piece
            //  (e.g. passing a piece by Rook or Bishop)
        }
    }
}