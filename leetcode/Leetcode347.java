import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Leetcode347 {
    class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer,Integer> map = new HashMap<>();

        for(int x: nums){
            if(map.containsKey(x)){
                int val = map.get(x);
                map.put(x,++val);
            }else{
                map.put(x,1);
            }
        }

        TreeMap<Integer,Integer> tmap = new TreeMap<>(map);

        System.out.println(tmap);
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        pq.addAll(map.entrySet());
        for(int i=0; i<k; i++){
           if(pq.isEmpty()) break;
           res[i] = pq.poll().getKey();
        }

        return res;
    }
}
}
