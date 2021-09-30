package tracker;

import tracker.enums.Critical;
import tracker.enums.Status;

public class Defect {
    private long id;
    private static long counterId = 0;
    private String defectSummary;
    private Critical criticalityDefect;
    private Status statusDefect;
    private int workMoreWeek;


    private Attachment attachment;


    public void setStatusDefect(Status statusDefect) {
        this.statusDefect = statusDefect;
    }


    public Defect(String defectSummary, Critical criticalityDefect, int workMoreWeek, Attachment attachment) {
        id = counterId++;
        this.defectSummary = defectSummary;
        this.criticalityDefect = criticalityDefect;
        this.workMoreWeek = workMoreWeek;
        this.attachment = attachment;
        this.statusDefect = Status.OPEN;
    }

    public Status getStatusDefect() {
        return statusDefect;
    }

    public int getWorkMoreWeek() {
        return workMoreWeek;
    }

    @Override
    public String toString() {
        return "Defect{" +
                " \n\r Id=" + id +
                ", \n\r defectSummary='" + defectSummary + '\'' +
                ", \n\r criticalityDefect=" + criticalityDefect +
                ", \n\r statusDefect=" + statusDefect +
                ", \n\r workMoreWeek=" + workMoreWeek +
                ", \n\r attachment=" + attachment +
                '}';
    }

    public static int compare (Defect d1, Defect d2){
        if(d1.getWorkMoreWeek() > d2.getWorkMoreWeek())
            return 1;
        return -1;
    }
}