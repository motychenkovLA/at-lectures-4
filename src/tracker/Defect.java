package tracker;


public class Defect {
    private long id;
    private String defectSummary;
    private String criticalityDefect;
    private int workMoreWeek;
    private boolean willTakeMoreWeek;

    public Defect() {
    }

    public Defect(long id, String defectSummary, String criticalityDefect, int workMoreWeek) {
        this.id = id;
        this.defectSummary = defectSummary;
        this.criticalityDefect = criticalityDefect;
        this.workMoreWeek = workMoreWeek;
        willTakeMoreWeek = workMoreWeek > 5;
    }

    public boolean getWillTakeMoreWeek() {
        return willTakeMoreWeek;
    }

    public String getDefectSummary() {
        return defectSummary;
    }

    public String getCriticalityDefect() {
        return criticalityDefect;
    }

    public int getWorkMoreWeek() {
        return workMoreWeek;
    }

    public long getId() {
        return id;
    }

    public void setDefectSummary(String defectSummary) {
        this.defectSummary = defectSummary;
    }

    public void setCriticalityDefect(String criticalityDefect) {
        this.criticalityDefect = criticalityDefect;
    }

    public void setWorkMoreWeek(int workMoreWeek) {
        this.workMoreWeek = workMoreWeek;
    }
}