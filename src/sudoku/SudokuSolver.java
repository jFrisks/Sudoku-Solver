package sudoku;

public class SudokuSolver {


    /**---- CONSTRUCTOR ----*/
    public SudokuSolver() {
    }

    /**------- MAIN --------*/
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("0 3 0 0 0 0 0 7 0" + "\n");
        sb.append("6 5 0 9 0 8 0 1 3" + "\n");
        sb.append("0 0 7 0 0 0 9 0 0" + "\n");
        sb.append("0 1 0 0 9 0 0 5 0" + "\n");
        sb.append("0 0 0 4 0 7 0 0 0" + "\n");
        sb.append("0 7 0 0 3 0 0 6 0" + "\n");
        sb.append("0 0 5 0 0 0 1 0 0" + "\n");
        sb.append("3 6 0 5 0 1 0 9 7" + "\n");
        sb.append("0 9 0 0 0 0 0 2 0" + "\n");
        String boardString = sb.toString();

        SudokuSolver s = new SudokuSolver();
        Board board = new Board();
        board.createBoard(boardString);
        /*
        board.set(2, 2, 9);
        board.set(4, 7, 9);
        board.set(8, 5, 9);
        */
        s.printBoard(board);
        s.solve(0, 0, board);
        s.printBoard(board);
    }


    /**----- METHODS ------*/

    /**
     * SOLVE
     * Tries a placement and see if its legal
     * @returns true or false depending if successful
     * Goal is to make whole board successfull and filled up
     * i -> x-axis
     * j -> y-axis
     * */
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
        }

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
        board.set(i, j, 0);        //backtracing, reset cell
        return false;
    }

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


}
