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
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7){
            return false;
        } else if ((line == toLine) && (column == toColumn)) {
            return false;
        }
        else if (color.equals("White") && line == 1 && column > 0 && column <= 7 && toLine == line + 2){
            return true;
        }
        else if (color.equals("Black") && line == 6 && column > 0 && column <= 7 && toLine == line - 2){
            return true;
        }
        else if (toLine == line + 1){
            return true;
        }
        else return false;
    }
    @Override
    String getSymbol(){
        return "P";
    }
}
