package com.scaler.dsa.heapOrPriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Problem Description
We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
Here, the distance between two points on a plane is the Euclidean distance.
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).


Problem Constraints
1 <= B <= length of the list A <= 105
-105 <= A[i][0] <= 105
-105 <= A[i][1] <= 105

Input Format
The argument given is list A and an integer B.

Output Format
Return the B closest points to the origin (0, 0) in any order.

Input 1:
 A = [ 
       [1, 3],
       [-2, 2] 
     ]
 B = 1
Input 2:
 A = [
       [1, -1],
       [2, -1]
     ] 
 B = 1

Output 1: [ [-2, 2] ]
Output 2: [ [1, -1] ]

Explanation 1:
 The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
 So one closest point will be [-2,2].

Explanation 2:
 The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
 So one closest point will be [1,-1].
 */
public class BClosestPointsToOrigin {

	static class ClosestPoint {
		int dis;
		ArrayList<Integer> points;

		ClosestPoint(int dis, ArrayList<Integer> points) {
			this.dis = dis;
			this.points = points;
		}
	}

	public static void main(String[] args) {
		int A[][] = { { 1, 3 }, { -2, 2 } };
		int B = 1;
		int res[][] = solve(A, B);
		for (int i = 0; i < res.length; i++)
			System.out.println(Arrays.toString(res[i]));

	}

	public static int[][] solve(int[][] A, int B) {

		if (A.length == 0 || A.length == 1)
			return A;

		Arrays.sort(A, new Comparator<int[]>() {

			@Override
			public int compare(int o1[], int o2[]) {
				long sum1 = o1[0] * o1[0] + o1[1] * o1[1];
				long sum2 = o2[0] * o2[0] + o2[1] * o2[1];

				return sum1 > sum2 ? 1 : -1;
			}
		});

		int res[][] = new int[B][2];
		for (int i = 0; i < B; i++) {
			int p1 = A[i][0];
			int p2 = A[i][1];
			res[i][0] = p1;
			res[i][1] = p2;
		}

		return res;
	}

	public ArrayList<ArrayList<Integer>> solve1(ArrayList<ArrayList<Integer>> A, int B) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		PriorityQueue<ClosestPoint> pq = new PriorityQueue(new Comparator<ClosestPoint>() {
			@Override
			public int compare(ClosestPoint p1, ClosestPoint p2) {
				return p1.dis - p2.dis;
			}
		});

		for (int i = 0; i < A.size(); i++) {
			int x = A.get(i).get(0);
			int y = A.get(i).get(1);
			// calculate the distance of current point from origin and add it to
			// PriorityQueue. it will itself sort it based on distance
			// using custom Comparator
			int dis = x * x + y * y;
			ClosestPoint closestPoint = new ClosestPoint(dis, A.get(i));
			pq.add(closestPoint);
		}

		while (B > 0) {
			ClosestPoint closestPoint = pq.poll();
			res.add(closestPoint.points);
			B--;
		}
		return res;
	}

	public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		// sorts the list based on euclidean distance from origin
		Collections.sort(A, new Comparator<ArrayList<Integer>>() {
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
				long d1 = (long) a.get(0) * a.get(0) + (long) a.get(1) * a.get(1);
				long d2 = (long) b.get(0) * b.get(0) + (long) b.get(1) * b.get(1);
				if (d1 < d2)
					return -1;
				else if (d2 < d1)
					return 1;
				else
					return 0;
			}
		});
		for (int i = 0; i < B; i++) {
			ans.add(A.get(i));
		}
		return ans;
	}

	public ArrayList<ArrayList<Integer>> solve2(ArrayList<ArrayList<Integer>> A, int B) {
		PriorityQueue<Point> pq = new PriorityQueue<Point>(new PointComparator());
		for (ArrayList<Integer> list : A) {
			pq.add(new Point(list.get(0), list.get(1)));
		}
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list;
		for (int i = 1; i <= B; i++) {
			Point p = pq.poll();
			list = new ArrayList<Integer>();
			list.add(p.x);
			list.add(p.y);
			output.add(list);
		}
		return output;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class PointComparator implements Comparator<Point> {
	public int compare(Point o1, Point o2) {
		return Double.compare(dist(o1), dist(o2));
	}

	private double dist(Point p) {
		return Math.sqrt(p.x * p.x + p.y * p.y);
	}
}
