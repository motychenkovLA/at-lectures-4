package tracker;

import java.util.Objects;

public class CommentAttachment extends Attachment {
    private String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Комментарий: " + comment;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CommentAttachment that = (CommentAttachment) o;
        return comment.equals(that.comment);
    }
    @Override
    public int hashCode() {
        return Objects.hash(comment);
    }
}
