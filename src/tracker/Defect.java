package tracker;

public class Defect {
    private static int defectCounter = 0;
    private long id;
    private String resume;
    private String criticality;
    private int daysToFix;


    public Defect(String resume, String criticality, int daysToFix) {
        this.id = defectCounter;
        this.resume = resume;
        this.criticality = criticality;
        this.daysToFix = daysToFix;
        defectCounter++;
    }

    public String getInfo() {
        return ("\nНомер: " + this.id + "\nРезюме: " + this.resume + "\nСерьезность: "
                + this.criticality + "\nКоличество дней на исправление: " + this.daysToFix + "\n");
    }

    public long getId() {
        return id;
    }

    public String getResume() {
        return resume;
    }

    public String getCriticality() {
        return criticality;
    }

    public int getDaysToFix() {
        return daysToFix;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setCriticality(String criticality) {
        this.criticality = criticality;
    }

    public void setDaysToFix(int daysToFix) {
        this.daysToFix = daysToFix;
    }

    public static int getDefectCounter() {
        return defectCounter;
    }

    public static void setDefectCounter(int defectCounter) {
        Defect.defectCounter = defectCounter;
    }
}
