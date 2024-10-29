
import java.util.Random;

public class Sudoku {
    // creates a board and display field
    public Board board;
    private LandscapeDisplay display;

    // default constructor creates a board with all zeros
    public Sudoku() {
        board = new Board();
        display = new LandscapeDisplay(this.board, 200);

    }

    // creates a board with N already fillled positions
    public Sudoku(int N) {
        board = new Board();
        display = new LandscapeDisplay(this.board, 200);

        // creates random object
        Random random = new Random();

        // while loop that loops until N is less than 0
        while (N > 0) {

            // variables creates random integers for the row, column, and value
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            int value = random.nextInt(8) + 1;

            // if the cell at that random position already has a value continue is called
            if (this.board.grid[row][col].getValue() > 0) { // do we have to check if >9
                continue;
            }

            /*
             * checks that the value at that position is 0 if so checks that if the random
             * value is valid there if so then it sets that cells to that value and locks it
             * lastly takes one away from N
             */
            if (this.board.grid[row][col].getValue() == 0) {
                if (this.board.validValue(row, col, value)) {
                    this.board.grid[row][col].setValue(value);
                    this.board.grid[row][col].setLocked(true);
                    N--;
                }
            }
        }

    }

    // solves the board using back-tracking
    public boolean solve(int delay) {

        // variables created
        int numsLocked = this.board.numLocked();
        int totalCells = 81;

        // creates a stack object
        CellStack stack = new CellStack();

        // while loop that loops as long as the stack size is bigger than number of
        // unlocked cells
        while (stack.size() < (totalCells - numsLocked)) {

            // delays the display of the game by "delay" parameter
            if (delay > 0) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException ex) {
                    System.out.println("Interrupted");
                }
                display.repaint();
            }

            // calls the findBestCell and assings it to a cell object
            Cell cell = this.board.findBestCell();

            // pushes the cell to the stack if it is not null
            if (cell != null) {
                stack.push(cell);

            } else {

                // creates a stuck boolean varaible and sets it to true
                boolean stuck = true;

                // while loop that loops as long as stuck is true and stack size is not equal to
                // 0
                while (stuck && stack.size() != 0) {

                    // pops a cell from the stack and assings it to cell object called poopedCell
                    Cell poppedCell = stack.pop();

                    // for loop goes from the value of the popped cell +1 to 9
                    for (int i = poppedCell.getValue() + 1; i < 10; i++) {

                        // checks if any of the untested values work for the cell
                        if (this.board.validValue(poppedCell.getRow(), poppedCell.getCol(), i)) {

                            /*
                             * if so then it sets the value of that poppedCell to the valid value it also
                             * updates the board with that new value it also pushes the poppedCell back to
                             * the stack next it sets stuck to false since it found a value breaks out of
                             * the for loop since we found a value
                             */

                            poppedCell.setValue(i);
                            this.board.set(poppedCell.getRow(), poppedCell.getCol(), i);
                            stack.push(poppedCell);
                            stuck = false;
                            break;
                        }

                    }

                    // if unable to find a value for that cell it sets it back to zero and back
                    // tracks somemore
                    if (stuck) {
                        poppedCell.setValue(0);
                        this.board.set(poppedCell.getRow(), poppedCell.getCol(), poppedCell.getValue());

                    }
                }
            }

            // if the stack size reaches zero before the board is solved then there is no
            // solution
            if (stack.size() == 0) {
                return false;
            }

        }

        // there is a solution
        return true;

    }

    // Tostring method
    public String toString() {

        return this.board.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        Sudoku sudoku = new Sudoku(3);
        // sudoku.board.read(args[0]);
        // LandscapeDisplay display = new LandscapeDisplay(sudoku.board, 50);
        Thread.sleep(5000);


        System.out.print(sudoku.solve(3));
        // Cell cell1 = sudoku.board.findBestCell();

        // sudoku.board.findBestCell();

        System.out.println(sudoku);

        // System.out.println(sudoku.board.validValue(2, 4, 8));
        // LandscapeDisplay display = new LandscapeDisplay(sudoku.board, 50);
        // System.out.print(sudoku.solve());
        // LandscapeDisplay display = new LandscapeDisplay(sudoku.board, 30);

        // System.out.println(sudoku);
        // System.out.println(sudoku.solve());
        // System.out.println(sudoku.solve());
        // System.out.println(sudoku.solve());
        // System.out.println(sudoku);

    }
}
