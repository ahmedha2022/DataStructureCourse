
public class ComputeShortPath {

	public static void main(String[] args) {



		 1 /** Computes shortest-path distances from src vertex to all reachable vertices of g. */
		 2 public static <V> Map<Vertex<V>, Integer>
		 3 shortestPathLengths(Graph<V,Integer> g, Vertex<V> src) { 4 // d.get(v) is upper bound on distance from src to v
		 5 Map<Vertex<V>, Integer> d = new ProbeHashMap<>( );
		 6 // map reachable v to its d value
		 7 Map<Vertex<V>, Integer> cloud = new ProbeHashMap<>( );
		 8 // pq will have vertices as elements, with d.get(v) as key
		 9 AdaptablePriorityQueue<Integer, Vertex<V>> pq;
		 10 pq = new HeapAdaptablePriorityQueue<>( );
		 11 // maps from vertex to its pq locator
		 12 Map<Vertex<V>, Entry<Integer,Vertex<V>>> pqTokens;
		 13 pqTokens = new ProbeHashMap<>( );
		 14
		 15 // for each vertex v of the graph, add an entry to the priority queue, with
		 16 // the source having distance 0 and all others having infinite distance
		 17 for (Vertex<V> v : g.vertices( )) { 18 if (v == src)
		 19 d.put(v,0);
		 20 else
		 21 d.put(v, Integer.MAX VALUE);
		 22 pqTokens.put(v, pq.insert(d.get(v), v)); // save entry for future updates
		 23 } 24 // now begin adding reachable vertices to the cloud
		 25 while (!pq.isEmpty( )) { 26 Entry<Integer, Vertex<V>> entry = pq.removeMin( );
		 27 int key = entry.getKey( );
		 28 Vertex<V> u = entry.getValue( );
		 29 cloud.put(u, key); // this is actual distance to u
		 30 pqTokens.remove(u); // u is no longer in pq
		 31 for (Edge<Integer> e : g.outgoingEdges(u)) { 32 Vertex<V> v = g.opposite(u,e);
		 33 if (cloud.get(v) == null) { 34 // perform relaxation step on edge (u,v)
		 35 int wgt = e.getElement( );
		 36 if (d.get(u) + wgt < d.get(v)) { // better path to v?
		 37 d.put(v, d.get(u) + wgt); // update the distance
		 38 pq.replaceKey(pqTokens.get(v), d.get(v)); // update the pq entry
		 39 } 40 } 41 } 42 } 43 return cloud; // this only includes reachable vertices
		 44 }
	}

}
