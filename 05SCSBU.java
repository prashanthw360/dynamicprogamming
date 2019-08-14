import java.util.*;
import java.lang.*;

class Main{
    public static void main(String args[]){
        String a="AGGTAB";
        String b="GXTXAYB";
        System.out.println("SC Supersequence is "+scs(a,b));
    }

    private static int scs(String a, String b){
        //Method to Solve in Bottom Up Approach
        /*
            1) Write down the 2D array.
            2) Write down the base cases i.e. fill the table for base cases 
            (here it is: when one string is null)
            3) Observe the algo and write it down as a function.
            4) Fill the table according to the function.
            5) In this way the base cases add up to the final function.
            6) Return the (n,n) matrix cell i.e. the cell which contains the 
            complete problem's representation. 
            That n*n cell contains the answer.
        */
        int la=a.length();
        int lb=b.length();
        int [][]matrix=new int[la+1][lb+1];
        
        for(int i=1;i<=la;i++)
            matrix[i][0]=i;
        for(int i=1;i<=lb;i++)
            matrix[0][i]=i;
        
        for(int i=1;i<=la;i++){
            for(int j=1;j<=lb;j++){
                if(a.charAt(i-1)==b.charAt(j-1))
                    matrix[i][j]=matrix[i-1][j-1]+1;
                else
                    matrix[i][j]=Math.min(matrix[i-1][j], matrix[i][j-1])+1;
            }
        }

        //Printing the SCS matrix
        for(int i=0;i<=la;i++){
            for(int j=0;j<=lb;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println(" ");
        }
        
        return matrix[la][lb];
    }

}