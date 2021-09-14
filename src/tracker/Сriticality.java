package tracker;

public enum Сriticality {
    HIGHEST("Критический"),
    HIGH("Высокий"),
    MEDIUM("Средний"),
    LOW("Низкий");

    private final String ruName;

    Сriticality(String ruName) {
        this.ruName = ruName;
    }

    public String getRuName() {
        return ruName;
    }
}
