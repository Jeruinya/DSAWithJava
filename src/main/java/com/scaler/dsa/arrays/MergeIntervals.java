package com.scaler.dsa.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MergeIntervals {

	static Interval interval= new Interval();

	public static void main(String[] args) {
		ArrayList<Interval> intervalsList = new ArrayList<>();
		Interval i1 = new Interval(6, 8);
		Interval i2 = new Interval(1, 9);
		Interval i3 = new Interval(2, 4);
		Interval i4 = new Interval(4, 7);
		intervalsList.add(i1);
		intervalsList.add(i2);
		intervalsList.add(i3);
		intervalsList.add(i4);

		insert(intervalsList);

		ArrayList<Interval> listInterval = insert(intervalsList, interval);

		for (Interval e : listInterval)
			System.out.println(e.start + " -" + e.end);

	}

	public static void insert(ArrayList<Interval> A) {
		int n = A.size();
		Collections.sort(A, new Mycomparator());
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (A.get(index).end >= A.get(i).start) {
				A.get(index).end = Math.max(A.get(index).end, A.get(i).end);
			} else {
				index++;
				A.set(index, A.get(i));
			}
		}
		for (int i = 0; i <= index; i++)
			System.out.println(A.get(i).start + "-" + A.get(i).end);
	}
	//not working
	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		int i = 0;
		int start = newInterval.start;
		int end = newInterval.end;
		int startIndex = -1;
		int endIndex = -1;
		for (Interval in : intervals) {
			if (start >= in.start && start <= in.end)
				startIndex = i;
			if (end >= in.start && end <= in.end)
				endIndex = i;
			i++;
		}
		// endpoints of new interval doesn't lie inside any other interval
		if (startIndex == -1 && endIndex == -1) {
			startIndex = 0;
			for (i = 0; i < intervals.size(); i++) {
				if (start > intervals.get(i).end) {
					startIndex = i + 1;
				}
			}
			endIndex = intervals.size() - 1;
			for (i = intervals.size() - 1; i >= 0; i--) {
				if (end < intervals.get(i).start) {
					endIndex = i - 1;
				}
			}
			// Intervals between startIndex and endIndex lies completely inside new interval
			for (i = startIndex; i <= endIndex; i++) {
				intervals.remove(startIndex);
			}
			intervals.add(startIndex, newInterval);
			return intervals;
		}
		if (startIndex == -1) {
			for (i = intervals.size() - 1; i >= 0; i--) {
				if (start <= intervals.get(i).start)
					startIndex = i;
			}
		}
		if (endIndex == -1) {
			for (i = 0; i < intervals.size(); i++) {
				if (end >= intervals.get(i).end)
					endIndex = i;
			}
		}
		start = Math.min(intervals.get(startIndex).start, start);
		end = Math.max(intervals.get(endIndex).end, end);
		intervals.get(startIndex).start = start;
		intervals.get(startIndex).end = end;
		for (i = startIndex + 1; i <= endIndex; i++) {
			intervals.remove(startIndex + 1);
		}
		return intervals;
	}
}

class Mycomparator implements Comparator<Interval> {

	@Override
	public int compare(Interval o1, Interval o2) {
		Integer i1 = o1.start;
		Integer i2 = o2.start;

		if (i1 > i2)
			return 1;
		else if (i1 < i2)
			return -1;
		else
			return 0;
	}

}
