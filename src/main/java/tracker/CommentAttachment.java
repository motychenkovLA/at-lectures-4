package tracker;

import java.util.Objects;

public class CommentAttachment extends Attachment{
    private String comment;

    public CommentAttachment (String comment) {
        this.comment = comment;
    }

    public String toString() {
        return "Комментарий к дефекту: " + comment;
    }

    public boolean equals(Object r) {
        if (this==r) return  true;
        if (r==null || this.getClass() !=r.getClass()) return false;
        CommentAttachment that = (CommentAttachment) r;
        return comment.equals(that.comment);

    }
    public int hashCode() {
        return Objects.hash(comment);
    }
}
