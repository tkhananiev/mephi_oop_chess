package ru.mephi.chess;

public class Horse extends ChessPiece{
    public Horse(String color) {
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
//        else if (isPathClear(chessBoard, line, column, toLine, toColumn)){
//            return true;
//        }
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
    private boolean isPathClear(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int rowDirection = Integer.signum(toLine - line);
        int colDirection = Integer.signum(toColumn - column);

        int currentRow = line + rowDirection;
        int currentCol = column + colDirection;

        while (currentRow != toLine || currentCol != toColumn) {
            if (chessBoard.board[currentRow][currentCol] != null) {
                return false; // Путь не свободен
            }
            currentRow += rowDirection;
            currentCol += colDirection;
        }
        return true; // Путь свободен
    }

}
