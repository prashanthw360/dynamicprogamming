import java.util.*;
import java.lang.Math;

class Main{
    public static void main(String[] args) {
        int arr[]={10,21,42,54};
        int sum=64;
        System.out.println("Answer is "+subsum(arr,sum,arr.length));
    }

    private static int subsum(int[] arr,int sum,int len){
        int[][] lookup=new int[len+1][sum+1];

        for(int i=0;i<=len;i++){
            lookup[i][0]=1;
        }

        for(int j=1;j<=sum;j++){
            lookup[0][j]=0;
        }
        
        
        
        for(int i=1;i<=len;i++){
            for(int j=1;j<=sum;j++){
                if(j<arr[i-1])
                    lookup[i][j]=lookup[i-1][j];
                if(j>=arr[i-1]){
                    lookup[i][j]=Math.max(lookup[i-1][j], lookup[i-1][j-arr[i-1]]);
                }
                
            }
        }

        for(int i=0;i<=len;i++){
            for(int j=0;j<=sum;j++){
                System.out.print(lookup[i][j]+" ");
            }
            System.out.println(" ");
        
    }
    return lookup[len][sum]; 
}

}
