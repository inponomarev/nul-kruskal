package uk.ac.nulondon;

import uk.ac.nulondon.graph.Edge;
import uk.ac.nulondon.graph.Graph;
import uk.ac.nulondon.graph.GraphBuilder;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Set;

public final class App {
    private App() {
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        Graph g = GraphBuilder.demoGraph();

        Set<Edge> mst = g.mst();
        String dot = g.visualize(mst);


        show(dot);
    }


    private static void show(String dot) throws IOException, URISyntaxException {
        String encoded = URLEncoder.encode(dot, "UTF8")
                .replaceAll("\\+", "%20");
        Desktop.getDesktop().browse(
                new URI("https://dreampuf.github.io/GraphvizOnline/#"
                        + encoded));
    }
}
