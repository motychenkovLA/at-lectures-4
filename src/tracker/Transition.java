package tracker;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Transition {
    private final Status from;
    private final Status to;
    static Set<Transition> transitions = new HashSet<>();
    static {
        transitions.add(new Transition(Status.OPEN, Status.FIXED));
        transitions.add(new Transition(Status.FIXED, Status.TESTING));
        transitions.add(new Transition(Status.TESTING, Status.VERIFIED));
        transitions.add(new Transition(Status.VERIFIED, Status.CLOSED));
    }
    public Transition(Status from, Status to) {
        this.from = from;
        this.to = to;

    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transition that = (Transition) o;
        return from == that.from && to == that.to;
    }


    public int hashCode() {
        return Objects.hash(from, to);
    }

    public static boolean isValidTransitions(Transition transition) {
        return transitions.contains(transition);
    }
}
