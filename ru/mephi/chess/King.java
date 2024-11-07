package ru.mephi.chess;

public class King extends ChessPiece{
    public King(String color) {
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
        else if ((line - toLine <= 1 && toLine - line <= 1)
                && (column - toColumn <= 1 && toColumn - column <= 1)
                && chessBoard.isPathClear(line, column, toLine, toColumn) ) {
            return true;
        }
        else return false;
    }

    @Override
    String getSymbol(){
        return "K";
    }
    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {

        if (line < 0 || line > 7 || column < 0 || column > 7) return false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                ChessPiece chessField = chessBoard.board[i][j];
                if (chessField != null && !chessField.getColor().equals(this.color)) {
                    if (chessField.canMoveToPosition(chessBoard, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
