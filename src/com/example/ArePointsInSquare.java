package com.example;

import java.awt.Point;
import java.lang.Math;

public class ArePointsInSquare {

	public static void main(String[] args) {
		Point[] point = new Point[4];

		int minX = Integer.MIN_VALUE;
		int minY = Integer.MIN_VALUE;
		int maxX = Integer.MAX_VALUE;
		int maxY = Integer.MAX_VALUE;

		for (Point p : point) {
			minX = Math.min(minX, p.x);
			maxX = Math.max(maxX, p.x);
			minY = Math.min(minY, p.y);
			maxY = Math.max(maxY, p.y);
		}

		boolean[] found = new boolean[4];
		for (Point p : point) {
			// UL:minX, maxY
			if (p.x == minX && p.y == maxY)
				found[0] = true;
			// UR:maxX, maxY
			if (p.x == maxX && p.y == maxY)
				found[1] = true;
			// LR:maxX, minY
			if (p.x == maxX && p.y == minY)
				found[2] = true;
			// LL:minX, minY
			if (p.x == minX && p.y == minY)
				found[3] = true;
		}
		for (boolean b : found) {
			if (!b) {
				System.out.println("Points don't represent a square.");
				return;
			}
		}

	}

}
