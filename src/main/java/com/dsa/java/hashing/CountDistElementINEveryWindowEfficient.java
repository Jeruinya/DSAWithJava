package com.dsa.java.hashing;

import java.util.HashMap;

public class CountDistElementINEveryWindowEfficient
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
        HashMap<Integer, Integer> m=new HashMap<Integer, Integer>(); 
       
        for (int i = 0; i < k; i++) { 
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1); 
        } 
        System.out.print(m.size()+" "); 

        for (int i = k; i < n; i++) { 
            m.put(arr[i - k],  m.get(arr[i - k]) - 1);
            if (m.get(arr[i - k]) == 0) { 
                m.remove(arr[i-k]); 
            }   
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
            System.out.print(m.size()+" "); 
        } 
    }
}