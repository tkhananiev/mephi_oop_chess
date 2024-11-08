package ru.mephi.chess;

public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }
    public String getColor() {
        return this.color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!ChessBoard.isPositionOnBoard(line, column) || !ChessBoard.isPositionOnBoard(toLine, toColumn)) {
            return false;
        }
        else if (line == toLine && column == toColumn) {
            return false;
        }
        else if ((Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 2)
                || (Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1)){
            return true;
        }
        else return false;
    }

    @Override
    String getSymbol(){
        return "H";
    }
}
