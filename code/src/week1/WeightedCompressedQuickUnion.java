package week1;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by lorenamesa on 12/4/16.
 */
public class WeightedCompressedQuickUnion {
    private int[] id;
    private int[] size;
    private int count;

    public WeightedCompressedQuickUnion(int N) {
        count = N;
        id = IntStream.rangeClosed(0, N).toArray();
        size = new int[N];
        Arrays.fill(size, 1);
    }

    /*
     * Return the number of components
     */
    private int count() {
        return count;
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; // Update everything in the path to the new subcomponent; flatten tree
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) {
            return;
        }
        if (size[i] < size[j]) { // add smaller tree to root of bigger
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
        count--;
    }
}
