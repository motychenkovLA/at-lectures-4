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

    String getAll() {
        StringBuilder list = new StringBuilder();
        if (counter == 0) {
            list = new StringBuilder("Дефекты отсутствуют.\n");
        } else {
            while (inputCounter < counter) {
                list.append(defectList[inputCounter].getInfoOfDefect());
                inputCounter++;
            }
            inputCounter = 0;
        }
        return list.toString();
    }

    public boolean isFull() {
        return counter == repositorySize;
    }

    public Defect[] getDefectsList() {
        return defectList;
    }

    public void setDefectsList(Defect[] defectsList) {
        this.defectList = defectList;
    }
}
