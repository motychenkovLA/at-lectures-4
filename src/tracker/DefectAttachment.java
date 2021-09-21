package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment{
    private int id;

    public DefectAttachment (int id) {
        this.id = id;
    }

    public String toString() {
        return "Ссылка на дефект: " + id;
    }

    public boolean equals(Object e) {
        if (this==e)return true;
        if (e == null || getClass() != e.getClass()) return false;
        DefectAttachment that = (DefectAttachment) e;
        return id == that.id;
    }

    public int hashCode() {
        return Objects.hash(id);
    }

}
