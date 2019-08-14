import java.util.*;
import java.lang.*;

class Main{
    public static void main(String args[]){
        //Multiply matrices 
        //40*20, 20*30, 30*10, 10*30
        int[] arr=new int[]{40,20,30,10,30};
        System.out.println("Answer is "+mChain(arr,0,arr.length-2));
    }

    private static int mChain(int[] arr,int i,int j){
        int finalCost=Integer.MAX_VALUE;
        int cost=0;
        //base case
        if(i==j)
            return 0;
        for(int k=i;k<j;k++){
            cost=mChain(arr, i, k)+mChain(arr, k+1, j)+(arr[i]*arr[k+1]*arr[j+1]);
            if(finalCost>cost)
                finalCost=cost;
        }
        return finalCost;
    }
}