package uk.ac.nulondon.graph;

import java.util.List;

public class GraphBuilder {
    public static Graph usaGraph() {
        return new Graph(
                List.of(
                        new Edge("Seattle", "SF", 807),
                        new Edge("Seattle", "Denver", 1331),
                        new Edge("Seattle", "Chicago", 2097),
                        new Edge("SF", "Denver", 1267),
                        new Edge("SF", "LA", 381),
                        new Edge("LA", "Denver", 1015),
                        new Edge("LA", "KC", 1663),
                        new Edge("LA", "Dallas", 1435),
                        new Edge("Denver", "Chicago", 1003),
                        new Edge("Denver", "KC", 599),
                        new Edge("KC", "Chicago", 533),
                        new Edge("KC", "NY", 1260),
                        new Edge("KC", "Atlanta", 864),
                        new Edge("KC", "Dallas", 496),
                        new Edge("Dallas", "Atlanta", 781),
                        new Edge("Dallas", "Houston", 239),
                        new Edge("Houston", "Atlanta", 810),
                        new Edge("Houston", "Miami", 1187),
                        new Edge("Chicago", "Boston", 983),
                        new Edge("Chicago", "NY", 787),
                        new Edge("Atlanta", "NY", 888),
                        new Edge("Atlanta", "Miami", 661),
                        new Edge("NY", "Boston", 214)
                )
        );
    }

    public static Graph disjointedUsaGraph() {
        return new Graph(
                List.of(
                        new Edge("Seattle", "SF", 807),
                        new Edge("Seattle", "Denver", 1331),
                        new Edge("SF", "Denver", 1267),
                        new Edge("SF", "LA", 381),
                        new Edge("LA", "Denver", 1015),
                        new Edge("KC", "Chicago", 533),
                        new Edge("KC", "NY", 1260),
                        new Edge("KC", "Atlanta", 864),
                        new Edge("KC", "Dallas", 496),
                        new Edge("Dallas", "Atlanta", 781),
                        new Edge("Dallas", "Houston", 239),
                        new Edge("Houston", "Atlanta", 810),
                        new Edge("Houston", "Miami", 1187),
                        new Edge("Chicago", "Boston", 983),
                        new Edge("Chicago", "NY", 787),
                        new Edge("Atlanta", "NY", 888),
                        new Edge("Atlanta", "Miami", 661),
                        new Edge("NY", "Boston", 214)
                )
        );
    }

    public static Graph demoGraph() {
        return new Graph(
                List.of(
                        new Edge("0", "1", 6),
                        new Edge("0", "2", 5),
                        new Edge("1", "2", 8),
                        new Edge("1", "3", 7),
                        new Edge("2", "3", 7),
                        new Edge("1", "4", 10),
                        new Edge("3", "4", 5),
                        new Edge("3", "5", 7),
                        new Edge("2", "5", 12),
                        new Edge("4", "5", 10),
                        new Edge("4", "6", 8),
                        new Edge("5", "6", 8)
                ));
    }
}
