package tracker;

public class Defect {
    long id;
    String errorSummary;
    String errorCriticality;
    int fixDays;

    public Defect(long id, String errorSummary, String errorCriticality, int fixDays) {
        this.id = id;
        this.errorSummary = errorSummary;
        this.errorCriticality = errorCriticality;
        this.fixDays = fixDays;
    }

    String list() {
        return "Номер дефекта: " + this.id + "| Резюме дефекта: " + this.errorSummary +
                "| Серьезность: " + this.errorCriticality + "| Количество дней на исправление: " +
                this.fixDays;

    }

}