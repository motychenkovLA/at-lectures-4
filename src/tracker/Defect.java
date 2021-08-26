package tracker;

public class Defect {
    private static int counter = 0;
    private long id;
    private String summary;
    private String priority;
    private int leadTime;

    public Defect(String summary, String priority, int leadTime) {
        this.id = counter;
        this.priority = priority;
        this.summary = summary;
        this.leadTime = leadTime;
        counter++;
    }

    public String getInfoOfDefect() {
        return "\n*******************************" +
            "\nНомер дефекта: " + this.id + "\nРезюме дефекта: " + this.summary +
                "\nСерьезность: " + this.priority + "\nКоличество дней на исправление: " +
                this.leadTime;

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

}
