package tracker;

public class DefectAttachment extends Attachment{
    private int id;

    @Override
    public String asString() {
        return String.valueOf(id);
    }

    public DefectAttachment(int id) {
        this.id = id;
    }
}
