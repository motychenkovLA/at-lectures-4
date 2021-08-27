package tracker;

public enum Priority {
    HIGHEST("Критический"),
    HIGH("Высокий"),
    MEDIUM("Средний"),
    LOW("Низкий"),
    DEFAULT("Не указана");

    private String ruName;

    Priority(String ruName) {
        this.ruName = ruName;
    }

    public String getRuName() {
        return ruName;
    }
}
