package class3;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.DefaultGraph;

public class GraphDirected {
    public static void main(String[] args) {
        Graph graph = montaGrafo();
        graph.addAttribute("ui.stylesheet",estilos());

        graph.display();
        while(graph.getNodeIterator().hasNext()) {
            Node nodeDeletar = null;
            for (Node node: graph.getEachNode()) {
                if(node.getInDegree() == 0) {
                    nodeDeletar = node;
                    System.out.println(node.getLabel("ui.label"));
                    break;
                }
            }
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            graph.removeNode(nodeDeletar);
            System.out.println("---------");
        }
    }

    public static Graph montaGrafo() {
        Graph graph = new DefaultGraph("Aula 04 - Exercicio");

        graph.addNode("1").addAttribute("ui.label", "Programação para Web");
        graph.addNode("2").addAttribute("ui.label", "POO");
        graph.addNode("3").addAttribute("ui.label", "Algoritimos I");
        graph.addNode("4").addAttribute("ui.label", "Algoritimos II");
        graph.addNode("5").addAttribute("ui.label", "Grafos");
        graph.addNode("6").addAttribute("ui.label", "Tópicos Avançados de Programação");
        graph.addNode("7").addAttribute("ui.label", "Prog. Dispositivos Moveis");
        graph.addNode("8").addAttribute("ui.label", "Estrutura de Dados");
        graph.addNode("9").addAttribute("ui.label", "Banco de Dados");
        graph.addNode("10").addAttribute("ui.label", "Processamento Digital de Imagens");
        graph.addNode("11").addAttribute("ui.label", "Noções de Algebra Linear");
        graph.addNode("12").addAttribute("ui.label", "Tradução de Linguagens de Programação");
        graph.addNode("13").addAttribute("ui.label", "Teoria das Linguages Formais");


        graph.addEdge("1-7", "1", "7", true);

        graph.addEdge("2-1", "2", "1", true);
        graph.addEdge("2-6", "2", "6", true);
        graph.addEdge("2-9", "2", "9", true);

        graph.addEdge("3-2", "3", "2", true);
        graph.addEdge("3-4", "3", "4", true);
        graph.addEdge("3-8", "3", "8", true);


        graph.addEdge("4-2", "4", "2", true);
        graph.addEdge("4-8", "4", "8", true);

        graph.addEdge("6-8", "6", "8", true);
        graph.addEdge("6-10", "6", "10", true);
        graph.addEdge("6-12", "6", "12", true);

        graph.addEdge("8-5", "8", "5", true);
        graph.addEdge("8-9", "8", "9", true);
        graph.addEdge("8-13", "8", "13", true);

        graph.addEdge("11-9", "11", "9", true);

        graph.addEdge("13-12", "13", "12", true);

        return graph;
    }

    private static String estilos() {
        return   "edge {  "
                + "fill-color: black;"
                + "size: 4px;"
                + "}"

                + "edge.percorrida {  "
                + "fill-color: rgb(200,39,65);"
                + "size: 5px;"
                + "}"

                + "node{"
                + "fill-color: rgb(0,100,255);"
                + "size: 30px, 30px;"
                + "text-color: black;"
                + "text-size: 30;"
                + "text-style:bold;"
                + "}"

                + "node.visitado{"
                + "fill-color: red;"
                + "size: 30px, 30px;"
                + "text-color: black;"
                + "text-size: 30;"
                + "text-style:bold;"
                + "}";
    }
}