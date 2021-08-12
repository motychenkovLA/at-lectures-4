package tracker;

public class Defect {
    private static int defectCounter = 0;
    private long id;
    private String resume;
    private String criticality;
    private int daysToFix;
    private Attachment attachment;


    public Defect(String resume, String criticality, int daysToFix, Attachment attachment) {
        this.id = defectCounter;
        this.resume = resume;
        this.criticality = criticality;
        this.daysToFix = daysToFix;
        this.attachment = attachment;
        defectCounter++;
    }

    public String getInfo() {
        return ("\nНомер: " + this.id + "\nРезюме: " + this.resume + "\nСерьезность: "
                + this.criticality + "\nКоличество дней на исправление: " + this.daysToFix + "\n" + attachment.asString()+ "\n");
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

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public static void setDefectCounter(int defectCounter) {
        Defect.defectCounter = defectCounter;
    }
}
