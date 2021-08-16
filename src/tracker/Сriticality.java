package tracker;

public enum Сriticality {
    HIGHEST("Критический"),
    HIGH("Высокий"),
    MEDIUM("Средний"),
    LOW("Низкий"),
    DEFAULT("Не указана");

    private String ruName;

    Сriticality(String ruName) {
        this.ruName = ruName;
    }

    public String getRuName() {
        return ruName;
    }
}
