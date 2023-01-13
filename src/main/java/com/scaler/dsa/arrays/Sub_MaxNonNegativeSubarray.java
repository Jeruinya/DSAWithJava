package com.scaler.dsa.arrays;

/*
Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the 
third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
Find and return the required subarray.
NOTE:
    1. If there is a tie, then compare with segment's length and return segment which has maximum length.
    2. If there is still a tie, then return the segment with minimum starting index.

Input Format:
The first and the only argument of input contains an integer array A, of length N.
Output Format:
Return an array of integers, that is a subarray of A that satisfies the given conditions.
Constraints:
1 <= N <= 1e5
-INT_MAX < A[i] <= INT_MAX

Input 1:  A = [1, 2, 5, -7, 2, 3]
Output 1: [1, 2, 5]

Explanation 1:
    The two sub-arrays are [1, 2, 5] [2, 3].
    The answer is [1, 2, 5] as its sum is larger than [2, 3].

Input 2: A = [10, -1, 2, 3, -4, 100]

Output 2: [100]

Explanation 2:
    The three sub-arrays are [10], [2, 3], [100].
    The answer is [100] as its sum is larger than the other two.
    
This problem requires a simple adhoc approach :

Just need to simulate whats stated in the problem.
Can you traverse through the array maintaining the current subset ? Note that the subset becomes invalid as soon as 
you encounter a negative number.

Also, note that you do not need to start again on encountering the negative number. 
You can start from the number next to the negative number.


Loop i = 1 to Array.length :
        IF current element is positive :
                update current sum
                compare max sum with current sum
                update max sum
                update max ranges
        ELSE :
            current sum := 0
            update current ranges.
EndLoop;

return elements of max ranges
 */
import java.util.ArrayList;

public class Sub_MaxNonNegativeSubarray {

	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(-1);
		list.add(2);
		list.add(3);
		list.add(-4);
		list.add(100);

		System.out.println(maxset(list));
	}

	public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
		long maxSum = 0;
		long newSum = 0;
		ArrayList<Integer> maxArray = new ArrayList<Integer>();
		ArrayList<Integer> newArray = new ArrayList<Integer>();
		for (Integer num : A) {
			if (num >= 0) {
				newSum += num;
				newArray.add(num);
			} else {
				newSum = 0;
				newArray = new ArrayList<Integer>();
			}
			if ((maxSum < newSum) || ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
				maxSum = newSum;
				maxArray = newArray;
			}
		}
		return maxArray;
	}
}
