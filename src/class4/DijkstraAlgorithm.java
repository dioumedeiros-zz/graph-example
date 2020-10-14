package class4;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class DijkstraAlgorithm {

    public static Graph exampleGraph() {
        Graph g = new SingleGraph("example");

        g.addNode("A").addAttribute("xy", 0, 1);
        g.addNode("B").addAttribute("xy", 1, 2);
        g.addNode("C").addAttribute("xy", 1, 1);
        g.addNode("D").addAttribute("xy", 1, 0);
        g.addNode("E").addAttribute("xy", 2, 2);
        g.addNode("F").addAttribute("xy", 2, 1);
        g.addNode("G").addAttribute("xy", 2, 0);

        g.addEdge("AB", "A", "B").addAttribute("custo", 14);
        g.addEdge("AC", "A", "C").addAttribute("custo", 9);
        g.addEdge("AD", "A", "D").addAttribute("custo", 7);
        g.addEdge("BC", "B", "C").addAttribute("custo", 2);
        g.addEdge("CD", "C", "D").addAttribute("custo", 10);
        g.addEdge("BE", "B", "E").addAttribute("custo", 9);
        g.addEdge("CF", "C", "F").addAttribute("custo", 11);
        g.addEdge("DF", "D", "F").addAttribute("custo", 15);
        g.addEdge("EF", "E", "F").addAttribute("custo", 6);

        for (Node n : g)
            n.addAttribute("label", n.getId());

        for (Edge e : g.getEachEdge())
            e.addAttribute("label", "" + (int) e.getNumber("custo"));

        return g;
    }

    public static void main(String[] args) {
        Graph g = exampleGraph();
        g.display(false);

        // Atributo "custo" tem o custo das arestas
        Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, "custo");

        // O caminho mais curto partindo de A para todos os outros vértices
        dijkstra.init(g);
        dijkstra.setSource(g.getNode("A"));
        dijkstra.compute();

        // comprimento de todos os caminhos mais curtos
        for (Node node : g)
            System.out.printf("%s->%s:%10.2f%n", dijkstra.getSource(), node, dijkstra.getPathLength(node));

        // Pinte em azul todos os nós no caminho mais curto de A a B
        for (Node node : dijkstra.getPathNodes(g.getNode("F")))
            node.addAttribute("ui.style", "fill-color: blue;");

        // Color in red all the edges in the shortest path tree
//		for (Edge edge : dijkstra.getTreeEdges())
//			edge.addAttribute("ui.style", "fill-color: red;");

        // Print the shortest path from A to B
//		System.out.println(dijkstra.getPath(g.getNode("B")));

        // Build a list containing the nodes in the shortest path from A to B
        // Note that nodes are added at the beginning of the list
        // because the iterator traverses them in reverse order, from B to A
//		List<Node> list1 = new ArrayList<Node>();
//		for (Node node : dijkstra.getPathNodes(g.getNode("B")))
//			list1.add(0, node);

        // A shorter but less efficient way to do the same thing
//		List<Node> list2 = dijkstra.getPath(g.getNode("B")).getNodePath();

        // cleanup to save memory if solutions are no longer needed
//		dijkstra.clear();

        // Now compute the shortest path from A to all the other nodes
        // but taking the number of nodes in the path as its length
//		dijkstra = new Dijkstra(Dijkstra.Element.NODE, null, null);
//		dijkstra.init(g);
//		dijkstra.setSource(g.getNode("A"));
//		dijkstra.compute();

        // Print the lengths of the new shortest paths
//		for (Node node : g)
//			System.out.printf("%s->%s:%10.2f%n", dijkstra.getSource(), node,
//					dijkstra.getPathLength(node));

        // Print all the shortest paths between A and F
//		Iterator<Path> pathIterator = dijkstra.getAllPathsIterator(g.getNode("F"));
//		while (pathIterator.hasNext())
//			System.out.println(pathIterator.next());

    }
}
