interface Graph<T> {
    fun createVertices(data: T): Vertex<T>
    fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double)
    fun addUnDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double)
    fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double)
    fun edges(source: Vertex<T>): ArrayList<Edge<T>>
    fun weight(
        source: Vertex<T>,
        destination: Vertex<T>
    ): Double?
}

enum class EdgeType {
    DIRECTED,
    UNDIRECTED
}