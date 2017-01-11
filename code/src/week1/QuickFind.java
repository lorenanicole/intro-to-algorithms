package week1;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by lorenamesa on 12/4/16.
 */
public class QuickFind {

    private int[] subComponents;

    public QuickFind(int N) {
        subComponents = IntStream.rangeClosed(0, N).toArray();

    }

    public boolean connected(int p, int q) {
        return subComponents[p] == subComponents[q];
    }

    public void union(int p, int q) {
        int pid = subComponents[p];
        int qid = subComponents[q];

        subComponents = Arrays.stream(subComponents)
                .filter(elem -> elem == qid)
                .map(elem -> pid)
                .toArray();
    }
}
