package tracker;

public class Repository {
    private Defect[] defectsList;

    public Repository(int defectLimit) {
        this.defectsList = new Defect[defectLimit];
    }

    void add(Defect defect) {
        this.defectsList[Defect.getDefectCounter() - 1] = defect;
    }

    String getAll() {
        String defectsListInfo = "";
        if (Defect.getDefectCounter() == 0) {
            defectsListInfo = "\nВ систему еще не добавлено ни одного дефекта";
        } else {
            for (int i = 0; i < Defect.getDefectCounter(); i++) {
                defectsListInfo += defectsList[i].getInfo();
            }
        }
        return defectsListInfo;
    }

    public Defect[] getDefectsList() {
        return defectsList;
    }

    public void setDefectsList(Defect[] defectsList) {
        this.defectsList = defectsList;
    }
}
