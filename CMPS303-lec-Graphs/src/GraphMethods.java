
public class GraphMethods {

	/** Performs depth-first search of Graph g starting at Vertex u. */
	public static <V, E> void DFS(Graph<V, E> g, Vertex<V> u, Set<Vertex<V>> known, Map<Vertex<V>, Edge<E>> forest) {
		known.add(u); // u has been discovered
		for (Edge<E> e : g.outgoingEdges(u)) { // for every outgoing edge from u
			Vertex<V> v = g.opposite(u, e);
			if (!known.contains(v)) {
				forest.put(v, e); // e is the tree edge that discovered v
				DFS(g, v, known, forest); // recursively explore from v
			}
		}
	}

	/**
	 * Returns an ordered list of edges comprising the directed path from u to v.
	 */
	public static <V, E> PositionalList<Edge<E>> constructPath(Graph<V, E> g, Vertex<V> u, Vertex<V> v,
			Map<Vertex<V>, Edge<E>> forest) {
		PositionalList<Edge<E>> path = new LinkedPositionalList<>();
		if (forest.get(v) != null) { // v was discovered during the search
			Vertex<V> walk = v; // we construct the path from back to front
			while (walk != u) {
				Edge<E> edge = forest.get(walk);
				path.addFirst(edge); // add edge to *front* of path
				walk = g.opposite(walk, edge); // repeat with opposite endpoint
			}
		}
		return path;
	}

	/** Performs DFS for the entire graph and returns the DFS forest as a map. */
	public static <V, E> Map<Vertex<V>, Edge<E>> DFSComplete(Graph<V, E> g) {
		Set<Vertex<V>> known = new HashSet<>();
		Map<Vertex<V>, Edge<E>> forest = new ProbeHashMap<>();
		for (Vertex<V> u : g.vertices())
			if (!known.contains(u))
				DFS(g, u, known, forest); // (re)start the DFS process at u
		return forest;
	}

	/** Performs breadth-first search of Graph g starting at Vertex u. */
	 public static <V,E> void BFS(Graph<V,E> g, Vertex<V> s,
	 Set<Vertex<V>> known, Map<Vertex<V>,Edge<E>> forest) {  PositionalList<Vertex<V>> level = new LinkedPositionalList<>( );
	 known.add(s);
	 level.addLast(s); // first level includes only s
	 while (!level.isEmpty( )) {  PositionalList<Vertex<V>> nextLevel = new LinkedPositionalList<>( );
	 for (Vertex<V> u : level)
	 for (Edge<E> e : g.outgoingEdges(u)) { 11 Vertex<V> v = g.opposite(u, e);
	 if (!known.contains(v)) {  known.add(v);
	 forest.put(v, e); // e is the tree edge that discovered v
	 nextLevel.addLast(v); // v will be further considered in next pass
	 }  }  level = nextLevel; // relabel ’next’ level to become the current
	 }  }

	/** Converts graph g into its transitive closure. */
	public static <V, E> void transitiveClosure(Graph<V, E> g) {
		for (Vertex<V> k : g.vertices())
			for (Vertex<V> i : g.vertices())
				// verify that edge (i,k) exists in the partial closure
				if (i != k && g.getEdge(i, k) != null)
					for (Vertex<V> j : g.vertices())
						// verify that edge (k,j) exists in the partial closure
						if (i != j && j != k && g.getEdge(k, j) != null)
							// if (i,j) not yet included, add it to the closure
							if (g.getEdge(i, j) == null)
								g.insertEdge(i, j, null);
	}

	/** Returns a list of verticies of directed acyclic graph g in topological order. */
	  public static <V,E> PositionalList<Vertex<V>> topologicalSort(Graph<V,E> g) {  // list of vertices placed in topological order
	  PositionalList<Vertex<V>> topo = new LinkedPositionalList<>( );
	  // container of vertices that have no remaining constraints
	  Stack<Vertex<V>> ready = new LinkedStack<>( );
	  // map keeping track of remaining in-degree for each vertex
	  Map<Vertex<V>, Integer> inCount = new ProbeHashMap<>( );
	  for (Vertex<V> u : g.vertices( )) {  inCount.put(u, g.inDegree(u)); // initialize with actual in-degree
	  if (inCount.get(u) == 0) // if u has no incoming edges,
	  ready.push(u); // it is free of constraints
	  } 14 while (!ready.isEmpty( )) {  Vertex<V> u = ready.pop( );
	  topo.addLast(u);
	  for (Edge<E> e : g.outgoingEdges(u)) { // consider all outgoing neighbors of u
	  Vertex<V> v = g.opposite(u, e);
	  inCount.put(v, inCount.get(v) - 1); // v has one less constraint without u
	  if (inCount.get(v) == 0)
	  ready.push(v);
	  }  }  return topo;
	  }

}