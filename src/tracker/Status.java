package tracker;

public enum Status {
    OPEN("Открыто"),
    FIXED("Исправлено"),
    TESTING("Тестирование"),
    VERIFIED("Исправление подтверждено"),
    CLOSED("Закрыто");

    private String ruName;

    Status(String ruName) {
        this.ruName = ruName;
    }

    public String getRuName() {
        return ruName;
    }
}
