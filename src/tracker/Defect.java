package tracker;

public class Defect {
    private int enumeratorDef = 0;
    private long id;
    private String errorSummary;
    private String errorCriticality;
    private int fixDays;
    private Attachment attachment;

    public Defect(String errorSummary, String errorCriticality, int fixDays, Attachment attachment) {
        this.id = enumeratorDef;
        this.errorSummary = errorSummary;
        this.errorCriticality = errorCriticality;
        this.fixDays = fixDays;
        this.attachment = attachment;
        enumeratorDef++;
    }

    public String list() {
        return "Номер дефекта: " + this.id + "| Резюме дефекта: " + this.errorSummary +
                "| Серьезность: " + this.errorCriticality + "| Количество дней на исправление: " +
                this.fixDays + attachment.asString() + "\n";

    }

    public int getEnumeratorDef() {
        return enumeratorDef;
    }

    public long getId() {
        return id;
    }

    public String getErrorSummary() {
        return errorSummary;
    }

    public String getErrorCriticality() {
        return errorCriticality;
    }

    public int getFixDays() {
        return fixDays;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setEnumeratorDef(int enumeratorDef) {
        this.enumeratorDef = enumeratorDef;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setErrorSummary(String errorSummary) {
        this.errorSummary = errorSummary;
    }

    public void setErrorCriticality(String errorCriticality) {
        this.errorCriticality = errorCriticality;
    }

    public void setFixDays(int fixDays) {
        this.fixDays = fixDays;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }
}