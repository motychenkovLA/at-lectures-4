package tracker;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Transition {
    private final Status from;
    private final Status to;

    public Transition(Status from, Status to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transition that = (Transition) o;
        return from == that.from && to == that.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    public static boolean isValidTransitions(Transition transition) {
        Set<Transition> transitions = new HashSet<>();
        transitions.add(new Transition(Status.OPEN, Status.ASSIGNED));
        transitions.add(new Transition(Status.ASSIGNED, Status.FIXED));
        transitions.add(new Transition(Status.FIXED, Status.VERIFIED));
        transitions.add(new Transition(Status.VERIFIED, Status.CLOSED));
        return transitions.contains(transition);
    }
}