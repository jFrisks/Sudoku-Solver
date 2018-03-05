package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sudoku.Board;
import sudoku.BoardExamples;
import sudoku.SudokuSolver;

import static org.junit.Assert.*;

public class SudokuSolverTest {
    Board board;
    SudokuSolver solver;

    @Before
    public void setUp() throws Exception {
        solver = new SudokuSolver();
    }

    @After
    public void tearDown() throws Exception {
        board = null;
        solver = null;
    }

    /* Standard
    @Test
    public void solve() throws Exception {
    }

    @Test
    public void printBoard() throws Exception {
    }
    */

    @Test
    public void solveEmpty() throws Exception {
        board = BoardExamples.empty();

        assertTrue("Empty Board Solves", solver.solve(board));
    }

    @Test
    public void unsolvable() throws Exception {
        board = BoardExamples.unsolvable1();

        assertFalse("Board that is not following rules is unsolvable", solver.solve(board));
    }

    @Test
    public void unsolvableThenRemove() throws Exception {
        //1 2 3
        //4 5 6
        //      7
        board = BoardExamples.unsolvable2();

        assertFalse("Board is unsolvable", solver.solve(board));

        board.set(3, 2, 0);

        assertTrue("Board that was unsolvable is now solvable after removing 7", solver.solve(board));
    }

}