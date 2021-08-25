package tracker;


public class Defect {
    private static long maxId;
    private long id;
    private String defectSummary;
    private String criticalityDefect;
    private int workMoreWeek;
    private boolean willTakeMoreWeek;
    private Attachment attachment;

    static {
        maxId = -1;
    }

    {
        maxId++;
    }

    public Defect() {
    }
    //Конструктор для задания 5
    public Defect(String defectSummary, String criticalityDefect, int workMoreWeek) {
        this.id = maxId;
        this.defectSummary = defectSummary;
        this.criticalityDefect = criticalityDefect;
        this.workMoreWeek = workMoreWeek;
        willTakeMoreWeek = workMoreWeek > 5;
    }
    //Конструктор для задания 4
    public Defect(long id, String defectSummary, String criticalityDefect, int workMoreWeek) {
        this.id = id;
        this.defectSummary = defectSummary;
        this.criticalityDefect = criticalityDefect;
        this.workMoreWeek = workMoreWeek;
        willTakeMoreWeek = workMoreWeek > 5;
    }
    //Конструктор для задания 6
    public Defect(String defectSummary, String criticalityDefect, int workMoreWeek, Attachment attachment) {
        this.id = maxId;
        this.defectSummary = defectSummary;
        this.criticalityDefect = criticalityDefect;
        this.workMoreWeek = workMoreWeek;
        this.attachment = attachment;
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
                + "\n\rРезюме дефекта:" + defectSummary
                + "\n\rкритичность дефекта: " + criticalityDefect
                + "\n\rожидаемый срок исполнения: " + workMoreWeek
                + "\n\rЗаймет больше рабочей недели? " + willTakeMoreWeek
                + "\n\rВложение:\n\r" + attachment.asString();
    }
}