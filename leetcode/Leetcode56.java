import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Leetcode56 {
    class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<ArrayList<Integer>> util = new ArrayList<>();

        for (int[] x : intervals) {
            ArrayList<Integer> inner = new ArrayList<>();
            for (int val : x) {
                inner.add(val);
            }
            util.add(inner);
        }

        util.sort(Comparator.comparing(a -> a.get(0)));

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        int n = util.size();
        for (int i = 0; i < n; i++) {
            starts[i] = util.get(i).get(0);
            ends[i] = util.get(i).get(1);
        }

        System.out.println(Arrays.toString(starts));
        System.out.println(Arrays.toString(ends));

        util.clear();
        int i = 0;

        for (int j = 0; j < intervals.length; j++) {
            util.add(new ArrayList<>(Arrays.asList(starts[j])));
            int maxEnd = ends[j];
            while (j + 1 < intervals.length && maxEnd >= starts[j + 1]) {
                j++;
                if (maxEnd < ends[j]) {
                    maxEnd = ends[j];
                }
            }
            util.get(i).add(maxEnd);
            i++;
        }

        int[][] res = util.stream()
                .map(inner -> inner.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        return res;
    }
}
}
