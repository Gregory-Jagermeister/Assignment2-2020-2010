package graphs.freshcode;

import java.util.Iterator;

public class Vertex {
	/*
	 * class Vertex represents a vertex in a graph, containing the vertex label and
	 * other fields
	 * 
	 * contains a list of the vertex's neighbours, giving an adjacency list
	 * representation for the graph
	 */

	Integer id; // Vertex label
	VertexIDList adjs; // List of neighbours
	Boolean marked; // Used to indicate previously visited
	Integer num; // Used by Drozdek to indicate order of visit in traversal
	Integer seed; // Seed for generating pseudo-random numbers
	Integer visits;
	Double weight;
	PseudoRand p; // Class instance for generating pseudo-random numbers

	public Vertex(Integer n, Integer q) {
		// ADDED+: includes pseudo-random init
		// Constructor
		id = n;
		marked = false;
		seed = q;
		p = new PseudoRand(q);
		adjs = new VertexIDList();
		num = 0;
		weight = 0.0;
		visits = 0;
	}

	public void setMarked() {
		marked = true;
	}

	public void setUnmarked() {
		marked = false;
	}

	public boolean isMarked() {
		return marked;
	}

	public void addAdj(Integer n) {
		// Adds a neighbour n to the current vertex
		adjs.push(n);
	}

	public void addAdj(Integer n, Double w) {
		// Adds a neighbour n to the current vertex
		adjs.push(n, w);
	}

	public VertexIDList getAdjs() {
		return adjs;
	}

	public Integer getID() {
		return id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer n) {
		num = n;
	}

	public Double getWeight() {
		return weight;
	}

	public Integer getVisits() {
		return visits;
	}

	public Double getPseudoRandomDouble() {
		// PRE: -
		// POST: returns a pseudorandom double value

		PseudoRand p = new PseudoRand(1);

		return p.genPseudoRandDouble();
	}

	public Integer getPseudoRandomLink() {
		// ADDED
		// PRE: vertex has non-empty adjacency list
		// POST: returns a vertex ID randomly selected from adjacent vertices,
		// according to distribution of edge weights
		// adapted from Sedgewick:
		// http://introcs.cs.princeton.edu/java/16pagerank/RandomSurfer.java.html

		return 0;
	}

	public void print() {
		System.out.print("Node " + id + ":");
		adjs.print();
	}

	public static void main(String[] args) {
		Vertex v = new Vertex(2, 1);
		v.addAdj(3);
		v.addAdj(6);
		v.print();

		System.out.println("testing iterator ...");
		VertexIDList vAdjs = v.getAdjs();
		Iterator<Integer> it = vAdjs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
