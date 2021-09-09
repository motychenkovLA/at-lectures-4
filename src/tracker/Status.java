package tracker;

public enum Status {
    OPEN ("Открыт"),
    ASSIGNED ("Назначен"),
    FIXED ("Исправлен"),
    REJECTED ("Отклонен"),
    RETESTING ("Повторное тестирование"),
    VERIFIED ("Проверен"),
    REOPENED ("Переоткрыт"),
    CLOSED ("Закрыт");
    private final String ruName;

    Status (String ruName){
        this.ruName=ruName;
    }

    public String getRuName() {
        return ruName;
    }
}
