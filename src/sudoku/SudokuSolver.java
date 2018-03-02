package sudoku;

/**
 *
 */
public class SudokuSolver {


    /*---- CONSTRUCTOR ----*/
    public SudokuSolver() {
    }

    /*------- MAIN --------*/


    /*----- METHODS ------*/

    /**
     * Solves Sudoku
     * Goal is to go through all cells and get to (9,9) and successfully find a value.
     * @param board
     * @return true if successfully solved.
     * */
    public boolean solve(Board board){
        return solve(0, 0, board);
    }

    private boolean solve(int i, int j, Board board) {

        //If row lower than possible -> gone through all rows and succeeded
        if(i >= 9){
            i = 0;
            j ++;
            if(j >= 9){
                return true;
            }
        }

        //skip filled cells
        if(board.get(i, j) != 0) {
            return solve(i+1, j, board);
        }else{
            //try value
            for(int tryValue = 1; tryValue<=9; tryValue++){
                if(Placement.isLegal(i, j, tryValue, board)){
                    board.set(i, j, tryValue);

                    //if the one after works - this also works
                    if (solve(i+1, j, board)){
                        return true;
                    }
                }
            }
        }


        board.set(i, j, 0);        //backtracing, reset cell
        return false;
    }

    /**
     * Prints board and shows it in console
     * @param board     the board you want to print */
    public void printBoard(Board board){
        System.out.println(board.toString());
        /*
        StringBuilder sb = new StringBuilder();

        for(int y = 0; y<9; y++) {
            for(int x = 0; x <9; x++) {
                sb.append(board[x][y] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        */
    }



    /** Placement class
     *  @return true if placement is legal
     * */
    public static class Placement {

        /**
         * Checks if you can place a number in specified cell.
         * @param i     x-pos
         * @param j     y-pos
         * @param board Board object you want to check
         * @param value The value you want to check
         * @return true if it's legal to place the specified value on specified position.
         * */
        public static boolean isLegal(int i, int j, int value, Board board) {
            if(boxIsLegal(i, j, value, board) && rowIsLegal(i, j, value, board) && columnIsLegal(i, j, value, board)) return true;
            return false;

        }

        private static boolean boxIsLegal(int i, int j, int value, Board board) {
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

        private static boolean columnIsLegal(int i, int j, int value, Board board) {
            //row fixed and col moving
            for(int y = 0; y < 9; y++){
                if(board.get(i, y) == value){
                    return false;
                }
            }
            return true;
        }

        private static boolean rowIsLegal(int i, int j, int value, Board board) {
            //row moving and col fixed
            for(int x = 0; x < 9; x++){
                if(board.get(x, j) == value){
                    return false;
                }
            }
            return true;
        }
    }


}
