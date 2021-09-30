package tracker;

import tracker.enums.Status;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Transition {

    private Status to;
    private Status from;

    public Transition(Status from, Status to) {
        this.to = to;
        this.from = from;
    }

    public boolean doTransition(Defect defect){
        if (defect.getStatusDefect() == from){
            defect.setStatusDefect(to);
            return true;
        }
        return false;
    }

    public Status getTo() {
        return to;
    }

    public Status getFrom() {
        return from;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transition that = (Transition) o;
        return to == that.to && from == that.from;
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, from);
    }
}
