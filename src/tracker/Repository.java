package tracker;

public class Repository {
    private Defect[] defectsList;
    private int repositorySize;
    private int defectCount = 0;

    public Repository(int repositorySize) {
        this.defectsList = new Defect[repositorySize];
        this.repositorySize = repositorySize;
    }

    public void add(Defect defect) {
        this.defectsList[defectCount] = defect;
        defectCount++;
    }

    public String getAll() {
        StringBuilder defectsListInfo = new StringBuilder();
        if (defectCount == 0) {
            defectsListInfo = new StringBuilder("\nВ систему еще не добавлено ни одного дефекта\n");
        } else {
            for (int i = 0; i < defectCount; i++) {
                defectsListInfo.append(defectsList[i].getInfo());
            }
        }
        return defectsListInfo.toString();
    }

    public boolean isFull() {
        return defectCount == repositorySize;
    }

    public Defect[] getDefectsList() {
        return defectsList;
    }

    public void setDefectsList(Defect[] defectsList) {
        this.defectsList = defectsList;
    }
}
