package tracker;

public enum Priority {
    HIGHEST("Критический"),
    HIGH("Высокий"),
    MEDIUM("Средний"),
    LOW("Низкий");

    private final String ruName;

    Priority(String ruName) {
        this.ruName = ruName;
    }

    public String getRuName() {
        return ruName;
    }
}
