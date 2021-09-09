package tracker;

public class Defect {
    private final long id;
    private final String summary;
    private final String criticality;
    private final int daysToFix;
    private final Attachment attachment;

    public Defect(String summary, String criticality, int daysToFix, Attachment attachment) {
        this.id = Repository.defectCounter;
        this.summary = summary;
        this.criticality = criticality;
        this.daysToFix = daysToFix;
        this.attachment = attachment;
    }

    public String getInfo() {
        return ("-----------------------------------------------------" +
                "\nНомер: " + this.id +
                ".\nРезюме: " + this.summary +
                ".\nКритичность: " + this.criticality +
                ".\nКолличество дней на исправление: " + this.daysToFix +
                attachment.asString() +
                ".\n-----------------------------------------------------\n");
    }

}
