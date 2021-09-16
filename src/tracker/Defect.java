package tracker;

public class Defect {
    private static int defectCounter = 0;
    private final long id;
    private String errorSummary;
    private Criticality criticality;
    private int fixDays;
    private Attachment attachment;
    private Status status;

    public Defect(String errorSummary, Criticality criticality, int fixDays, Attachment attachment) {
        this.id = defectCounter;
        this.errorSummary = errorSummary;
        this.criticality = criticality;
        this.fixDays = fixDays;
        this.attachment = attachment;
        this.status = Status.OPEN;
        defectCounter++;
    }

    public String listInfo() {
        return ("Номер дефекта: " + this.id + "| Резюме дефекта: " + this.errorSummary +
                "| Серьезность: " + this.criticality.getRuName() + "| Количество дней на исправление: " +
                this.fixDays + attachment.toString() + "\n" + "Статус: " + this.status.getRuName() + "\n");

    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}