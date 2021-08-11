package tracker;

public class Defect {
    private final long id;
    private final String summary;
    private final String criticality;
    private final int daysToFix;

    public Defect(String summary, String criticality, int daysToFix) {
        this.id = Repository.defectCounter;
        this.summary = summary;
        this.criticality = criticality;
        this.daysToFix = daysToFix;
        //defectCounter++;
    }

    public String getInfo() {
        return ("-----------------------------------------------------" +
                "\nНомер: " + this.id +
                ".\nРезюме: " + this.summary +
                ".\nКритичность: " + this.criticality +
                ".\nКолличество дней на исправление: " + this.daysToFix +
                ".\n-----------------------------------------------------\n");
    }


}
