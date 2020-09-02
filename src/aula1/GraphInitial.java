package aula1;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class GraphInitial {

    public static void main(String[] args) {
        Graph graph = new SingleGraph("graph");

        Matrix matrix = new Matrix();
        int[][] mtx = matrix.generateSquareMatrix();

        AddNodes(graph, mtx);
        AddEdges(graph, mtx);

        graph.display();
    }

    private static void AddEdges(Graph graph, int[][] mtx) {
        for (int i = 0; i < mtx.length; i++) {
           int initialNode = i + 1;
            for (int j = 0; j < mtx[i].length; j++) {
                int destinyNode = j + 1;

                boolean hasEdge = isHasEdge(graph, initialNode, destinyNode);
                if (mtx[i][j] == 1 && !hasEdge) {
                    graph.addEdge(initialNode + "-" + destinyNode, String.valueOf(initialNode), String.valueOf(destinyNode));
                }
            }
        }
    }

    private static void AddNodes(Graph graph, int[][] mtx) {
        for (int i = 0; i < mtx.length; i++) {
            graph.addNode(String.valueOf(i+1));
        }
    }

    private static boolean isHasEdge(Graph graph, int initialNode, int destinyNode) {
        Edge edge = graph.getEdge(initialNode + "-" + destinyNode);
        Edge invertEdge = graph.getEdge(destinyNode + "-" + initialNode);
        boolean hasEdge = false;
        if (edge != null || invertEdge != null) {
            hasEdge = true;
        }
        return hasEdge;
    }

}
