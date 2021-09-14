package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment {
    private int id;

    public DefectAttachment(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ссылка на дефект: " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefectAttachment that = (DefectAttachment) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
