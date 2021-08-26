package tracker;

public class Defect {
    private static int counter = 0;
    private long id;
    private String summary;
    private String priority;
    private int leadTime;
    private Attachment attachment;


    public Defect(String summary, String priority, int leadTime, Attachment attachment) {
        this.id = counter;
        this.priority = priority;
        this.summary = summary;
        this.leadTime = leadTime;
        this.attachment = attachment;
        counter++;
    }

    public String getInfoOfDefect() {
        return "\n*******************************" +
                "\nНомер дефекта: " + this.id + "\nРезюме дефекта: " + this.summary +
                "\nСерьезность: " + this.priority + "\nКоличество дней на исправление: " +
                this.leadTime + "\n" + attachment.asString() + "\n";

    }

    public static int getCounter() {
        return counter;
    }

    public long getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public String getPriority() {
        return priority;
    }

    public int getLeadTime() {
        return leadTime;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public static void setCounter(int counter) {
        Defect.counter = counter;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setLeadTime(int leadTime) {
        this.leadTime = leadTime;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }
}
