package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TotalDistanceProblem {

	List<Interval> list;

	public TotalDistanceProblem() {
		list = new ArrayList<Interval>();
	}

	public void addInterval(int x, int y) {
		list.add(new Interval(x, y));
	}

	public int getTotalCoveredLength() {
		Collections.sort(list);

		Stack<Interval> s = new Stack<Interval>();

		s.push(list.get(0));

		for (int i = 0; i < list.size(); i++) {

			Interval interval = s.peek();

			if (interval.y < list.get(i).x) {
				s.push(list.get(i));
			} else if (interval.y < list.get(i).y) {
				interval.y = list.get(i).y;
				s.pop();
				s.push(interval);
			}
		}

		
		int distance = 0;
		while (!s.isEmpty()) {
			Interval interval = s.pop();
			distance += interval.y - interval.x;
		}
		return distance;

	}

	public static class Interval implements Comparable<Interval> {

		int x;
		int y;

		public Interval(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Interval o) {
			return this.x - o.x;
		}

	}

	public static void main(String[] str) {
		TotalDistanceProblem obj = new TotalDistanceProblem();
		obj.addInterval(3, 6);
		obj.addInterval(8, 9);
		obj.addInterval(1, 5);
		System.out.println(obj.getTotalCoveredLength());
	}

}
