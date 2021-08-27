package tracker;

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

    public String getInfoOfDefect() {
        return "\n*******************************" +
                "\nНомер дефекта: " + this.id + "\nРезюме дефекта: " + this.summary +
                "\nСерьезность: " + this.priority.getRuName() + "\nКоличество дней на исправление: " +
                this.leadTime + "\n" + attachment + "\nСтатус: " + this.status.getRuName() + "\n";

    }


    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
