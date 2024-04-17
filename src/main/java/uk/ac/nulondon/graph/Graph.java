package uk.ac.nulondon.graph;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Graph {
    private final Set<Edge> edges = new HashSet<>();

    public Graph(Collection<Edge> edges) {
        this.edges.addAll(edges);
    }

    public List<String> vertices() {
        return edges.stream().flatMap(e -> Stream.of(e.a(), e.b())).distinct().toList();
    }

    public List<Edge> edges() {
        return edges.stream().toList();
    }

    public String visualize() {
        return visualize(Collections.emptySet());
    }

    public String visualize(Set<Edge> highlighted) {
        try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
            pw.println("graph G {");
            pw.println("  rankdir=LR;");
            Map<String, String> vertexNames = new HashMap<>();
            AtomicInteger count = new AtomicInteger();
            for (String vertex : vertices()) {
                String name = vertexNames.computeIfAbsent(vertex, v -> "N" + count.incrementAndGet());
                pw.printf("  %s[label=\"%s\"];%n", name, vertex);
            }
            for (Edge e : edges()) {
                if (highlighted.contains(e)) {
                    pw.printf("  %s--%s[label=%d,color=red,penwidth=4];%n", vertexNames.get(e.a()),
                            vertexNames.get(e.b()), e.weight());
                } else {
                    pw.printf("  %s--%s[label=%d];%n", vertexNames.get(e.a()), vertexNames.get(e.b()), e.weight());
                }
            }
            pw.println("}");
            pw.flush();
            return sw.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Edge> mst() {
        Set<Edge> result = new HashSet<>();
        Map<String, Integer> trees = new HashMap<>();
        /*Create a forest (a set of trees) initially consisting
        of a separate single-vertex tree for each vertex in the input graph.*/
        int count = 1;
        for (String vertex : vertices()) {
            trees.put(vertex, count++);
        }
        /*Sort the graph edges by weight.*/
        List<Edge> edgeList = new ArrayList<>(edges);
        edgeList.sort(Comparator.comparing(Edge::weight));
        /*Loop through the edges of the graph, in ascending sorted order by their weight.*/
        for (Edge edge : edgeList) {
            int aTree = trees.get(edge.a());
            int bTree = trees.get(edge.b());
            //Test whether adding the edge to the current forest would create a cycle
            if (aTree != bTree) {
                //If not, add the edge to the forest, combining two trees into a single tree
                result.add(edge);
                for (Map.Entry<String, Integer> e : trees.entrySet()) {
                    if (bTree == e.getValue()) {
                        e.setValue(aTree);
                    }
                }
            }
        }
        return result;
    }
}
