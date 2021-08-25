package tracker;


import tracker.enums.Critical;
import tracker.enums.Status;

public class Defect {
    private static long maxId;
    private long id;
    private String defectSummary;
    private Critical criticalityDefect;
    private Status statusDefect;
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

    //Конструктор для задания 6
    public Defect(String defectSummary, Critical criticalityDefect, int workMoreWeek, Attachment attachment) {
        this.id = maxId;
        this.defectSummary = defectSummary;
        this.criticalityDefect = criticalityDefect;
        this.workMoreWeek = workMoreWeek;
        this.attachment = attachment;
        this.statusDefect = Status.OPEN;
    }

    public boolean getWillTakeMoreWeek() {
        return willTakeMoreWeek;
    }

    public String getDefectSummary() {
        return defectSummary;
    }

    public Critical getCriticalityDefect() {
        return criticalityDefect;
    }

    public void setStatusDefect(Status statusDefect) {
        this.statusDefect = statusDefect;
    }

    public Status getStatusDefect() {
        return statusDefect;
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
                + "\n\rСтатус " + statusDefect
                + "\n\rВложение:\n\r" + attachment.toString();
    }
}