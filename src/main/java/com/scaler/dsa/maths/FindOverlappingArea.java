package com.scaler.dsa.maths;

class Point {

	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class FindOverlappingArea {

	public static void main(String[] args) {
		Point l1 = new Point(10, 20);
		Point r1 = new Point(30, 40);

		Point l2 = new Point(10, 20);
		Point r2 = new Point(30, 40);
		int area = findOverlappingArea(l1, r1, l2, r2);
		System.out.println(area);
	}

	private static int findOverlappingArea(Point l1, Point r1, Point l2, Point r2) {
		int x1 = Math.abs(l1.x - r1.x);
		int y1 = Math.abs(l1.y - r1.y);

		int x2 = Math.abs(l1.x - r2.x);
		int y2 = Math.abs(l1.y - r2.y);

		int complete_area = x1 * y1 + x2 * y2;

		int distinctArea = 0;
		int x_dist = Math.min(r1.x, r2.x) - Math.max(l1.x, l2.x);
		int y_dist = Math.min(r1.y, r2.y) - Math.max(l1.y, l2.y);
		if (x_dist > 0 && y_dist > 0) {
			distinctArea = x_dist * y_dist;
			System.out.println("Area of overlapping part is:"+distinctArea);
		}
		else
			System.out.println("There is no overlapping area found for the given points");

		return complete_area - distinctArea;
	}

}
