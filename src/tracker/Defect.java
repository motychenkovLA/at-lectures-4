package tracker;

public class Defect {
    private static int defectCounter = 0;
    private final long id;
    private String resume;
    private Сriticality criticality;
    private int daysToFix;
    private Attachment attachment;
    private Status status;


    public Defect(String resume, Сriticality criticality, int daysToFix, Attachment attachment) {
        this.id = defectCounter;
        this.resume = resume;
        this.criticality = criticality;
        this.daysToFix = daysToFix;
        this.attachment = attachment;
        this.status = Status.OPEN;
        defectCounter++;
    }

    public String getInfo() {
        return ("\nНомер: " + this.id + "\nРезюме: " + this.resume + "\nСерьезность: "
                + this.criticality.getRuName() + "\nКоличество дней на исправление: " + this.daysToFix + "\n" + attachment + "\nСтатус: " + this.status.getRuName() + "\n");
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
