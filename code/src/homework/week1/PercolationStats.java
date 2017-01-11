package homework.week1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by lorenamesa on 12/13/16.
 * Homework Week 1 - Percolation
 * http://coursera.cs.princeton.edu/algs4/assignments/percolation.html
 * Run via command: java PercolationStats numberForGridSize numberForTrials
 */
public class PercolationStats {

    private Percolation percolation; // Class that excutes Percolation via WeightedQuickUnion
    private double[] results; // Stores the p* for each trial
    private int numTrials; // Number of trials conducted

    /**
     * perform trials independent experiments on an n-by-n grid
     */
    public PercolationStats(int n, int trials) {
        if (n < 1 || trials < 1) {
            throw new java.lang.IllegalArgumentException();
        }
        numTrials = trials;
        results = new double[n];
        for (int i = 0; i < numTrials; i++) {
            percolation = new Percolation(n);
            int sitesOpened = 0;
            int row = StdRandom.uniform(1, n + 1);
            int col = StdRandom.uniform(1, n + 1);
            while (!percolation.percolates()) {
                if (!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                    sitesOpened++;
                }
            }
            double result = (double) sitesOpened / (n * n);
            results[i] = result;
        }
    }

    /**
     * sample mean of percolation threshold
     */
    public double mean() {
        return StdStats.mean(results);
    }

    /**
     * sample standard deviation of percolation threshold
     */
    public double stddev() {
        return StdStats.stddev(results);
    }

    /**
     * Returns lower bound of the 95% confidence interval.
     */
    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(numTrials));
    }

    /**
     * Returns upper bound of the 95% confidence interval.
     */
    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(numTrials));
    }

    /**
     * test client (described below)
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trial = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, trial);

        String confidence = ps.confidenceLo() + ", " + ps.confidenceHi();
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = " + confidence);

    }
}
