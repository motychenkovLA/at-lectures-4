package tracker;


public class Defect {
    private static long maxId;
    private long id;
    private String defectSummary;
    private String criticalityDefect;
    private int workMoreWeek;
    private boolean willTakeMoreWeek;

    static {
        maxId = -1;
    }

    {
        maxId++;
    }

    public Defect() {
    }

    public Defect(String defectSummary, String criticalityDefect, int workMoreWeek) {
        this.id = maxId;
        this.defectSummary = defectSummary;
        this.criticalityDefect = criticalityDefect;
        this.workMoreWeek = workMoreWeek;
        willTakeMoreWeek = workMoreWeek > 5;
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

    @Override
    public String toString() {
        return "\n\rИдентификатор дефекта:" + id
                +"\n\rРезюме дефекта:" + defectSummary
                + "\n\rкритичность дефекта: " + criticalityDefect
                + "\n\rожидаемый срок исполнения: " + workMoreWeek
                + "\n\rЗаймет больше рабочей недели? " + willTakeMoreWeek + "\n\r";
    }
}