package sudoku;

public class Main {
    public static void main(String[] args) {

        SudokuSolver s = new SudokuSolver();

        Board evilBoard = BoardExamples.evil();
        Board emptyBoard = BoardExamples.empty();
        Board unsolveable = BoardExamples.unsolvable1();

        s.printBoard(unsolveable);

        if(s.solve(unsolveable)){
            s.printBoard(unsolveable);
        }else{
            System.out.println("NONE!");
        }
    }
}
