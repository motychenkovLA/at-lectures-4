package tracker;

public enum Status {
    OPEN("Открыто"),
    ASSIGNED("Назначено на исполнителя"),
    FIXED("Исправлено"),
    VERIFIED("Исправление подтверждено"),
    CLOSED("Закрыто");

    private final String ruName;

    Status(String ruName) {
        this.ruName = ruName;
    }

    public String getRuName() {
        return ruName;
    }
}
