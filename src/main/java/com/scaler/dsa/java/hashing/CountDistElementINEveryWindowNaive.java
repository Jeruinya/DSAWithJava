package com.scaler.dsa.java.hashing;

public class CountDistElementINEveryWindowNaive
{
    public static void main (String[] args) 
    {
        int arr[] = new int[]{10, 10, 5, 3, 20, 5};
        
        int n = arr.length;
        int k=4;
        printDistinct(arr, n, k);
        
    }
    
    //Here we have to find the number of distinct elements in every window
    //window means we have given window size as k=4 so we have to pick for elements contiguously and check distinct elements in it.
    //So in above array we have {10,10,5,3},{10,5,3,20},{5,3,20,5} windows
    //Distinct elements in each windows are -- 3,4,3
    static void printDistinct(int arr[], int n, int k)
    {
        for(int i=0;i<=n-k;i++){
            int count=0;
            for(int j=0;j<k;j++){
                boolean flag=false;
                for(int p=0;p<j;p++){
                    if(arr[i+j]==arr[i+p])
                    {
                        flag=true;break;
                    }
                }
                if(flag==false)count++;
                
            }
            System.out.print(count+" ");
        }
    }
}
