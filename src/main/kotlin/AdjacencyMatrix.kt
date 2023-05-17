class AdjacencyMatrix<T> : Graph<T> {

    private val vertices = arrayListOf<Vertex<T>>()
    private val weights = arrayListOf<ArrayList<Double?>>()

    override fun createVertices(data: T): Vertex<T> {
        val vertex = Vertex(vertices.size, data)
        vertices.add(vertex)
        weights.forEach {
            it.add(null)
        }
        val row = ArrayList<Double?>(vertices.size)
        repeat(vertices.size) {
            row.add(null)
        }
        weights.add(row)
        return vertex
    }

    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double) {
        weights[source.index][destination.index] = weight
    }

    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> {
        val edges = arrayListOf<Edge<T>>()
        (0 until weights.size).forEach { column ->
            val weight = weights[source.index][column]
            if (weight != null) {
                edges.add(Edge(source, vertices[column], weight))
            }
        }
        return edges
    }

    override fun weight(
        source: Vertex<T>,
        destination: Vertex<T>
    ): Double? {
        return weights[source.index][destination.index]
    }

    override fun toString(): String {
        // 1
        val verticesDescription = vertices
            .joinToString(separator = "\n") {
                "${it.index}: ${it.data}"
            }
// 2
        val grid = weights.map { row ->
            buildString {
                (0 until weights.size).forEach { columnIndex ->
                    val value = row[columnIndex]
                    if (value != null) {
                        append("$value\t")
                    } else {
                        append("ø\t\t")
                    }
                }
            }
        }
        val edgesDescription = grid.joinToString("\n")
// 3
        return "$verticesDescription\n\n$edgesDescription"
    }

    override fun addUnDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double) {

    }

    override fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double) {
    }
}
