package com.example;

import java.util.LinkedList;
import java.util.List;

/**
 * @author kass <br/>
 * 
 *         <b> This is a Graph Data Structure using the adjacency list
 *         representation </b>
 * 
 */
public class Graph {

	private List<Edge> edges;
	private List<Vertex> vertices;

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public List<Vertex> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertex> vertices) {
		this.vertices = vertices;
	}

	public void bfs() {
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		queue.add(vertices.get(0));
		while(!queue.isEmpty()){
			
		}
	}

	public static class Edge {
		private Vertex source;
		private Vertex destination;
		private double weight;
		private String id;

		public Edge(String id, double weight, Vertex source, Vertex destination) {
			this.id = id;
			this.weight = weight;
			this.destination = destination;
			this.source = source;
		}

		public Vertex getSource() {
			return source;
		}

		public void setSource(Vertex source) {
			this.source = source;
		}

		public Vertex getDestination() {
			return destination;
		}

		public void setDestination(Vertex destination) {
			this.destination = destination;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	}

	public static class Vertex {
		private String id;
		private String name;
		private List<Vertex> adjecentVertices;

		public Vertex(String id, String name, List<Vertex> adjecentVertices) {
			this.id = id;
			this.name = name;
			this.adjecentVertices = adjecentVertices;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Vertex> getAdjecentVertices() {
			return adjecentVertices;
		}

		public void setAdjecentVertices(List<Vertex> adjecentVertices) {
			this.adjecentVertices = adjecentVertices;
		}

	}

}
