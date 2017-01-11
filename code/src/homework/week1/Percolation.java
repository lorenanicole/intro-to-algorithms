package homework.week1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by lorenamesa on 12/4/16.
 * Homework Week 1 - Percolation
 * http://coursera.cs.princeton.edu/algs4/assignments/percolation.html
 */
public class Percolation {

    private boolean[][] opened; // 2d bool array indicating if site open or closed
    private int size; // size of grid
    private int top = 0; // imaginary top site
    private int bottom; // imaginary bottom site
    private WeightedQuickUnionUF quickUnion; // weightedQuickUnion algorithm

    /**
     * Create n-by-n grid, with all sites blocked
     */
    public Percolation(int n) {
        if (n <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        size = n;
        bottom = size * size + 1;
        quickUnion = new WeightedQuickUnionUF(size * size + 2);
        opened = new boolean[size][size]; // n array of n arrays with default false
    }

    /**
     * open site (row, col) if it is not open already
     *
     * @param row int
     * @param col int
     * @return nothing
     */
    public void open(int row, int col) {
        checkBounds(row, col);
        opened[row - 1][col - 1] = true; // set site to open

        if (row == 1) { // If in the first row, connect the invisible top
            quickUnion.union(getQFId(row, col), top);
        }
        if (row == size) { // If in the last row, connect the invisible bottom
            quickUnion.union(getQFId(row, col), bottom);
        }
        if (row > 1 && isOpen(row - 1, col)) { // If site above is open, connect
            quickUnion.union(getQFId(row, col), getQFId(row - 1, col));
        }
        if (row < size && isOpen(row + 1, col)) { // If site below is open, connect
            quickUnion.union(getQFId(row, col), getQFId(row + 1, col));
        }
        if (col > 1 && isOpen(row, col - 1)) { // If site to left is open, connect
            quickUnion.union(getQFId(row, col), getQFId(row, col - 1));
        }
        if (col < size && isOpen(row, col + 1)) { // If site to right is open, connect
            quickUnion.union(getQFId(row, col), getQFId(row, col + 1));
        }
    }

    /**
     * Is site (row, col) open?
     *
     * @param row int
     * @param col int
     * @return bool
     */
    public boolean isOpen(int row, int col) {
        return opened[row - 1][col - 1];
    }

    /**
     * is site (row, col) full?
     *
     * @param row int
     * @param col int
     * @return bool
     */
    public boolean isFull(int row, int col) {
        checkBounds(row, col);
        return quickUnion.connected(top, getQFId(row, col));
    }

    /**
     * Does the system percolate?
     *
     * @return bool
     */
    public boolean percolates() {
        return quickUnion.connected(top, bottom);
    }

    /**
     * @param row int
     * @param col int
     * @return error only if invalid
     */
    private void checkBounds(int row, int col) {
        if ((row < 1 || row > size) || (col < 1 || col > size)) {
            throw new java.lang.IndexOutOfBoundsException();
        }
    }

    /**
     * @param row int
     * @param col int
     * @return int id of weightedQuickFind
     */
    private int getQFId(int row, int col) {
        return (size * (row - 1)) + col;
    }

    /**
     * test client (optional)
     */
    public static void main(String[] args) {


    }
}
