package sudoku;

public class Board {
    private int[][] board;

    public Board() {
        board = new int[9][9];
    }

    /**
     * Get value at specified position
     * @param x xpos
     * @param y ypos
     * @return value at specified pos
     * */
    public int get(int x, int y){
        return board[x][y];
    }

    /**
     * Set value at specified postion
     * @param x xpos
     * @param y ypos
     * @param value value to set
     * @return value you set, -1 if input is not between 1-9
     * */
    public int set(int x, int y, int value){
        //TODO: Hantera felinmatning -> returnera -1
        if(value < 0 || value > 9){
            return -1;
        }else{
            return board[x][y] = value;
        }
    }

    /**
     * @return String Creates string of whole board
     * */
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
     * Creates board from string with this structure
     * 9 9 9 0 0 0 0 0 0
     * 9 9 9 0 0 0 0 0 0
     * 9 9 9 0 0 0 0 0 0
     * 9 9 9 0 0 0 0 0 0
     * 9 9 9 0 0 0 0 0 0
     * 9 9 9 0 0 0 0 0 0
     * 9 9 9 0 0 0 0 0 0
     * 9 9 9 0 0 0 0 0 0
     * 9 9 9 0 0 0 0 0 0
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
                set(x, y, array[index]);
                index++;
            }
        }
    }

}
