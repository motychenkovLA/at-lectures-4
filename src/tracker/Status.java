package tracker;

import java.util.HashSet;
import java.util.Set;

public enum Status {
    OPEN("Открыто"),
    ASSIGNED("Назначено на"),
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
