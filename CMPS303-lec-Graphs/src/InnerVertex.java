
/** A vertex of an adjacency map graph representation. */
private class InnerVertex<V> implements Vertex<V> {
	private V element;
	private Position<Vertex<V>> pos;
	private Map<Vertex<V>, Edge<E>> outgoing, incoming;

	/** Constructs a new InnerVertex instance storing the given element. */
	public InnerVertex(V elem, boolean graphIsDirected) {
		element = elem;
		outgoing = new ProbeHashMap<>();
		if (graphIsDirected)
			incoming = new ProbeHashMap<>();
		else
			incoming = outgoing; // if undirected, alias outgoing map
	}

	/** Returns the element associated with the vertex. */
	public V getElement() {
		return element;
	}

	/** Stores the position of this vertex within the graph's vertex list. */
	public void setPosition(Position<Vertex<V>> p) {
		pos = p;
	}

	/** Returns the position of this vertex within the graph's vertex list. */
	public Position<Vertex<V>> getPosition() {
		return pos;
	}

	/** Returns reference to the underlying map of outgoing edges. */
	public Map<Vertex<V>, Edge<E>> getOutgoing() {
		return outgoing;
	}

	/** Returns reference to the underlying map of incoming edges. */
	public Map<Vertex<V>, Edge<E>> getIncoming() {
		return incoming;
	}
} // ------------ end of InnerVertex class ------------

/** An edge between two vertices. */
private class InnerEdge<E> implements Edge<E> {
	private E element;
	private Position<Edge<E>> pos;
	private Vertex<V>[] endpoints;

	/** Constructs InnerEdge instance from u to v, storing the given element. */
	public InnerEdge(Vertex<V> u, Vertex<V> v, E elem) {
		element = elem;
		endpoints = (Vertex<V>[]) new Vertex[] { u, v }; // array of length 2
	}

	/** Returns the element associated with the edge. */
	public E getElement() {
		return element;
	}

	/** Returns reference to the endpoint array. */
	public Vertex<V>[] getEndpoints() {
		return endpoints;
	}

	/** Stores the position of this edge within the graph's vertex list. */
	public void setPosition(Position<Edge<E>> p) {
		pos = p;
	}

	/** Returns the position of this edge within the graph's vertex list. */
	public Position<Edge<E>> getPosition() {
		return pos;
	}
} // ------------ end of InnerEdge class ------------