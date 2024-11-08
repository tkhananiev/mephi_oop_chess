package ru.mephi.chess;
public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!ChessBoard.isPositionOnBoard(line, column) || !ChessBoard.isPositionOnBoard(toLine, toColumn)) {
            return false;
        }

        if (line == toLine && column == toColumn) {
            return false;
        }

        int columnDiff = Math.abs(column - toColumn);
        if (columnDiff > 1) {
            return false;
        }

        if (color.equals("White")) {
            if (toLine - line == 1 && columnDiff == 0 && chessBoard.board[toLine][toColumn] == null) {
                return true;
            }
            if (toLine - line == 2 && line == 1 && columnDiff == 0
                    && chessBoard.board[toLine][toColumn] == null
                    && chessBoard.board[line + 1][column] == null
                    && chessBoard.isPathClear(line, column, toLine, toColumn)) {
                return true;
            }
            if (toLine - line == 1 && columnDiff == 1
                    && chessBoard.board[toLine][toColumn] != null
                    && !chessBoard.board[toLine][toColumn].getColor().equals(color)) {
                return true;
            }
        } else if (color.equals("Black")) {
            if (line - toLine == 1 && columnDiff == 0 && chessBoard.board[toLine][toColumn] == null) {
                return true;
            }
            if (line - toLine == 2 && line == 6 && columnDiff == 0
                    && chessBoard.board[toLine][toColumn] == null
                    && chessBoard.board[line - 1][column] == null
                    && chessBoard.isPathClear(line, column, toLine, toColumn)) {
                return true;
            }
            if (line - toLine == 1 && columnDiff == 1 && chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}

