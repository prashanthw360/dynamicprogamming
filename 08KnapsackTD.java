import java.util.*;
import java.lang.*;

class Main{
    public static void main(String[] args) {
        int[] v = { 20, 5, 10, 40, 15, 25 };
        int[] w = {  1, 2,  3,  8,  7, 4 };
        System.out.println("Max Value is "+knapsack(v,w,v.length-1,10));
    }

    private static int knapsack(int[] v, int[] w, int index, int weight){
        if(index<0)
            return 0;
        if(weight<=0)
            return Integer.MIN_VALUE; //If we do return 0, then the weight would be chosen even  
                //if it is exceeding the limit and 0 would be returned
        return Math.max(v[index]+knapsack(v,w,index-1,weight-w[index]), knapsack(v, w, index-1, weight));

    }
}