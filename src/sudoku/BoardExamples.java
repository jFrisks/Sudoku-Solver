package sudoku;

public class BoardExamples {
    public static Board evil(){
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

        Board board = new Board();
        board.createBoard(boardString);
        return board;
    }

    public static Board empty(){
        StringBuilder sb = new StringBuilder();
        sb.append("0 0 0 0 0 0 0 0 0" + "\n");
        sb.append("0 0 0 0 0 0 0 0 0" + "\n");
        sb.append("0 0 0 0 0 0 0 0 0" + "\n");
        sb.append("0 0 0 0 0 0 0 0 0" + "\n");
        sb.append("0 0 0 0 0 0 0 0 0" + "\n");
        sb.append("0 0 0 0 0 0 0 0 0" + "\n");
        sb.append("0 0 0 0 0 0 0 0 0" + "\n");
        sb.append("0 0 0 0 0 0 0 0 0" + "\n");
        sb.append("0 0 0 0 0 0 0 0 0" + "\n");
        String boardString = sb.toString();

        Board board = new Board();
        board.createBoard(boardString);
        return board;
    }

    public static Board unsolvable1(){
        StringBuilder sb = new StringBuilder();
        sb.append("1 1 2 0 0 0 0 0 0" + "\n");
        sb.append("0 0 2 0 0 0 0 0 0" + "\n");
        sb.append("0 0 0 0 0 0 0 0 0" + "\n");
        sb.append("0 0 0 0 0 0 0 0 0" + "\n");
        sb.append("0 0 0 0 0 0 0 0 0" + "\n");
        sb.append("0 0 0 0 0 0 0 0 0" + "\n");
        sb.append("0 0 0 0 0 0 0 0 0" + "\n");
        sb.append("0 0 0 0 0 0 0 0 0" + "\n");
        sb.append("0 0 0 0 0 0 0 0 0" + "\n");
        String boardString = sb.toString();

        Board board = new Board();
        board.createBoard(boardString);
        return board;
    }

    public static Board board4(){
        return null;
    }

    public static Board board5(){
        return null;
    }

    public static Board board6(){
        return null;
    }

}
