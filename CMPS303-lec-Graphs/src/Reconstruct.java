
public class Reconstruct {

	public static void main(String[] args) {

		  /**
		  * Reconstructs a shortest-path tree rooted at vertex s, given distance map d.
		  * The tree is represented as a map from each reachable vertex v (other than s)
		  * to the edge e = (u,v) that is used to reach v from its parent u in the tree.
		  */
		  public static <V> Map<Vertex<V>,Edge<Integer>>
		  spTree(Graph<V,Integer> g, Vertex<V> s, Map<Vertex<V>,Integer> d) {  Map<Vertex<V>, Edge<Integer>> tree = new ProbeHashMap<>( );
		  for (Vertex<V> v : d.keySet( ))
		  if (v != s)
		  for (Edge<Integer> e : g.incomingEdges(v)) { // consider INCOMING edges
		  Vertex<V> u = g.opposite(v, e);
		  int wgt = e.getElement( );
		  if (d.get(v) == d.get(u) + wgt)
		  tree.put(v, e); // edge is is used to reach v
		  }  return tree;
		 }
		
	}

}
