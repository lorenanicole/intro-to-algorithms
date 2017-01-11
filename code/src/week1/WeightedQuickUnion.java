package week1;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by lorenamesa on 12/4/16.
 */
public class WeightedQuickUnion {
    private int[] id;
    private int[] size;
    private int count;


    public WeightedQuickUnion(int N) {
        count = N;
        id = IntStream.rangeClosed(0, N).toArray();
        size = new int[N];
        Arrays.fill(size, 1);
    }

    private int count() {
        return count; // Return the number of components
    }

    private int root(int i) { // rename this method find!
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
