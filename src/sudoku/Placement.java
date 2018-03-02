package sudoku;

public class Placement {

    /**     i - x
     *      j - y
     *
     * */


    /**
     * isLegal
     * @returns true if placement is legal, otherwhise false.
     * */
    public static boolean isLegal(int i, int j, int value, Board board) {
        if(boxIsLegal(i, j, value, board) && rowIsLegal(i, j, value, board) && columnIsLegal(i, j, value, board)) return true;
        return false;

    }

    public static boolean boxIsLegal(int i, int j, int value, Board board) {
        //Hitta boxen - 0-3 eller 4-6, eller 7-9 - i/3*3 - då kommer du till första.
        //loopa alla tal i boxen - kolla om den redan finns
        //Defined board[x][y]

        int boxXOffset = i/3*3;
        int boxYOffset = j/3*3;

        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 3; x++){
                //check if board[][] equals val
                if(board.get(x+boxXOffset, y+boxYOffset) == value){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean columnIsLegal(int i, int j, int value, Board board) {
        //row fixed and col moving
        for(int y = 0; y < 9; y++){
            if(board.get(i, y) == value){
                return false;
            }
        }
        return true;
    }

    public static boolean rowIsLegal(int i, int j, int value, Board board) {
        //row moving and col fixed
        for(int x = 0; x < 9; x++){
            if(board.get(x, j) == value){
                return false;
            }
        }
        return true;
    }
}
