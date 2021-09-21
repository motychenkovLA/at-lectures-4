package tracker;

public enum Criticality {
    BLOCKER("Блокирующий"),
    CRITICAL("Критический"),
    MAJOR("Значительный"),
    MINOR("Незначительный"),
    TRIVIAL("Тривиальный");


    private String ruName;

    Criticality(String ruName) {
        this.ruName = ruName;
    }

    public String getRuName() {
        return ruName;
    }
}
