package tracker;

public class DefectAttachment extends Attachment {
    private final int id;

    public DefectAttachment(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\nДефект ссылается на дефект под номером: " + id;
    }
}
