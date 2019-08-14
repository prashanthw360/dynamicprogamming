import java.util.*;

class Main{
    public static void main(String args[]){
        //Multiply matrices 
        //40*20, 20*30, 30*10, 10*30
        int[] arr=new int[]{40,20,30,10,30};
        System.out.println("Answer is "+mChainBU(arr,arr.length+1,arr.length+1));
    }

    private static int mChainBU(int[] arr,int p, int q){
        int matrix[][] = new int[p+2][q+2];
        for(int i=0;i<=p;i++){
            for(int j=0;j<=q;j++){
                matrix[i][j]=Integer.MAX_VALUE;
                int currCost=0;
                if(i==j || i==0|| j==0)
                    continue;
                for(int k=i;k<j;k++){
                    currCost=matrix[i][k]+matrix[k+1][j]+(arr[i]*arr[k+1]*arr[j+1]);
                    if(matrix[i][j]>currCost)
                        matrix[i][j]=currCost;
                }
            }
        }

        for(int i=0;i<=p;i++){
            for(int j=0;j<=q;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println(" ");
        }

        return 0;
    }
}