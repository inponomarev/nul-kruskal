package uk.ac.nulondon.graph;

import java.util.Objects;

public record Edge(String a, String b, int weight) {
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Edge e) {
            return (Objects.equals(a, e.a) && Objects.equals(b, e.b))
                    || (Objects.equals(a, e.b) && Objects.equals(b, e.a));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(a) ^ Objects.hashCode(b);
    }
}
