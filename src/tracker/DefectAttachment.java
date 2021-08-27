package tracker;

public class DefectAttachment extends Attachment {
    private int id;

    public DefectAttachment(int id) {
        this.id = id;
    }

    public String toString() {
        return "Ссылка на дефект: " + id;
    }
}
