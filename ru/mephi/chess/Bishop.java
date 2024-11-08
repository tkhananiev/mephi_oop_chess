package ru.mephi.chess;

public class Bishop extends ChessPiece{
    public Bishop(String color) {
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
        if (line == toLine && column == toColumn) {
            return false;
        }
        if ((line + toColumn == column + toLine) || (line + column == toLine + toColumn)
                && chessBoard.isPathClear(line, column, toLine, toColumn)
                && chessBoard.isPathClear(line, column, toLine, toColumn)){
            return true;
        }
        else return false;
    }
    @Override
    String getSymbol(){
        return "B";
    }
}
