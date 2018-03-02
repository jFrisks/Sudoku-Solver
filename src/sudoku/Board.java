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
    public void createBoard(String boardString){
        String[] lines = boardString.split("\n");
        int[] array = new int[81];

        int index = 0;
        for(String line: lines){
            String[] numbers = line.split(" ");
            for(String number: numbers){
                array[index] = Integer.parseInt(number);
                index ++;
            }
        }

        index = 0;
        for(int y = 0; y <9; y++) {
            for(int x= 0; x<9; x++) {
                board[x][y] = array[index];
                index++;
            }
        }
    }

}
