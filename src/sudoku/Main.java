package sudoku;

public class Main {
    public static void main(String[] args) {

        Board evilBoard = BoardExamples.evil();
        Board emptyBoard = BoardExamples.empty();
        Board unsolveable = BoardExamples.unsolvable1();

        Board chosenBoard = unsolveable;

        Sudoku s = new Sudoku(chosenBoard);

        s.printBoard();

        if(s.solve()){
            s.printBoard();
        }else{
            System.out.println("NONE!");
        }
    }
}
