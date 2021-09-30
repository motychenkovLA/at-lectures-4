package tracker;

public class Repository {
    private Defect[] defectList;
    private int repositorySize;
    private int inputCounter = 0;
    static int counter = 0;

    public Repository(int repositorySize) {
        this.defectList = new Defect[repositorySize];
        this.repositorySize = repositorySize;

    }

    void add(Defect defect) {
        this.defectList[counter] = defect;
        counter++;
    }

    public boolean isFull() {
        return counter >= repositorySize;
    }

    public boolean isEmpty(){
        return counter == 0;
    }

    public Defect[] getDefectsList() {
        Defect[] result = new Defect[counter];
        System.arraycopy(defectList, 0,result, 0, counter);
        return result;
    }

    public int getDefectCount() {
        return counter;
    }
}
