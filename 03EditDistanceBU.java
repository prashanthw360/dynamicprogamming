import java.util.*;
import java.lang.*;

class Main{
    public static void main(String args[]){
        String a="intention";
        String b="execution";
        System.out.println("Edit Distance is "+editDistance(a.toCharArray(),b.toCharArray()));
    }

    private static int editDistance(char[] a,char[] b){
        int arr[][]=new int[a.length+1][b.length+1];
        
        for(int i=0;i<=a.length;i++){
            for(int j=0;j<=b.length;j++){
                if(i==0 || j==0){
                    if(i==0&&j==0)
                        continue;
                    else if(i==0)
                        arr[i][j]=j;
                    else
                        arr[i][j]=i;
                }

                else if(a[i-1]!=b[j-1]){
                    arr[i][j]=Min(arr[i-1][j],arr[i][j-1],arr[i-1][j-1])+1;
                }
                else{
                    arr[i][j]=arr[i-1][j-1];
                }

            }
            
            }
    
            for(int i=0;i<=a.length;i++){
                for(int j=0;j<=b.length;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println(" ");
            }

        return arr[a.length][b.length];
    }

    private static int Min(int a,int b,int c){
        return a<b?(a<c?a:c):(b<c?b:c);
    }

}
