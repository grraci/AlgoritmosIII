import java.util.ArrayList;
import java.util.List;

	public class Graph {
		public List<Edge> graph;
		
		Graph(){
			this.graph = new ArrayList<Edge>();
		}
		
		public List<Edge> getGraph() {
			return graph;
		}

		public void setGraph(List<Edge> graph) {
			this.graph = graph;
		}
				
		public Edge getUniqueValue(String value) {
			for(Edge e : this.graph)
				 if(e.getData().equals(value)){
					 return e;
				 }
			return null;
		}
		
	}