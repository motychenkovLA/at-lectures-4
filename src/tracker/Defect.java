package tracker;

public class Defect {
    private final long id;
    private final String summary;
    private final String priority;
    private final int leadTime;

    public Defect(String summary, String priority, int leadTime) {
        this.id = Repository.counter;
        this.priority = priority;
        this.summary = summary;
        this.leadTime = leadTime;
    }

    public String getInfoOfDefect() {
        return "\n*******************************" +
            "\nНомер дефекта: " + this.id + "\nРезюме дефекта: " + this.summary +
                "\nСерьезность: " + this.priority + "\nКоличество дней на исправление: " +
                this.leadTime;

    }

}
