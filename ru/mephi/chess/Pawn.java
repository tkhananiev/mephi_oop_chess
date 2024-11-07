package ru.mephi.chess;

public class Pawn extends ChessPiece{
    public Pawn(String color) {
        super(color);
    }
    public String getColor(){
        return this.color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if ((toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7)
                || ((line == toLine) && (column == toColumn))) {
            return false;
        }
        else if (((color.equals("White") && toLine == line + 1)
                || (color.equals("White") && toLine == line + 2))
                && chessBoard.isPathClear(line, column, toLine, toColumn)){
            return true;
        }
        else if ((color.equals("Black") && toLine == line - 1)
                || (color.equals("Black") && toLine == line - 2)
                && chessBoard.isPathClear(line, column, toLine, toColumn)){
            return true;
        }
        else return false;
    }
    @Override
    String getSymbol(){
        return "P";
    }
}
