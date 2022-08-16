package com.scaler.dsa.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
We are given a list of activities, each activity has a start and end time. We want perform 
max activities assuming max 1 activity in given time period.

Example:
2	-	8	Office
1		2 	Lunch
5	-	8 	Movie
3	-	4 	Sleep
7	-	9	Friends
10		12	Dinner
9		11	Scaler


 */
class Activity {
	// string name;
	int startTime;
	int endTime;

	Activity(int start, int end) {
		startTime = start;
		endTime = end;
	}

	// put a method that returns the 'key' for sorting
	int getEndTime() {
		return endTime;
	}

	void print() {
		System.out.println("start " + startTime + "endTime " + endTime);
	}
}

public class FindMaxNumberOfActivities {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// create an array of objects
		Activity list[] = new Activity[n];
		// read the objects(each activity)
		for (int i = 0; i < n; i++) {
			int s, e;
			s = sc.nextInt();
			e = sc.nextInt();
			list[i] = new Activity(s, e);
		}
		// Algorithm (Java 8 and above)) [KeyExtractor]
		Arrays.sort(list, Comparator.comparing(Activity::getEndTime));
		// Count
		int cnt = 1;
		int endTime = list[0].endTime;
		for (int i = 1; i <= n - 1; i++) {
			if (list[i].startTime >= endTime) {
				list[i].print();
				cnt++;
				endTime = list[i].endTime;
			}
		}
		System.out.println("count " + cnt);
	}
}
