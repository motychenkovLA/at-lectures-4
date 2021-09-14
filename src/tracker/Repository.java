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

    public boolean isFull() {
        return defectCount >= repositorySize;
    }

    public boolean isEmpty(){
       return defectCount == 0;
    }

    public Defect[] getDefectsList() {
        Defect[] result = new Defect[defectCount];
        System.arraycopy(defectsList, 0,result, 0, defectCount);
        return result;
    }

    public int getDefectCount() {
        return defectCount;
    }
}
