package semester2.homework.hw04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Connect4Grid2DArray implements Connect4Grid {

    final int MAXIMUM_ROW = 6;
    final int MAXIMUM_COLUMN = 7;
    final int HUMAN_PLAYER;
    final int COMPUTER_PLAYER;
    int[][] playBoard;
    int lastestColumn;
    int currentPlayer;




    Connect4Grid2DArray(ConnectPlayer humanPlayer, ConnectPlayer computerPlayer) {
        this.playBoard = new int[MAXIMUM_ROW][MAXIMUM_COLUMN];
        this.emptyGrid();
        this.HUMAN_PLAYER = humanPlayer.getID();
        this.COMPUTER_PLAYER = computerPlayer.getID();
        this.lastestColumn = -1;

    }

    @Override
    public void emptyGrid() {
        for (int i = 0; i < MAXIMUM_ROW; i++) {
            for (int j = 0; j < MAXIMUM_COLUMN; j++) {
                this.playBoard[i][j] = 0;
            }
        }
    }

    @Override
    public boolean isValidColumn(int column) {
        if (column >= 0 && column <= MAXIMUM_COLUMN - 1) return true;
        return false;
    }

    @Override
    public boolean isColumnFull(int column) {
        if (this.playBoard[MAXIMUM_ROW - 1][column] != 0) return true;
        return false;
    }

    @Override
    public void dropPiece(ConnectPlayer player, int column) {
        for (int i = 0; i < MAXIMUM_ROW; i++) {
            if (this.playBoard[i][column] == 0) {
                if (player.getID() == HUMAN_PLAYER) {
                    currentPlayer = HUMAN_PLAYER;
                    this.playBoard[i][column] = HUMAN_PLAYER;
                    this.lastestColumn = column;
                    break;
                } else if (player.getID() == COMPUTER_PLAYER) {
                    currentPlayer = COMPUTER_PLAYER;
                    this.playBoard[i][column] = COMPUTER_PLAYER;
                    this.lastestColumn = column;
                    break;
                }
            }
        }
    }

    @Override
    public boolean didLastPieceConnect4() {
        for (int row = MAXIMUM_ROW - 1; row >= 0; row--){
            if (row >= 3){
                // dl -> ur
                for (int col = 0; col <=3; col++){
                    if (       this.playBoard[row][col] == this.currentPlayer
                            && this.playBoard[row-1][col+1] == this.currentPlayer
                            && this.playBoard[row-2][col+2] == this.currentPlayer
                            && this.playBoard[row-3][col+3] == this.currentPlayer){
                        return true;
                    }
                }
                // dr -> ul
                for (int col = 3; col <= MAXIMUM_COLUMN-1; col++){
                    if (       this.playBoard[row][col] == this.currentPlayer
                            && this.playBoard[row-1][col-1] == this.currentPlayer
                            && this.playBoard[row-2][col-2] == this.currentPlayer
                            && this.playBoard[row-3][col-3] == this.currentPlayer){
                        return true;
                    }
                }
                // same col
                for (int col = 0; col <= MAXIMUM_COLUMN-1; col++){
                    if (       this.playBoard[row][col] == this.currentPlayer
                            && this.playBoard[row-1][col] == this.currentPlayer
                            && this.playBoard[row-2][col] == this.currentPlayer
                            && this.playBoard[row-3][col] == this.currentPlayer){
                        return true;
                    }
                }
            }
            for (int col = 0; col <= 3; col++){
                if (       this.playBoard[row][col] == this.currentPlayer
                        && this.playBoard[row][col+1] == this.currentPlayer
                        && this.playBoard[row][col+2] == this.currentPlayer
                        && this.playBoard[row][col+3] == this.currentPlayer){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isGridFull() {
        for (int i = 0; i < MAXIMUM_ROW; i++) {
            for (int j = 0; j < MAXIMUM_COLUMN; j++) {
                if (this.playBoard[i][j] == 0) return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        List rows = new ArrayList<String>();

        for (int i = MAXIMUM_ROW - 1; i >= 0; i--) {
            String row = "I";
            for (int j = 0; j < MAXIMUM_COLUMN; j++) {
                int temp = this.playBoard[i][j];
                if (temp == HUMAN_PLAYER) {
                    row = row + " h I";
                } else if (temp == COMPUTER_PLAYER) {
                    row = row + " c I";
                } else {
                    row = row + "   I";
                }
            }
            rows.add(row);
        }
        return String.join("\n", rows);
    }
}
