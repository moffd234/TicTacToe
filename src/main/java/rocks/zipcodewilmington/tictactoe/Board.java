package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {

    private Character[][] gameBoard;
    public Board(Character[][] matrix) {
        this.gameBoard = matrix;
    }

    public Boolean isInFavorOfX() {

        return checkWinner('X', gameBoard);
    }

    public Boolean isInFavorOfO() {
        return checkWinner('O', gameBoard);
    }

    private static boolean checkWinner(char player, Character[][] gameBoard){
        // Check from horizontal win
        for(int i = 0; i < 3; i++){
            if (gameBoard[i][0] != ' ' && gameBoard[i][0] == player
                    && gameBoard[i][0] == gameBoard[i][1]
                    && gameBoard[i][1] == gameBoard[i][2]){
                //Winner: 3 across
                return true;
            }
        }

        // Check Vertical for win
        for(int i = 0; i < 3; i++){
            if (gameBoard[0][i] != ' ' && gameBoard[0][i] == player
                    && gameBoard[0][i] == gameBoard[1][i]
                    && gameBoard[1][i] == gameBoard[2][i]){
                //Winner: 3 vertically
                return true;
            }
        }

        // Check for diagonal win
        if(gameBoard[0][0] != ' ' && gameBoard[0][0] == player
                && gameBoard[0][0] == gameBoard[1][1]
                && gameBoard[1][1] == gameBoard[2][2]){
            //Diagonal
            return true;
        }
        if(gameBoard[2][0] != ' '  && gameBoard[2][0] == player
                && gameBoard[2][0] == gameBoard[1][1]
                && gameBoard[1][1] == gameBoard[0][2]){
            return true;
        }

        return false;
    }

    public Boolean isTie() {
        return getWinner().isEmpty();
    }

    public String getWinner() {
        if(isInFavorOfO()){
            return "O";
        }
        else if(isInFavorOfX()){
            return "X";
        }
        return "";
    }

}
