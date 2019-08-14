import java.util.*;
import java.lang.*;

class Main{
    public static void main(String args[]){
        String a="bab";
        String b="bab";
        System.out.println("Longest Common Subsequence is "+lcs(a.toCharArray(),b.toCharArray()));
    }

    private static int lcs(char[] a,char[] b){
        int p=a.length;
        int q=b.length;
        int lookup[][] = new int[p+1][q+1];
        for(int i=0;i<p;i++)
            lookup[i][0]=0;
        for(int i=0;i<q;i++)
            lookup[0][i]=0;


        for(int i=1;i<=p;i++){
            for(int j=1;j<=q;j++){
                if(a[i-1]==b[j-1])
                    lookup[i][j]=lookup[i-1][j-1]+1;
                else
                    lookup[i][j]=Math.max(lookup[i-1][j], lookup[i][j-1]);
            }
        }
        for(int i=0;i<=p;i++){
            for(int j=0;j<=q;j++){
                System.out.print(lookup[i][j]+" ");
            }
            System.out.println(" ");
        }



        return lookup[p][q];
    }

    
}