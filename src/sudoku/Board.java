package sudoku;

public class Board {
    private int[][] board;

    public Board() {
        board = new int[9][9];
    }

    public int get(int x, int y){
        return board[x][y];
    }

    public int set(int x, int y, int value){
        return board[x][y] = value;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(int y = 0; y<9; y++) {
            for(int x = 0; x <9; x++) {
                sb.append(board[x][y] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    /**
     * 9 9 9 0 0 0 0 0 0
     * 9 9 9 0 0 0 0 0 0
     * 9 9 9 0 0 0 0 0 0
     * 9 9 9 0 0 0 0 0 0
     * 9 9 9 0 0 0 0 0 0
     * 9 9 9 0 0 0 0 0 0
     * 9 9 9 0 0 0 0 0 0
     * 9 9 9 0 0 0 0 0 0
     * 9 9 9 0 0 0 0 0 0
     *
     * */
    public String createBoard(String board){
        String[] lines = board.split("\n");

        for(String line: lines){
            line.split(" ");

            Integer.parseInt(line);
        }
        return "";
    }

}
