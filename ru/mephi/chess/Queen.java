package ru.mephi.chess;

public class Queen extends ChessPiece{
    public Queen(String color) {
        super(color);
    }

    public String getColor(){
        return this.color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (!ChessBoard.isPositionOnBoard(line, column) || !ChessBoard.isPositionOnBoard(toLine, toColumn)) {
            return false;
        }
        else if (line == toLine && column == toColumn) {
            return false;
        }
        else if (Math.abs(line - toLine) == Math.abs(column - toColumn)
                || line == toLine || column == toColumn
                && chessBoard.isPathClear(line, column, toLine, toColumn)
                && chessBoard.isPathClear(line, column, toLine, toColumn)){
            return true;
        }
        else return false;
    }

    @Override
    String getSymbol(){
        return "Q";
    }

}
