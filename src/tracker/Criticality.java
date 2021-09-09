package tracker;

public enum Criticality {
    BLOCKER ("Блокирующая"),
    CRITICAL ("Критическая"),
    MAJOR ("Значительная"),
    MINOR ("Незначительная"),
    TRIVIAL ("Тривиальная"),
    DEFAULT ("Не указанна");
    private final String ruName;

    Criticality(String ruName){
        this.ruName=ruName;
    }

    public String getRuName() {
        return ruName;
    }
}
