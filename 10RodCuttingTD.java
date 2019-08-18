import java.util.*;

class Main{
    public static void main(String[] args) {
        int length[]={1,2,3,4,5,6,7,8};
        int cost[]={1,5,8,9,10,17,17,20};
        int rodLength=8;
        //We assume that rodCut is a function where it returns the max profit for cutting a rod of length rodLength
        System.out.println("Optimal Cut is "+rodCut(length,cost,rodLength));
    }

    //Example:
    /*
        rodLength=6 and instance of maxPrice=price(2)+rodCut(4) ---(1)
        rodCut of 4 will be recursed into
        for(int i=0;i<4;i++)
            local=price[i]+rodCut(n-i)
        if(global>local)
            global=local
        i.e. in rodCut(4)
        (4,0),(3,1),(2,2) will be explored and max will be returned to (1)
        Say (2,2) gives max profit
        (1) will become 2,2,2
        Say (3,1) gives max Profit
        (1) will become 2,3,1
    */
    private static HashMap<Integer,Integer> lookup = new HashMap<>();
    private static int rodCut(int[] length, int[] cost, int rodLength){
        int maxProfit=Integer.MIN_VALUE;
        int localProfit;
        
        if(rodLength==0)
            return 0;
        if(lookup.containsKey(rodLength))
            return lookup.get(rodLength);
        //i=1 to rodLength will explore 0,1,2,3 (and not 4 as (0,4) is same as (4,0)) 
        for(int i=1;i<=rodLength;i++){
            localProfit=cost[i-1]+rodCut(length, cost, rodLength-i);
            if(maxProfit<localProfit)
                maxProfit=localProfit;
        }
        lookup.put(rodLength, maxProfit);
        return maxProfit;
    }
}