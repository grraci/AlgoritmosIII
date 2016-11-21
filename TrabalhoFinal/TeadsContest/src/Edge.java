import java.util.ArrayList;
import java.util.List;

 public class Edge {
	private String data;
	public List<Edge> edges;
	public int depth;
	public boolean explored = false;
	
	Edge(){}
	
	Edge(String data){
		this.data = data;
		this.edges = new ArrayList<Edge>();
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public List<Edge> getEdges() {
		return edges;
	}
	
	public Edge getUniqueValue(String value) {
		for(Edge e : this.edges)
			 if(e.getData().equals(value)){
				 return e;
			 }
		return null;
	}
 }
