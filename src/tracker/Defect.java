package tracker;

import java.util.Objects;

public class Defect {
    private static int counter = 0;
    private final long id;
    private String summary;
    private Priority priority;
    private int leadTime;
    private Attachment attachment;
    private Status status;


    public Defect(String summary, Priority priority, int leadTime, Attachment attachment) {
        this.id = counter;
        this.priority = priority;
        this.summary = summary;
        this.leadTime = leadTime;
        this.attachment = attachment;
        this.status = Status.OPEN;
        counter++;
    }

    @Override
    public String toString() {
        return "\n*******************************" +
                "\nНомер дефекта: " + this.id + "\nРезюме дефекта: " + this.summary +
                "\nСерьезность: " + this.priority.getRuName() + "\nКоличество дней на исправление: " +
                this.leadTime + "\n" + attachment + "\nСтатус: " + this.status.getRuName() + "\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        return leadTime == defect.leadTime && summary.equals(defect.summary) && priority == defect.priority && attachment.equals(defect.attachment) && status == defect.status;
    }
    @Override
    public int hashCode() {
        return Objects.hash(summary, priority, leadTime, attachment, status);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
