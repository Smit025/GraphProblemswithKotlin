fun main() {
    val adjacencyList = AdjacencyList<String>().apply {
        val singapore = createVertices("Singapore")
        val tokyo = createVertices("Tokya")
        val detroit = createVertices("Detroit")
        val hongKong = createVertices("Hong Kong")
        val sanFrancisco = createVertices("San Francisco")
        val washington = createVertices("WashingTon,DC")
        val austin = createVertices("Austin Texas")
        val seattle = createVertices("Seattle")
        add(EdgeType.UNDIRECTED, singapore, hongKong, 300.0)
        add(EdgeType.UNDIRECTED, singapore, tokyo, 500.0)
        add(EdgeType.UNDIRECTED, hongKong, tokyo, 250.0)
        add(EdgeType.UNDIRECTED, singapore, sanFrancisco, 600.0)
        add(EdgeType.UNDIRECTED, tokyo, detroit, 450.0)
        add(EdgeType.UNDIRECTED, singapore, washington, 300.0)
        add(EdgeType.UNDIRECTED, detroit, austin, 50.0)
        add(EdgeType.UNDIRECTED, washington, austin, 292.0)
        add(EdgeType.UNDIRECTED, washington, seattle, 277.0)
        add(EdgeType.UNDIRECTED, washington, sanFrancisco, 377.0)
        add(EdgeType.UNDIRECTED, sanFrancisco, seattle, 218.0)
        add(EdgeType.UNDIRECTED, austin, sanFrancisco, 297.0)

        println("San Francisco Outgoing Flights:")
        println("--------------------------------")
        edges(sanFrancisco).forEach { edge ->
            println("from: ${edge.source.data} to: ${edge.destination.data}")
        }
    }
   print(adjacencyList)
}