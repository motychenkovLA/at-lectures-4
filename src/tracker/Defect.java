package tracker;

public class Defect {
    private final long id;
    private final String summary;
    private final Criticality criticality;
    private final int daysToFix;
    private final Attachment attachment;
    private Status status;

    public Defect(String summary, Criticality criticality, int daysToFix, Attachment attachment) {
        this.id = Repository.defectCounter;
        this.status=Status.OPEN;
        this.summary = summary;
        this.criticality = criticality;
        this.daysToFix = daysToFix;
        this.attachment = attachment;
    }

    public String getInfo() {
        return ("-----------------------------------------------------" +
                "\nНомер: " + this.id +
                ".\nСтатус: " + this.status.getRuName() +
                ".\nРезюме: " + this.summary +
                ".\nСерьезность: " + this.criticality.getRuName() +
                ".\nКолличество дней на исправление: " + this.daysToFix +
                attachment.toString() +
                ".\n-----------------------------------------------------\n");
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
