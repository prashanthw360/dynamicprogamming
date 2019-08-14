import java.util.*;
import java.lang.*;

class Main{

    static Map<String, String> hashmap;
    public static void main(String args[]){
        String a="ABCBDAB";
        String b="BDCABA";
        hashmap=new HashMap<>();
        System.out.println(new StringBuilder(lcs(a.toCharArray(),b.toCharArray(),a.length()-1,b.length()-1)).reverse().deleteCharAt(0));
    }

    private static String lcs(char[] a, char[] b,int i,int j){
        if(i<0||j<0)
            return " ";
        String key=i+"|"+j;
        if(!hashmap.containsKey(key)){
            if(a[i]==b[j]){
                
                return (Character.toString(a[i]))+lcs(a,b,i-1,j-1);
            }
            else 
                return Max(lcs(a,b,i-1,j), lcs(a,b,i,j-1));
        }
        return hashmap.get(key);
    }

    static String Max(String a, String b){
        if(a==null || b==null)
            return a==null?b:a;        
        if(a.length()>b.length())
            return a;
        return b;
    }


}