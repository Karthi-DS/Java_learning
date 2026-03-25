// package leetcode;

import java.util.Arrays;

class Leetcode787 {

    

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) { 
        int price[] = new int[n];
        boolean set[] = new boolean[n];
        int cost[][] = new int[n][n];


        Arrays.fill(price,Integer.MAX_VALUE);
        price[src] = 0;

        for(int i=0; i<=k;i++){
            int tmp[] = price.clone();

            for(int j=0; j<flights.length;j++){
                int u = flights[j][0];
                int w = flights[j][1];

                if(price[u]==Integer.MAX_VALUE) continue;

                if(tmp[w]>price[u]+flights[j][2]){
                    tmp[w] = price[u]+flights[j][2];
                }
            }
            price = tmp;
        }

        if(price[dst]==Integer.MAX_VALUE) return -1;

        return price[dst];
    }

    public static void main(String[] args) {
        int n = 5,src = 2,dst = 0,k =2;
        int flights[][] = {
    {1, 0, 5},
    {2, 1, 5},
    {3, 0, 2},
    {1, 3, 2},
    {4, 1, 1},
    {2, 4, 1}
};
        Leetcode787 sol = new Leetcode787();
        int price = sol.findCheapestPrice(n, flights, src, dst, k);

        System.out.println("price: "+price);
    }
}
