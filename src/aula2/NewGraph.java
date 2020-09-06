package aula2;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

public class NewGraph {
    public static void main(String[] args) throws InterruptedException {

        Graph g = new SingleGraph("Buscas");

        g.addNode("TUBARAO");
        g.addNode("GRAVATAL");
        g.addNode("ARMAZEM");
        g.addNode("BRACO NORTE");
        g.addNode("SAO LUDGERO");
        g.addNode("ORLEANS");
        g.addNode("URUSSANGA");
        g.addNode("LAURO MULLER");
        g.addNode("COCAL SUL");
        g.addNode("CRICIUMA");
        g.addNode("MORRO FUMACA");
        g.addNode("JAGUARUNA");
        g.addNode("LAGUNA");
        g.addNode("ICARA");
        g.addNode("IMBITUBA");

//		GRAFO 1
        g.addEdge("TUBARAO-GRAVATAL", "TUBARAO", "GRAVATAL");
        g.addEdge("TUBARAO-JAGUARUNA", "TUBARAO", "JAGUARUNA");
        g.addEdge("TUBARAO-LAGUNA", "TUBARAO", "LAGUNA");
        g.addEdge("GRAVATAL-ARMAZEM", "GRAVATAL", "ARMAZEM");
        g.addEdge("GRAVATAL-BRACO NORTE", "GRAVATAL", "BRACO NORTE");
        g.addEdge("BRACO NORTE-SAO LUDGERO", "BRACO NORTE", "SAO LUDGERO");
        g.addEdge("SAO LUDGERO-ORLEANS", "SAO LUDGERO", "ORLEANS");
        g.addEdge("ORLEANS-URUSSANGA", "ORLEANS", "URUSSANGA");
        g.addEdge("ORLEANS-LAURO MULLER", "ORLEANS", "LAURO MULLER");
        g.addEdge("URUSSANGA-COCAL SUL", "URUSSANGA", "COCAL SUL");
        g.addEdge("URUSSANGA-MORRO FUMACA", "URUSSANGA", "MORRO FUMACA");
        g.addEdge("LAURO MULLER-CRICIUMA", "LAURO MULLER", "CRICIUMA");
        g.addEdge("COCAL SUL-CRICIUMA", "COCAL SUL", "CRICIUMA");
        g.addEdge("CRICIUMA-MORRO FUMACA", "CRICIUMA", "MORRO FUMACA");
        g.addEdge("CRICIUMA-ICARA", "CRICIUMA", "ICARA");
        g.addEdge("MORRO FUMACA-JAGUARUNA", "MORRO FUMACA", "JAGUARUNA");
        g.addEdge("LAGUNA-IMBITUBA", "LAGUNA", "IMBITUBA");


        g.getNode("TUBARAO").addAttribute("ui.label", "TUBARAO");
        g.getNode("GRAVATAL").addAttribute("ui.label", "GRAVATAL");
        g.getNode("ARMAZEM").addAttribute("ui.label", "ARMAZEM");
        g.getNode("BRACO NORTE").addAttribute("ui.label", "BRACO NORTE");
        g.getNode("SAO LUDGERO").addAttribute("ui.label", "SAO LUDGERO");
        g.getNode("ORLEANS").addAttribute("ui.label", "ORLEANS");
        g.getNode("URUSSANGA").addAttribute("ui.label", "URUSSANGA");
        g.getNode("LAURO MULLER").addAttribute("ui.label", "LAURO MULLER");
        g.getNode("COCAL SUL").addAttribute("ui.label", "COCAL SUL");
        g.getNode("CRICIUMA").addAttribute("ui.label", "CRICIUMA");
        g.getNode("MORRO FUMACA").addAttribute("ui.label", "MORRO FUMACA");
        g.getNode("JAGUARUNA").addAttribute("ui.label", "JAGUARUNA");
        g.getNode("LAGUNA").addAttribute("ui.label", "LAGUNA");
        g.getNode("ICARA").addAttribute("ui.label", "ICARA");
        g.getNode("IMBITUBA").addAttribute("ui.label", "IMBITUBA");

        g.display();
        g.addAttribute("ui.stylesheet",estilos());

        DepthFirstIterator<Node> it = new DepthFirstIterator<Node>  (g.getNode("TUBARAO"));//profundidade
        //BreadthFirstIterator<Node> it = new BreadthFirstIterator<Node>(g.getNode("TUBARAO"));//largura
        generateGraph(it, "ORLEANS");


    }

    private static void generateGraph(DepthFirstIterator<Node> it, String finalNode) throws InterruptedException {
        while(it.hasNext()){
            Node n = it.next();
            n.addAttribute("ui.class", "visitado");
            System.out.print(n.getLabel("ui.label")+"\t");
            for(Edge e: n.getEachEdge()){
                e.addAttribute("ui.class","percorrida");
                Thread.sleep(100);
            }
            if (n.getLabel("ui.label").equals(finalNode)) {
                break;
            }

        }
    }

    public static String estilos() {
        return   "edge {  "
                + " fill-color: black;"
                + " size: 4px;"
                + "}"

                + "edge.percorrida {  "
                + " fill-color: rgb(200,39,65);"
                + " size: 5px;"
                + "}"

                + "node{"
                + " fill-color: rgb(0,100,255);"
                + " size: 30px, 30px;"
                + " text-color: black;"
                + " text-size: 30;"
                + " text-style:bold;"
                + "}"

                + "node.visitado{"
                + " fill-color: red;"
                + " size: 30px, 30px;"
                + " text-color: black;"
                + " text-size: 30;"
                + " text-style:bold;"
                + "}";

    }

}

