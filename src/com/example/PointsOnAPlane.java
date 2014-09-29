package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Math;

public class PointsOnAPlane {

	private List<Point> listOfPoints;

	private void initializeList() {
		listOfPoints = new ArrayList<Point>();
		listOfPoints.add(new Point(0, 1));
		listOfPoints.add(new Point(0, 2));
		listOfPoints.add(new Point(0, 3));
		listOfPoints.add(new Point(0, 4));
		listOfPoints.add(new Point(0, 5));
	}

	public static void main(String args[]) {
		PointsOnAPlane pp = new PointsOnAPlane();
		pp.initializeList();

		List<Point> list = pp.findNearest(new Point(1, 1), 3);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public List<Point> findNearest(Point p, int m) {
		for (int i = 0; i < listOfPoints.size(); i++) {
			listOfPoints.get(i).setPivot(p);
		}

		Collections.sort(listOfPoints);

		for (int i = 0; i < listOfPoints.size(); i++) {
			System.out.println(listOfPoints.get(i));
		}
		
		return listOfPoints.subList(0, m);
	}

	private static class Point implements Comparable<Point> {
		float x;
		float y;
		Point pivotPoint;

		public Point(float x, float y) {
			this.x = x;
			this.y = y;
		}

		private void setPivot(Point p) {
			pivotPoint = p;
		}

		private Double distanceFromPivot() {
			return Math.pow((Math.pow((this.y - pivotPoint.y), 2) + Math.pow(
					(this.x - pivotPoint.x), 2)), 1 / 2);
		}

		@Override
		public int compareTo(Point o) {
			return this.distanceFromPivot().compareTo(o.distanceFromPivot());
		}

		@Override
		public String toString() {
			return "(" + this.x + "," + this.y + ")";
		}
	}

}
