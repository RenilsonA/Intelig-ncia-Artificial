package Outro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Node implements Comparable<Node> {

    private static int idCounter = 1;
    public int estacao;
    public Node parente = null;
    public List<Edge> vizinhos;
    public double f = Double.MAX_VALUE;
    public double g = Double.MAX_VALUE;
    public int identific; 

    Node(int identific){
        this.identific = identific;
        this.estacao = idCounter++;
        this.vizinhos = new ArrayList<>();
    }

    public int compareTo(Node n) {
        return Double.compare(this.f, n.f);
    }

    public static class Edge {
        Edge(int peso, Node node){
              this.peso = peso;
              this.node = node;
        }
        public int peso;
        public Node node;
    }

    public void addBranch(int d, Node node){
        Edge newEdge = new Edge(d, node);
        vizinhos.add(newEdge);
    }

    public int Heuristica(Node target){
        return this.identific;
    }
    
    public static Node aStar(Node origem, Node destino){
        PriorityQueue<Node> closedList = new PriorityQueue<>();
        PriorityQueue<Node> openList = new PriorityQueue<>();
        origem.f = origem.g + origem.Heuristica(destino);
        openList.add(origem);
        while(!openList.isEmpty()){
            Node n = openList.peek();
            if(n == destino)
                return n;
            for(Node.Edge edge : n.vizinhos){
                Node m = edge.node;
                double PesoTotal = n.g + edge.peso;
                if(!openList.contains(m) && !closedList.contains(m)){
                    m.parente = n;
                    m.g = PesoTotal;
                    m.f = m.g + m.Heuristica(destino);
                    openList.add(m);
                } else {
                    if(PesoTotal < m.g){
                        m.parente = n;
                        m.g = PesoTotal;
                        m.f = m.g + m.Heuristica(destino);

                        if(closedList.contains(m)){
                            closedList.remove(m);
                            openList.add(m);
                        }
                    }
                }
            }
            openList.remove(n);
            closedList.add(n);
        }
        return null;
    }

    public static List<Integer> printPath(Node target){
        Node n = target;
        if(n==null)
            return null;
        List<Integer> ids = new ArrayList<>();
        while(n.parente != null){
        	ids.add(n.estacao);
            n = n.parente;
        }
        ids.add(n.estacao);
        Collections.reverse(ids);
        return ids;
    }
}