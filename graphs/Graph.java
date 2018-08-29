public class Graph {

	//all edges in the graph
	List<Edge> edges;
	//id to vertex map
	Map<Integer, Vertex> vertices;
	boolean isDirected;

	public Graph(boolean isDirected){
		edges = new ArrayList<Edge>();
		vertices = new HashMap<>();
		this.isDirected = isDirected;
	}

	class Vertex {
		int id;
		List<Edge> edges = new ArrayList<>();
		List<Vertex> adjVertices = new ArrayList<>();
	}

	class Edge {
		Vertex vertex1;
		Vertex vertex2;
		boolean isDirected;

		Edge(Vertex v1, Vertex v2, boolean isDirected){
			this.vertex1 = v1;
			this.vertex2 = v2;
			this.isDirected = isDirected;
		}
	}
}