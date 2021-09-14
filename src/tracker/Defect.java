package tracker;

import java.util.Objects;

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

    @Override
    public String toString() {
        return ("\nНомер: " + this.id + "\nРезюме: " + this.resume + "\nСерьезность: "
                + this.criticality.getRuName() + "\nКоличество дней на исправление: " + this.daysToFix + "\n" + attachment + "\nСтатус: " + this.status.getRuName() + "\n");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        return daysToFix == defect.daysToFix && resume.equals(defect.resume) && criticality == defect.criticality && attachment.equals(defect.attachment) && status == defect.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(resume, criticality, daysToFix, attachment, status);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
