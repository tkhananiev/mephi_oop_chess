package ru.mephi.chess;

public class Rook extends ChessPiece{
    public Rook(String color) {
        super(color);
    }
    public String getColor(){
        return this.color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7){
            return false;
        } else if ((line == toLine) && (column == toColumn)) {
            return false;
        }
        else if ((line == toLine) || (column == toColumn)) {
            return true;
        }
        else return false;
    }

    @Override
    String getSymbol(){
        return "R";
    }
}
