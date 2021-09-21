package tracker;

import java.util.Objects;

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

    public String toString() {
        return ("Номер дефекта: " + this.id + "| Резюме дефекта: " + this.errorSummary +
                "| Серьезность: " + this.criticality.getRuName() + "| Количество дней на исправление: " +
                this.fixDays + attachment.toString() + "\n" + "Статус: " + this.status.getRuName() + "\n");

    }

    public boolean equals(Object d) {
        if (this==d) return true;
        if (d==null || getClass() != d.getClass()) return false;
        Defect defect = (Defect) d;
        return fixDays==defect.fixDays && errorSummary.equals(defect.errorSummary) && criticality==defect.criticality && attachment.equals(defect.attachment) && status==defect.status;
    }

    public int hashCode() {
        return Objects.hash(errorSummary,criticality,fixDays,attachment,status);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}