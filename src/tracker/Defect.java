package tracker;

public class Defect {
    long id;
    String summary;
    String priority;
    int leadTime;

    public Defect(long id, String summary, String priority, int leadTime) {
        this.id = id;
        this.priority = priority;
        this.summary = summary;
        this.leadTime = leadTime;
    }

    String list() {
        return "Номер дефекта: " + this.id + "| Резюме дефекта: " + this.summary +
                "| Серьезность: " + this.priority + "| Количество дней на исправление: " +
                this.leadTime;

    }

}
