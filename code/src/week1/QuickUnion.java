package week1;

import java.util.stream.IntStream;

/**
 * Created by lorenamesa on 12/4/16.
 */
public class QuickUnion {
    private int[] id;

    public QuickUnion(int N) {
        id = IntStream.rangeClosed(0, N).toArray();
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i]; // Keep looking up parent to find the roo
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q); // Thing that should be unioned with
        id[i] = j; // Update root
    }
}
